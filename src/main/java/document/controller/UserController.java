package document.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import document.po.UserInfo;
import document.service.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by koyuhau on 2018/4/26.
 */
@Controller
@ResponseBody
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getInfo")
    public Object getInfo(String code,UserInfo userinfo){
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx81ad6819b892ec7f&secret=791088daf3bd77b02e324ae85857089b&js_code="+code+"&grant_type=authorization_code";
        String s = sendGet(url);
        JSONObject jsonObject = JSON.parseObject(s, JSONObject.class);
        String openid = jsonObject.get("openid").toString();
        UserInfo userinfo1 = userService.queryOnebyOpenId(openid);
        //用户已存在，则返回身份角色
        if(userinfo1!=null){
            if(userinfo1.getRole() != null){
                return userinfo1.getRole();
            }else{
                return 0;
            }
        }else{
            //不存在，则保存用户信息
            userinfo.setOpenId(openid);
            userinfo.setRole(0);
            userService.saveUserInfo(userinfo);
            return 0;
        }
    }

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {
        //1.获得一个httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //2.生成一个get请求
        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            //3.执行get请求并返回结果
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            //4.处理结果，这里将结果返回为字符串
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch ( IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

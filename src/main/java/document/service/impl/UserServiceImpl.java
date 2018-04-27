package document.service.impl;

import document.dao.UserInfoMapper;
import document.po.UserInfo;
import document.po.UserInfoExample;
import document.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userinfoMapper;

    @Override
    public int saveUserInfo(UserInfo userinfo) {
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public UserInfo queryOnebyOpenId(String openId) {
        UserInfoExample userinfoExample = new UserInfoExample();
        userinfoExample.createCriteria().andOpenIdEqualTo(openId);
        List<UserInfo> userInfos = userinfoMapper.selectByExample(userinfoExample);
        if(userInfos!=null && userInfos.size()!=0){
            return userInfos.get(0);
        }else{
            return null;
        }
    }
}

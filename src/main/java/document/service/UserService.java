package document.service;



import document.po.UserInfo;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface UserService {

    int saveUserInfo(UserInfo userInfo);

    UserInfo queryOnebyOpenId(String openId);

}

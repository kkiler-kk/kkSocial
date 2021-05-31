package org.kk.service;

import org.kk.bean.User;
import org.kk.util.ErrorCode;
import org.kk.util.RedisUtil;
import org.kk.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kk
 * @Date 2021/1/25
 */
@Service("UserInfoService")
public class UserInfoService {

    @Autowired
    private RedisUtil redisUtil;

    public Integer addAttention(Integer id){
        String strId = String.valueOf(id);
        User user = (User)redisUtil.get(strId);
        boolean b = ToolUtil.checkNumber(user.getName(), redisUtil);
        if (!b) {
            //请求次数过多返回错误码
            return ErrorCode.TOO_MANY;
        }
        user.getUserInfo().setCount_user(user.getUserInfo().getCount_user() + 1);
        redisUtil.set(strId, user, 30 *  (60 * 60) * 24);
        return ErrorCode.SUCCESS;
    }
}

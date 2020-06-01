package com.tcm.quest.service;

import com.tcm.quest.model.UserInfoPress;

public interface UserInfoPressService {
    //插入用户信息、血压等
    int addUserInfoPress(UserInfoPress userInfoPress);

    //查找最后一个用户的id
    int selectLastUserId();
}

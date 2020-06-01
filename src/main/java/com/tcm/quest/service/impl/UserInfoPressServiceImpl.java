package com.tcm.quest.service.impl;

import com.tcm.quest.mapper.QuestionMapper;
import com.tcm.quest.mapper.UserInfoPressMapper;
import com.tcm.quest.model.UserInfoPress;
import com.tcm.quest.service.UserInfoPressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userInfoPressService")
public class UserInfoPressServiceImpl implements UserInfoPressService {
    @Autowired
    private UserInfoPressMapper userInfoPressMapper;
    @Override
    public int addUserInfoPress(UserInfoPress userInfoPress) {
        return userInfoPressMapper.insert(userInfoPress);
    }

    @Override
    public int selectLastUserId() {
        return userInfoPressMapper.selectLastUserId();
    }
}

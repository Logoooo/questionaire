package com.tcm.quest.mapper;

import com.tcm.quest.model.UserInfoPress;

public interface UserInfoPressMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfoPress record);

//    UserInfoPress insertUserInfoPress(UserInfoPress userInfoPress);

    int selectLastUserId();
    int insertSelective(UserInfoPress record);

    UserInfoPress selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfoPress record);

    int updateByPrimaryKey(UserInfoPress record);
}
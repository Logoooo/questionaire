package com.tcm.quest.service;

import com.tcm.quest.model.Question;
import com.tcm.quest.model.UserInfoPress;

public interface QuestService {
    int addQuest(Question question);
//    Question selectLastNumber();

    //查询总得分
    int countScore(int user_id);

}

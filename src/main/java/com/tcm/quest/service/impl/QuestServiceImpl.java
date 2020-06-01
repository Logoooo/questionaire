package com.tcm.quest.service.impl;

import com.tcm.quest.mapper.QuestionMapper;
import com.tcm.quest.model.Question;
import com.tcm.quest.model.UserInfoPress;
import com.tcm.quest.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "questService")
public class QuestServiceImpl implements QuestService {
   @Autowired
   private QuestionMapper questMapper;
    @Override
    public int addQuest(Question question) {
       return questMapper.insert(question);
    }

//    @Override
//    public Question selectLastNumber() {
//
//        return questMapper.selectLastNumber();
//    }

}

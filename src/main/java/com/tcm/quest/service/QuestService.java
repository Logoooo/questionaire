package com.tcm.quest.service;

import com.tcm.quest.model.Question;

public interface QuestService {
    int addQuest(Question question);
    Question selectLastNumber();
}

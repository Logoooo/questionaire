package com.tcm.quest.controller;


import com.alibaba.fastjson.JSONObject;
import com.tcm.quest.model.Question;
import com.tcm.quest.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;

@Controller
@RequestMapping(value = "/quest")
public class QuestController {
    @Autowired
    private QuestService questService;
//    private Question question;
    @ResponseBody
    @PostMapping(value = "/insert",produces = "application/json;charset=UTF-8")
    public int addQuest(@RequestBody String parms){
        //加postdata
        JSONObject jsonObject = JSONObject.parseObject(parms);
        String str = jsonObject.getString("postdata");
        JSONObject jsonObject1 = JSONObject.parseObject(str);
        int number;
        number = questService.selectLastNumber().getNumber();
        if(number != 0){
            number = number+1;
        }else{
            number = 1;
        }
        Iterator iterator = jsonObject1.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey().toString());
            Question question = new Question();
            String[] strArr = entry.getValue().toString().split("\\#");
            System.out.println(strArr[0]);
            System.out.println(strArr[1]);
            question.setQuestion(entry.getKey().toString());
            question.setAnswer(strArr[0]);
            question.setScore(strArr[1]);
            question.setNumber(number);
            questService.addQuest(question);
        }
        //不加postdata
//        JSONObject jsonObject = JSONObject.parseObject(parms);
//        System.out.println(jsonObject);
//
//        Iterator iterator = jsonObject.entrySet().iterator();
//        int number;
//        number = questService.selectLastNumber().getNumber();
//        System.out.println("查询id："+questService.selectLastNumber().getId()+"查询问题为："+questService.selectLastNumber().getQuestion()+"答案为："+questService.selectLastNumber().getAnswer());
//        System.out.println("number的值为："+number);
//        if(number != 0){
//            number = number+1;
//            System.out.println(number);
//        }else{
//            number = 1;
//        }
//
//        while (iterator.hasNext()){
//            Map.Entry entry = (Map.Entry)iterator.next();
//            System.out.println(entry.getKey().toString());
//            Question question = new Question();
//            String[] strArr = entry.getValue().toString().split("\\#");
//            System.out.println(strArr[0]);
//            System.out.println(strArr[1]);
//            question.setQuestion(entry.getKey().toString());
//            question.setAnswer(strArr[0]);
//            question.setScore(strArr[1]);
//            question.setNumber(number);
//            questService.addQuest(question);
//        }
        return 1;
    }
}

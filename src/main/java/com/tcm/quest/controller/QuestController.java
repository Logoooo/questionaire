package com.tcm.quest.controller;


import com.alibaba.fastjson.JSONObject;
import com.tcm.quest.model.Question;
import com.tcm.quest.model.UserInfoPress;
import com.tcm.quest.service.QuestService;
import com.tcm.quest.service.UserInfoPressService;
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
    @Autowired
    private UserInfoPressService userInfoPressService;
//    private Question question;
    @ResponseBody
    @PostMapping(value = "/insert",produces = "application/json;charset=UTF-8")
    public int addQuest(@RequestBody String parms){

        //加postdata
        JSONObject jsonObject = JSONObject.parseObject(parms);


        String str = jsonObject.getString("postdata");
        JSONObject jsonObject1 = JSONObject.parseObject(str);

        String strInfo = jsonObject.getString("info");
        JSONObject jsonObject2 = JSONObject.parseObject(strInfo);

        UserInfoPress userInfoPress = new UserInfoPress();
        Iterator iterator1 = jsonObject2.entrySet().iterator();
        while (iterator1.hasNext()){
            Map.Entry entry = (Map.Entry)iterator1.next();
//            System.out.println(entry.getKey().toString());

            String strArr = entry.getValue().toString();
            System.out.println(strArr);
            if (entry.getKey().equals("name")){
                userInfoPress.setName(entry.getValue().toString());
            }else if (entry.getKey().equals("sex")){
                userInfoPress.setSex(entry.getValue().toString());
            }else if (entry.getKey().equals("press_high")){
                userInfoPress.setPressHigh(Integer.valueOf(entry.getValue().toString()));
            }else if(entry.getKey().equals("press_low")){
                userInfoPress.setPressLow(Integer.valueOf(entry.getValue().toString()));
            }

        }
        System.out.println(userInfoPress);
        //将名字、性别、高压、低压存入数据库，返回userid,转存到问卷表中
        int number = userInfoPressService.addUserInfoPress(userInfoPress);
        //查找最后一个id
        int userid = userInfoPressService.selectLastUserId();
        System.out.println(userid);



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
            question.setUserId(userid);
//            question.setNumber(number);
            System.out.println(question.toString());
            questService.addQuest(question);
        }




       /** Iterator iterator = jsonObject1.entrySet().iterator();
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
        }*/
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

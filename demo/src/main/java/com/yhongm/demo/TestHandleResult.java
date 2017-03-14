package com.yhongm.demo;

import com.yhongm.dynamic_core.ExecuteResponse;
import com.yhongm.dynamic_core.HandleResult;
import com.yhongm.dynamic_core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

/**
 * Created by yhongm on 2017/03/14.
 */

public class TestHandleResult<T> extends HandleResult<T> {
    @Override
    public Response<T> execute() {
        String parameter = HandleParameter();
        long l = System.currentTimeMillis();
        String date = new Date(l).toLocaleString();
        parameter = parameter + "," + date;
        String s = "{\"code\":200,\"msg\":\"success\",\"newslist\":[{\"ctime\":\"2017-03-10\",\"title\":\"闲置旧U盘的妙用！新技能get√！！！\",\"description\":\"360安全卫士\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz\\/ARZUFYCnAWu4pvk48z0MI5y6NlgztstEgXqiaV2P9vtweyB2Vibp0RvY0XvzrEZqZ4yvffUqIXRYb2fLn2UEDEEA\\/0\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s?__biz=MjM5MTA2ODg0MA==&mid=200650033&idx=1&sn=78b9c09021e97592e376497a0e33dad4#rd\"},{\"ctime\":\"2017-03-10\",\"title\":\"首发|你理想中书房的样子\",\"description\":\"壹期壹会\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/5bz7GtcZh6xvsXRSxhL1qXHTVEVdJ11fmMQwrtG13SW0QIdVAf0bZeyRsickJ5icbS56AT2EaXTzSA07ib5GDkIyg\\/0?wx_fmt=jpeg\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/32AVG3kGvZLmqNh3RXsEZg\"},{\"ctime\":\"2017-03-09\",\"title\":\"看完这部国产片，顿时觉得《五十度灰》太小儿科\",\"description\":\"电影铺子\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/3N8gA4Fjgv7bLjgJrHAeOOpVfOxEiajlp9zhiacTF1XibIxLEIiacq6ibOwMZo6aDO1KLOng0EseHPJAjmliaQgvlEAA\\/0?wx_fmt=jpeg\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/FBV3wIAueuoFWz9JAXKlXA\"},{\"ctime\":\"2017-03-09\",\"title\":\"关了灯真的一个样吗？\",\"description\":\"我要WhatYouNeed\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_png\\/zynprs47B4RomkwhjRVJvB6sB6icrgB84zI4MhN7z4K6icr2wMIvrboRpECA7jdvv5WFJC9uPic88zaLUGqzIZ8BQ\\/0?wx_fmt=png\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/oGQSJlt3foTkcVzBduKxIw\"},{\"ctime\":\"2017-03-09\",\"title\":\"一个泳池里有多少尿？大概是100个瓶装水……还要多一点\",\"description\":\"果壳网\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/icZklJrRfHgAmic4fPJYBhfmxM4ngpdTQaMsEicoRaaAUuSuaGqYehn2G5T7Vz9pcMXcXSHkLT9WLas397JjPS1uw\\/0?wx_fmt=jpeg\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/pUp_kr5XjJzBk50MqSjx3Q\"},{\"ctime\":\"2017-03-09\",\"title\":\"我越是想要，越是装作若无其事 | 害怕受伤会让你失去什么\",\"description\":\"新世相\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/5ROs96OaibIm6RStzbxmb4t3c7C63gZSD6oQmYpibvZ1cM3m8ic1stUhkfE4yZfvuswLzDU4iavZMbQbqWUaKuPabw\\/0?wx_fmt=jpeg\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/yqJJksIBYkZbYPi2buc9zw\"},{\"ctime\":\"2017-03-08\",\"title\":\"愿天下少女，都被用心宠爱！\",\"description\":\"招商银行\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/fJQfMRLCskaxs6O3LDchgPeticqRyRtibwFdkD3CUEuShbICSa63HdR60Pt9lZibu7SSeHJxqEmtAzC8H6G9EmK3w\\/0?wx_fmt=jpeg\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/d4OkTzlJ06ub5ZUlFEOodQ\"},{\"ctime\":\"2017-03-07\",\"title\":\"睡不到喜欢的男人，因为你没做到这点\",\"description\":\"故姐\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_png\\/yNIhiaAHZVboib4bFkOhBEOHibOWBFjmVT7B3WAWibD5oJpHRR0k8licj4okzPLFtw2OHu6TDTvgate1QxDPxjpAXHA\\/0?wx_fmt=png\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/j6t1ED-kS0MzZgPB-Ed5Ng\"},{\"ctime\":\"2017-03-07\",\"title\":\"我最不想嫁的，是我爸那种男人\",\"description\":\"咪蒙\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_jpg\\/cnLxyJPKUPmp4lKlntjhGib4JCvU7CicrukNCuAYYucl8hiafJx5mBj2q0co4QBR43nDY1JWqwecHj9lCPEfXiccTg\\/0\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/Dm2W-HCM9VfadvfYLMNaxw\"},{\"ctime\":\"2017-03-07\",\"title\":\"戴上这款浓浓SM风情的口罩，终于可以放肆呻吟了~\",\"description\":\"最黑科技\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_png\\/tyf887u3VAEGY5VkEMJu0vex57Wagbafaics47Knd2ImpJbsSAswUEw1zuO7lSPDDEM4b8xJSYriaWIaxZ7ar4xg\\/0?wx_fmt=png\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/InSuN89SSnVtG0Uglyq6jg\"},{\"ctime\":\"2017-03-07\",\"title\":\"你心疼的不该是郭美美，而是那个走丢的自己\",\"description\":\"十年后\",\"picUrl\":\"http:\\/\\/mmbiz.qpic.cn\\/mmbiz_png\\/MjiaP956Pn7ia9xFwOYg32kZsDWiaQuhObZvy8gcicr6pribHRffGyic9GPpTKbM4aIRjicCsnCt1QERobCzN3ibPGvHHg\\/0?wx_fmt=png\",\"url\":\"http:\\/\\/mp.weixin.qq.com\\/s\\/6q_Fb9mzXJ6CzbfU6zk4rQ\"}]}\n";
        //TODO 具体需要实现的业务逻辑
        JSONObject js = null;
        try {

            js = new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ExecuteResponse executeresponse = new ExecuteResponse();
        executeresponse.setBody(js);
        try {
            return parseResponse(executeresponse, parameter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.execute();
    }


}

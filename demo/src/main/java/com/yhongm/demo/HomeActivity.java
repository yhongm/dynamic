package com.yhongm.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.yhongm.dynamic_core.Dynamic;
import com.yhongm.dynamic_core.Response;
import com.yhongm.dynamic_core.Result;

import java.util.HashMap;

/**
 * Created by yhongm on 2017/03/09.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dynamic dynamic = new Dynamic.Builder().handleResult(new TestHandleResult()).build();
        HelloDynamicTest helloRequest = dynamic.create(HelloDynamicTest.class);
        String[] strs = new String[]{"123", "888", "999", "0000"};
        Result<TestBean> me = helloRequest.test(strs, 10);
        Response<TestBean> execute = me.execute();
        TestBean response = execute.getResponse();
        String s = execute.getS();
        Log.i("HomeActivity", "17:37/onCreate:str,testBean:" + response.toString());// yhongm 2017/03/09 17:37
        Log.i("HomeActivity", "15:42/onCreate:testBeanSize:" + response.getNewslist().size());// yhongm 2017/03/13 15:42
    }

    public HashMap<String, Integer> test(HashMap<String, Integer> hms) {
        return hms;
    }
}

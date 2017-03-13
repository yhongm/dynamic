package com.yhongm.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yhongm.dynamic_core.Dynamic;
import com.yhongm.dynamic_core.R;
import com.yhongm.dynamic_core.Response;
import com.yhongm.dynamic_core.Result;

import java.util.HashMap;

/**
 * Created by yhongm on 2017/03/09.
 */

public class HomeActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dynamic dynamic = new Dynamic.Builder().build();
        HelloRequest helloRequest = dynamic.create(HelloRequest.class);
        String[] strs = new String[]{"123", "888", "999", "0000"};
        Result<TestBean> me = helloRequest.test(strs, 10);
        Response<TestBean> execute = me.execute();
        TestBean response = execute.getResponse();
        Log.i("HomeActivity", "17:37/onCreate:str,testBean:" + response.toString());// yhongm 2017/03/09 17:37
        Log.i("HomeActivity", "15:42/onCreate:testBeanSize:" + response.getNewslist().size() );// yhongm 2017/03/13 15:42
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(RequestInterface.HOST)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//                HashMap<String, String> strs = new HashMap<String, String>();
//                for (int i = 0; i < 10; i++) {
//                    strs.put(i + "", (10 - i) + "");
//                }
//                RequestInterface anInterface = retrofit.create(RequestInterface.class);
//                ArrayList<Integer> integers = new ArrayList<Integer>();
//                integers.add(123);
//                integers.add(999);
//                integers.add(909);
//                retrofit.Call<WeiXinItemBean> call = anInterface.getWXHot("bf10ecf0e08cf0796862ccd1b42aa738", 20,
//                        1);
//                try {
//                    retrofit.Response<WeiXinItemBean> execute = call.execute();
//                    WeiXinItemBean body = execute.body();
//                    Log.i("HomeActivity", "16:44/onCreate:wxHot:" + body.toString());// yhongm 2017/03/09 16:44
//                } catch (IOException e) {
//                    Log.i("HomeActivity", "16:46/onCreate:e:" + e.toString());// yhongm 2017/03/09 16:46
//                    e.printStackTrace();
//                }
//            }
//        }).start();
    }

    public HashMap<String, Integer> test(HashMap<String, Integer> hms) {
        return hms;
    }
}

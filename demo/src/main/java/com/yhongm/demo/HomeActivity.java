package com.yhongm.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yhongm.dynamic_core.Dynamic;
import com.yhongm.dynamic_core.Response;
import com.yhongm.dynamic_core.Result;

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
        String[] strs = new String[]{"888", "999", "java", "python", "swift"};
        Result<TestBean> me = helloRequest.test(strs, 10);
        Response<TestBean> execute = me.execute();
        TestBean response = execute.getResponse();
        String s = execute.getS();
        Toast.makeText(this, "时间:" + s.split(",")[(s.split(",").length - 1)] + ",返回结果数量:" + response.getNewslist().size(), Toast.LENGTH_SHORT).show();
        Log.i("HomeActivity", "17:37/onCreate:str,testBean:" + response.toString());// yhongm 2017/03/09 17:37
        Log.i("HomeActivity", "15:42/onCreate:testBeanSize:" + response.getNewslist().size());// yhongm 2017/03/13 15:42
        Log.i("HomeActivity", "16:36/onCreate:s:" + s);// yhongm 2017/03/14 16:36
    }
}

"# dynamic" 

使用注解和动态代理实现的解耦，受retrofit的启发


使用方法：
1，在module 中build.gradle添加依赖 compile project(path: ':dynamic')
2,自定义类继承HandleResult实现execute方法实现要处理的逻辑,HandleParameter方法返回方法上的注解和方法参数及方法参数注解的值，parseResponse方法
转换结果到要接收的参数类型

demo:

public interface HelloDynamicTest {
    @MethodAnnotation("yhongm")
    Result<TestBean> test(@MethodParameter("hello") String[] str, @MethodParameter("mi") int mi);
}

Dynamic dynamic = new Dynamic.Builder().handleResult(new TestHandleResult()).build();

HelloDynamicTest helloRequest = dynamic.create(HelloDynamicTest.class);

String[] strs = new String[]{"888", "999", "java", "python", "swift"};

Result<TestBean> me = helloRequest.test(strs, 10);

Response<TestBean> execute = me.execute();

TestBean response = execute.getResponse();

String s = execute.getStringResponse();




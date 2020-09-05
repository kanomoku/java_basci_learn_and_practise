package throwable_exception;

public class Exception_ZiDingYi_MainTest {


    public static void main(String[] args) {
        Exception_ZiDingYi_MainTest test = new Exception_ZiDingYi_MainTest();
        try {
            test.testMyException();
        } catch (Exception_ZiDingYi e) {
            e.printStackTrace();
        }
    }

    //设计一个方法测试自定义异常
    public void testMyException() throws Exception_ZiDingYi {
        if (3 > 2) {//若满足某个条件
            throw new Exception_ZiDingYi("说明一下异常的具体问题");
        }
    }
}

package throwable_exception;

public class Exception_TryCatchFinally {
    public static void main(String[] args) {
        Exception_TryCatchFinally test = new Exception_TryCatchFinally();
        test.testTryCatchFinally();
    }

    public String testTryCatchFinally() {
        try {
            System.out.println("try开始执行");
            String str = null;
//            str.length();
            System.out.println("try执行完了");
            return "try中的返回值"; //事先预定好 返回值
        } catch (Exception e) {
            System.out.println("捕获到的异常");
        } finally {
            System.out.println("finally执行完了");
        }
        return "最终中的返回值";
    }
}
package throwable_exception;

public class Exception_ThrowsException {
    public static void main(String[] args) {
        Exception_ThrowsException test = new Exception_ThrowsException();
        test.testthrowsException();
    }

    public String testthrowsException() throws NullPointerException, StringIndexOutOfBoundsException {
        String str = null;
        str.length();
        return str;
    }
}
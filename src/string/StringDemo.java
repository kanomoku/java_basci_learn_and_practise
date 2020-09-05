package string;

public class StringDemo {


    /**
     * //设计一个方法 将字符串反转
     * //是否需要参数String  是否需要返回值 String
     *
     * @param string
     * @return
     */
    public String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public String reverse1(String string) {
        return new String(new StringBuilder(string).reverse());
    }

    public String reverse2(String string) {
        char[] c = string.toCharArray();
        for (int i = 0; i < string.length() / 2; i++) {
            char b = c[i];
            c[i] = c[string.length() - 1 - i];
            c[string.length() - 1 - i] = b;
        }
        return new String(c);
    }

    /**
     * //设计一个方法 将给定的字符串的正序和反序进行连接  OK--> OKKO
     * //是否需要参数啊   是否有返回值啊
     *
     * @param str
     * @return
     */
    public String reverseAndConcate(String str) {
        //1.反转
        //2.拼接
        //3.将最终结果返回
        return str.concat(this.reverse(str));
    }


    /**
     * //设计一个方法 判断给定的字符串是否是回文 abccba
     * //是否需要参数 String  是否需要返回值 boolean
     *
     * @param string
     * @return
     */
    public boolean isPalindrome(String string) {
        //1.字符串反转
        //2.和原字符串比较
        //3.返回比较结果
        return this.reverse(string).equals(string);
    }


    /**
     * //设计一个方法 将给定的字符后面几位挪到前面来  helloworld ---> idhellowor
     * //是否需要参数 String int 时候需要返回值 String
     *
     * @param str
     * @param i
     * @return
     */
    public String moveToRight(String str, int i) {
        if (i < 0) {
            //自定义异常告知
        }
        if (i > str.length()) {
//            i = i%str.length();
            i %= str.length();
        }
        //1.截取 前半部分 后半部分
        String end = str.substring(str.length() - i);
        String start = str.substring(0, str.length() - i);
        //2.拼接
        String c = end.concat(start);
        //3.返回
        return c;
    }
//    1234567
//    长度为7
//    取前三个  123  下标是  0-2
//    取后三个  567  一共7个后面3个，前面就有4个，所有后面第一个是第5个，下标是4，所以是4-6
//    取第3-5个 345  第三个下标是2，第5个下标是4 就是2-4


    /**
     * //设计一个方法 寻找若干字符串中长度最长的那个
     * //是否需要参数 String[]  是否需要返回值 String
     *
     * @param str
     * @return
     */
    public String choose(String... str) { //String...比String[]好
        int temp = str[0].length();
        String result = str[0];
        for (int i = 1; i < str.length; i++) {
            if (str[i].length() > temp) {
                result = str[i];
                temp = str[i].length();
            }
        }
        return result;
    }

    /**
     *     //设计一个方法 统计给定字母在字符串中出现的次数
     *     //是否需要参数String char 是否有返回值 int
     * @param str
     * @param c
     * @return
     */
    public int characterCount(String str, char c) {
        String str1 = str.replace(String.valueOf(c), "");
        return str.length() - str1.length();
    }



    /**
     *     //设计一个方法 将给定的一句话首字母变大写
     *     //是否需要参数String  是否有返回值String
     * @param str
     * @return
     */
    public String firstLetterToUpper(String str) {
        String result = "";
        String[] aa = str.split(" ");
        for (String s : aa) {
            if (!s.trim().isEmpty()) {
                result = result.concat(s.substring(0, 1).toUpperCase() + s.substring(1) + " ");
            }
        }
        return result.substring(0, result.length() - 1);
    }



    /**
     *     //设计一个方法 获取给定字符串中的全部数字
     *     //是否需要参数String  是否有返回值String
     * @param str
     * @return
     */
    public int findNumber(String str) {
        String result = "0";
        for (int i = 0; i < str.length(); i++) {
            if (48 <= str.codePointAt(i) && str.codePointAt(i) <= 52) {
                result += (char) str.codePointAt(i);
            }
        }
        return Integer.parseInt(result);
    }


    public static void main(String[] args) {
        StringDemo testStringDemo = new StringDemo();
        String[] ss = {"asd", "abcdefghigklmon", "dsafsadf"};
        System.out.println(testStringDemo.findNumber("asdf22ss33s"));
//        System.out.println(testStringDemo.findNumber("abc def2  gh3i "));
    }
}

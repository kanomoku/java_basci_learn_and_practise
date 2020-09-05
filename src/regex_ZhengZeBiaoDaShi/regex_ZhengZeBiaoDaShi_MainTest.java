package regex_ZhengZeBiaoDaShi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\
 * <p>
 * 1.普通字符：
 * 字母、数字、汉子、下划线、以及没有特殊定义的标点符号，都是“普通字符”。表达式中的普通字符，在匹配一个字符串的时候，匹配与之相同的一个字符。
 * <p>
 * 2.简单的转义字符：
 * \n换行符 \t制表符 \\代表\本身
 * \^,\$,\.,\(,\),\{,\},\[,\],\?,\+,\*
 * <p>
 * 3.标准字符集合：
 * - 能够与'多种字符' 匹配的表达式
 * - 注意区分大小写，大写是相反的意思
 * \d 	数字字符匹配。等效于 [0-9]。
 * \D 	非数字字符匹配。等效于 [ ^0-9]。
 * \w 	匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。
 * \W 	与任何非单词字符匹配。与"[ ^A-Za-z0-9_]"等效。
 * \s 包括 空格，制表符，换行符等空白字符的其中的任意一个
 * . 小数点匹配任何一个字符，除了换行符。如果也想包括换行符在内的所有字符，一般用[\s\S]
 * <p>
 * 4.自定义字符集合：
 * -[  ]方括号匹配方式，能够匹配方括号中任意一个字符
 * [xyz] 	字符集。匹配包含的任一字符。例如，"[abc]“匹配"plain"中的"a”。
 * [ ^xyz] 	反向字符集。匹配未包含的任何字符。例如，"[^abc]“匹配"plain"中"p”，“l”，“i”，“n”。
 * [a-z] 	字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。
 * [^A-F0-3] 	字符范围。"A"-"F","0'-"3"之外的任意一个字符。
 * 注意：
 * -正则表达式的特殊符号，被包含到中括号中，则失去特殊意义，除了^,-之外
 * -标准字符集合，除小数点外，如果被包含于中括号，自定义字符集合将包含该集合。
 * <p>
 * 5.量词：
 * - 修饰匹配次数的特殊符号
 * * 	零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。
 * + 	一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。
 * ? 	零次或一次匹配前面的字符或子表达式。例如，"do(es)?“匹配"do"或"does"中的"do”。? 等效于 {0,1}。
 * {n} 	n 是非负整数。正好匹配 n 次。例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。
 * {n,} n 是非负整数。至少匹配 n 次。例如，"o{2,}“不匹配"Bob"中的"o”，而匹配"foooood"中的所有 o。"o{1,}“等效于"o+”。"o{0,}“等效于"o*”。
 * {n,m} m 和 n 是非负整数，其中 n <= m。匹配至少 n 次，至多 m 次。例如，"o{1,3}"匹配"fooooood"中的头三个 o。‘o{0,1}’ 等效于 ‘o?’。注意：您不能将空格插入逗号和数字之间。
 * 注意：
 * - 匹配次数中的贪婪模式(匹配字符越多越好，默认！)
 * - 匹配次数中的非贪婪模式（匹配字符越少越好，修饰匹配次数的特殊符号后再加上一个"？"号）
 * 例：
 * \d{3,6} 匹配3-6个数字的(默认：贪婪式)
 * \d{3,6}？ 匹配3-6个数字(非贪婪模式)
 * <p>
 * 6.字符边界
 * - 标记匹配的不是字符而是位置，符合某种条件的位置
 * ^ 	匹配输入字符串开始的位置。如果设置了 RegExp 对象的 Multiline 属性，^ 还会与"\n"或"\r"之后的位置匹配。
 * $ 	匹配输入字符串结尾的位置。如果设置了 RegExp 对象的 Multiline 属性，$ 还会与"\n"或"\r"之前的位置匹配。
 * \b 匹配一个单词边界
 * 注：\b匹配这样一个位置：前面的字符和后面的字符不全是\w
 * <p>
 * 7.选择符和分组(常常与8联用)
 * <p>
 * 8.反向引用(\nnn)
 * <p>
 * 9.预搜索
 */
public class regex_ZhengZeBiaoDaShi_MainTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String str = scanner.nextLine();
        //判断输入的str字符串内容是否满足什么样的格式
        System.out.println("ab 匹配 a[abc]：" + "ab".matches("a[abc]"));//字符串长度为2，第一个必须是a 第二个是abc中的任意一个
        System.out.println("abc 匹配 a[abc]：" + "abc".matches("a[abc]"));//字符串长度为2，第一个必须是a 第二个是abc中的任意一个
        System.out.println("ad 匹配 a[abc]：" + "ad".matches("a[abc]"));//字符串长度为2，第一个必须是a 第二个是abc中的任意一个
        System.out.println("···························");
        System.out.println("ab 匹配 a[^abc]：" + "ab".matches("a[^abc]"));//字符串长度为2,，第一个必须是a 第二个不是abc中的任意一个
        System.out.println("abc 匹配 a[^abc]：" + "abc".matches("a[^abc]"));//字符串长度为2,，第一个必须是a 第二个不是abc中的任意一个
        System.out.println("ad 匹配 a[^abc]：" + "ad".matches("a[^abc]"));//字符串长度为2,，第一个必须是a 第二个不是abc中的任意一个
        System.out.println("···························");
        System.out.println("ab 匹配 a[^abc]：" + "ab".matches("a[a-zA-Z]"));//字符串长度为2，第一个必须是a 第二个任意范围之内的一个字母
        System.out.println("aB 匹配 a[^abc]：" + "aB".matches("a[a-zA-Z]"));//字符串长度为2，第一个必须是a 第二个任意范围之内的一个字母
        System.out.println("aBc 匹配 a[^abc]：" + "aBc".matches("a[a-zA-Z]"));//字符串长度为2，第一个必须是a 第二个任意范围之内的一个字母
        System.out.println("a1 匹配 a[^abc]：" + "a1".matches("a[a-zA-Z]"));//字符串长度为2，第一个必须是a 第二个任意范围之内的一个字母
        System.out.println("···························");
        System.out.println("ad".matches("a[a-z&&[^bc]]"));//字符串长度是2，第一个必须是a 第二个a-z都可以但是不能是b和c
        System.out.println("ab".matches("a[a-z&&[^bc]]"));//字符串长度是2，第一个必须是a 第二个a-z都可以但是不能是b和c
        System.out.println("adc".matches("a[a-z&&[^bc]]"));//字符串长度是2，第一个必须是a 第二个a-z都可以但是不能是b和c
        System.out.println("···························");
        System.out.println("ad".matches(".[a-z&&[^bc]]"));//字符串长度为2，第一个点代表任意字符 第二个a-z都可以但是不能是b和c
        System.out.println("adc".matches(".[a-z&&[^bc]]"));//字符串长度为2，第一个点代表任意字符 第二个a-z都可以但是不能是b和c
        System.out.println("ac".matches(".[a-z&&[^bc]]"));//字符串长度为2，第一个点代表任意字符 第二个a-z都可以但是不能是b和c
        System.out.println("···························");
        System.out.println("m".matches("[a-d[m-p]]"));//字符串长度为1，范围内的字符
        System.out.println("a".matches("[a-d[m-p]]"));//字符串长度为1，范围内的字符
        System.out.println("e".matches("[a-d[m-p]]"));//字符串长度为1，范围内的字符
        System.out.println("mm".matches("[a-d[m-p]]"));//字符串长度为1，范围内的字符
        System.out.println("···························");
        System.out.println("a".matches("[a-z&&[def]]"));//字符串长度为1，范围a-z,而且范围是def
        System.out.println("d".matches("[a-z&&[def]]"));//字符串长度为1，范围a-z,而且范围是def
        System.out.println("e".matches("[a-z&&[def]]"));//字符串长度为1，范围a-z,而且范围是def
        System.out.println("ef".matches("[a-z&&[def]]"));//字符串长度为1，范围a-z,而且范围是def
        System.out.println("···························");
        System.out.println("12".matches("\\d{3,5}"));//数字，长度为3-5个
        System.out.println("123".matches("\\d{3,5}"));//数字，长度为3-5个
        System.out.println("12345".matches("\\d{3,5}"));//数字，长度为3-5个
        System.out.println("123456".matches("\\d{3,5}"));//数字，长度为3-5个
        System.out.println("a".matches("\\d{3,5}"));//数字，长度为3-5个
        System.out.println("···························");

        String str = "a-b-c-d";
        String[] ss1 = str.split("-");
        for (String s : ss1) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("···························");

        String str1 = "a,.b+c#d";
        String[] ss = str1.split(",|\\+|#"); //a .b c d
        for (String s : ss) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("···························");


        //所有的字符串中找寻满足如下规则的信息  邮政编码
        String str2 = "123456abc0123456abc1234567abc";
        //1.利用Pattern类创建一个模式 理解为是一个正则表达式对象
        Pattern pattern = Pattern.compile("\\d{6}");//邮编
        //2.需要提供一个字符串
        //3.利用pattern模式对象创建一个匹配器
        Matcher matcher = pattern.matcher(str2);
        //4.找寻字符串中出现满足上述格式的字符串
        while (matcher.find()){
            System.out.println(matcher.group());
        }
////        123456
////        012345
////        123456


    }
}

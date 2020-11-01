package leetcode;

import java.util.*;

public class Num139_wordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Num139_wordBreak num139_wordBreak = new Num139_wordBreak();
        System.out.println(num139_wordBreak.wordBreak1(s,list));
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];// 申请s.length() + 1 长度是为了给dp[0]赋初始值，字符串第1个元素对应hp[1]...第s.length个元素对应第hp[s.length]
        dp[0] = true;//对于边界条件，我们定义 dp[0]=true 表示空串且合法
        for (int i = 1; i <= s.length(); i++) {// 遍历字符串的所有的元素,此时数值非数组的下标
            for (int j = 0; j < i; j++) {// 上面的1和此时的0都是代表第一个元素，注意这种对应默契。
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {// 转移方程dp[i]=dp[j] && check(s[j..i−1])，此时不写脑子里要有理解过程
                    dp[i] = true;//遍历子串其实就是在找存在，如果存在一个j使得，s[0..j−1]和s[j..i−1] 都在set里，那么此时
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    public HashMap<String, Boolean> hash = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //方便check，构建一个哈希表来存储单词字典
        for (String word : wordDict) {
            hash.put(word, true);
        }
        //初始化
        dp[0] = true;
        //遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && check(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean check(String s) {
        return hash.getOrDefault(s, false);
    }
}

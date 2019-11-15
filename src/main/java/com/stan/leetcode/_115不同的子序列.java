package com.stan.leetcode;

import java.util.Arrays;

public class _115不同的子序列 {

    public static void main(String[] args) {

        String s = "xslledayhxhadmctrliaxqpokyezcfhzaskeykchkmhpyjipxtsuljkwkovmvelvwxzwieeuqnjozrfwmzsylcwvsthnxujvrkszqwtglewkycikdaiocglwzukwovsghkhyidevhbgffoqkpabthmqihcfxxzdejletqjoxmwftlxfcxgxgvpperwbqvhxgsbbkmphyomtbjzdjhcrcsggleiczpbfjcgtpycpmrjnckslrwduqlccqmgrdhxolfjafmsrfdghnatexyanldrdpxvvgujsztuffoymrfteholgonuaqndinadtumnuhkboyzaqguwqijwxxszngextfcozpetyownmyneehdwqmtpjloztswmzzdzqhuoxrblppqvyvsqhnhryvqsqogpnlqfulurexdtovqpqkfxxnqykgscxaskmksivoazlducanrqxynxlgvwonalpsyddqmaemcrrwvrjmjjnygyebwtqxehrclwsxzylbqexnxjcgspeynlbmetlkacnnbhmaizbadynajpibepbuacggxrqavfnwpcwxbzxfymhjcslghmajrirqzjqxpgtgisfjreqrqabssobbadmtmdknmakdigjqyqcruujlwmfoagrckdwyiglviyyrekjealvvigiesnvuumxgsveadrxlpwetioxibtdjblowblqvzpbrmhupyrdophjxvhgzclidzybajuxllacyhyphssvhcffxonysahvzhzbttyeeyiefhunbokiqrpqfcoxdxvefugapeevdoakxwzykmhbdytjbhigffkmbqmqxsoaiomgmmgwapzdosorcxxhejvgajyzdmzlcntqbapbpofdjtulstuzdrffafedufqwsknumcxbschdybosxkrabyfdejgyozwillcxpcaiehlelczioskqtptzaczobvyojdlyflilvwqgyrqmjaeepydrcchfyftjighntqzoo";
        String t = "rwmimatmhydhbujebqehjprrwfkoebcxxqfktayaaeheys";

    }


    /**
     * dp[i][j] 为 s[i,end] 变化到 t[j][end] 有几种
     * 为了防止数组越界i可以取到 s.length,  j 可以取到 t.length
     *
     * i == s.length时， 即s为空，结果为0种， （除非t也为空，那就是1种）
     *
     * j == t.length时， 即t为空，就是s一个元素都不取，就是1种
     * 所以把 dp[0到s.length][t.length] 初始化为 1
     *
     *
     * dp[i][j] 和 dp[i+1][j+1]， dp[i+1][j]的关系
     *
     * if s[i] == t[j], 如果让i,j位对应，那么后面就是s[i+1,end]变到t[j+1,end]有几种，即dp[i+1][j+1]
     *                 也可以放弃，即对s的第i位视而不见，从s[i+1,end]变到 t[j, end]有几种， 即dp[i+1][j]
     *                 so dp[i][j] = dp[i+1][j+1] + dp[i+1][j]
     *
     * else i,j无法对应，那只能 s[i+1,end]变到t[j][end]了， 即dp[i+1][j]
     *                 so dp[i][j] = dp[i+1][j]
     *
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        int[][] dp = new int[sLen + 1][tLen + 1];

        //dp[slen][除了0]] = 0  因为s为空，t不为空，不可能,  本身就是0， 不需要赋值了
        //dp[:][tLen] = 1  因为t为空，对于s，只能一个都不拿才是空， 所以就是1种，赋值
        for (int i = 0; i <= sLen; ++i) dp[i][tLen] = 1;


        for (int j = tLen - 1; j >= 0; -- j) {
            for (int i = sLen - 1; i >= 0; -- i) {

                if (s.charAt(i) == t.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }
        return dp[0][0];
    }

    /**
     * 跟上面思路一样，换成正向遍历
     * 防止数组越界 dp[i][j] 为 s[0, i - 1] 变化到 t[0, j - 1] 有几种
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {

        int sLen = s.length();
        int tLen = t.length();

        //为了防止数组越界，dp[i][j]表示
        //当i = 0时相当于s为空，dp[0][除了0] = 0 因为没元素给你选啊。。
        //当j = 0时相当于t为空，dp[:][0] = 1     因为s一个都不选就是空啊。。
        int[][] dp = new int[sLen + 1][tLen + 1];

        //初始化
        for (int i = 0; i <= sLen; ++i) dp[i][0] = 1;

        for (int j = 1; j <= tLen; ++j) {
            for (int i = 1; i <= sLen; ++i) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //s[0, i- 2]变化到t[0, j - 2]，然后s[i-1]和t[j-1]对应
                    //也可以不对应， s[0, i - 2]变化到t[0, j - 1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];

    }


}

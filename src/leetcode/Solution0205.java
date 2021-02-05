package leetcode;

import java.util.Arrays;

/*
205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。

示例 1:
输入：s = "egg", t = "add"
输出：true

示例 2：
输入：s = "foo", t = "bar"
输出：false

示例 3：
输入：s = "paper", t = "title"
输出：true
 
提示：
可以假设 s 和 t 长度相同。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/isomorphic-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0205 {
    public boolean isIsomorphic(String s, String t) {
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map1[char1[i]] != map2[char2[i]]) {
                return false;
            }
            map1[char1[i]] = i + 1;
            map2[char2[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0205().isIsomorphic("egg", "add"));
        System.out.println(new Solution0205().isIsomorphic("foo", "bar"));
        System.out.println(new Solution0205().isIsomorphic("paper", "title"));
    }
}

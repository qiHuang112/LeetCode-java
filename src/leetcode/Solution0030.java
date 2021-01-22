package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
30. 串联所有单词的子串
给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * todo words[0] 个滑动窗口实现
 */
public class Solution0030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = words[0].length();
        label:
        for (int i = 0; i < s.length() - words.length * len + 1; i++) {
            map.clear();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (int j = 0; j < words.length; j++) {
                String cur = s.substring(i + j * len, i + j * len + len);
                map.put(cur, map.getOrDefault(cur, 0) - 1);
                if (map.get(cur) < 0) {
                    continue label;
                }
            }
            res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution0030().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution0030().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));
    }
}

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 2036 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表来存储字母异位词组
        Map<String, List<String>> map = new HashMap<>();

        // 遍历所有字符串
        for (String str : strs) {
            // 将字符串转换为字符，方便排序
            char[] array = str.toCharArray();
            // 对字符串中的字符进行排序，得到排序后的字符串作为键
            Arrays.sort(array);
            String key = new String(array);

            // 从哈希表中获取与key对应的列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            //将原始字符串添加到哈希列表list中
            list.add(str);
            //将更新后的列表list放回哈希表map中, 与key关联
            map.put(key, list);
        }

        // 将哈希表中的所有列表转换为结果列表
        return new ArrayList<List<String>>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

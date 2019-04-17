package com.allst.jvalgo.basicalgo;

import java.util.*;

/**
 * 模拟9键输入法中对应数字上字母的随机组合
 * @author June 2018-01-13 下午 02:21
 * @version 1.0
 */
public class LetterCombination {
    public static void main(String[] args) {
        letterCombina();
    }

    /**
     *
     */
    private static void letterCombina() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请依次输入两个整数(2~9): ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        StringBuffer str = new StringBuffer();
        str.append(num1);
        str.append(num2);
        Map<Character,String> map=new HashMap<>();
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // 集合用于存储字母组合后的结果
        List<String> list = new ArrayList<>();
        // 为每一个数字对应的字母创建一个StringBuilder对象
        StringBuilder[] sb = new StringBuilder[str.length()];
        for(int i = 0; i < str.length(); i++) {
            sb[i]=new StringBuilder();
            sb[i].append(map.get(str.charAt(i)));
        }
        list.add("");
        for(int i = 0; i < str.length(); i++) {
            // 集合存储每个数字上对应字母的字符遍历并与之前的相加
            List<String> newRes = new ArrayList<>();
            for (String value : list){
                for(int j = 0; j < sb[i].length(); j++) {
                    newRes.add(value + sb[i].charAt(j));
                }
            }
            list = newRes;
        }
        System.out.println(list);
    }
}

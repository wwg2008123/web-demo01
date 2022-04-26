package com.wwg.webdemo01.model;

import java.util.HashMap;

/**
 * <p></p>
 *
 * @author wangweiguang 2022/1/25 10:02
 */
public class LeetCodeTest {

    public static void main(String[] args) {
        //new LeetCodeTest().longestPalindrome("babad");
      //int res =   new LeetCodeTest().reverse(1234);
      int res =   new LeetCodeTest().myAtoi("12343");
        System.out.println("res = " + res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        ListNode temp = new ListNode();
        temp = l1;
        while (temp != null) {
            sb1.append(temp.val);
            temp = temp.next;
        }
        StringBuilder sb2 = new StringBuilder();
        temp = l2;
        while (temp != null) {
            sb2.append(temp.val);
            temp = temp.next;
        }
        Integer item1 = Integer.valueOf(sb1.reverse().toString());
        Integer item2 = Integer.valueOf(sb2.reverse().toString());
        int sum = item1.intValue() + item2.intValue();
        StringBuilder sb3 = new StringBuilder(sum);
        sb3.append(sum);

        char[] chars = sb3.toString().toCharArray();

        ListNode node = new ListNode();

        for (int i = 0; i < chars.length; i++) {
            int vv = Integer.valueOf(String.valueOf(chars[i]));
            node = getListNode(node,vv,i);
        }
        return node;
    }

    private ListNode getListNode( ListNode item,int val,int i) {
        ListNode child = new ListNode(val);
        if(i==0){
            return child;
        }else{
            child.next = item;
        }
        return child;
    }

    //无重复字符的最长子串
    public int lengthOfLongestSubstring(String s) {
        int maxlength =0;
        int start =0;
        int end =0;

        HashMap<String,Integer> sMaps= new HashMap<>();
        for(int i=0;i<s.length();i++){
            String cur = String.valueOf(s.charAt(i));
            if(sMaps.containsKey(cur)){
                if(sMaps.get(cur)>start){
                    start = sMaps.get(cur);
                }
            }

            end =i +1;
            if(maxlength < end - start){
                maxlength= end - start;
            }

            sMaps.put(String.valueOf(s.charAt(i)),i+1);
        }
        return maxlength;
    }

    //给你一个字符串 s，找到 s 中最长的回文子串
    public String longestPalindrome(String s) {
        if(s==null && s.length()==0){
            return "";
        }
        int[] range = new int[2];
        char[] str = s.toCharArray();
        //把回文看成中间部分全是统一字符，左右部分相对称
        //找到下一个与当前字符不同的字符
        for (int i=0;i<s.length();i++){
            i = findLongest(str,i,range);
        }
        return s.substring(range[0],range[1]+1);
    }
    private int findLongest(char[] str,int low,int[] range){
        //查找中间部分
        int high = low;
        while (high < str.length-1 && str[high+1] == str[low]){
            high++;
        }
        //定位中间部分最后一个字符
        int ans = high;
        //从中间相左右扩散
        while (low > 0 && high < str.length-1 && str[low-1]==str[high+1]){
            low--;
            high++;
        }
        //记录最大长度
        if(high - low > range[1]-range[0]){
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }



    public int reverse(int input) {
        int res = 0;

        while (input !=0){
            int temp = input % 10;
            input = input /10;
            if(res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10){
                return 0;
            }
            res = res *10 +temp;
        }
        return res;
    }

    public int myAtoi(String s) {
        s= s.trim();
        char flag = s.charAt(0);
        if(flag =='-'){
            s = s.substring(1,s.length());
        }
        int res =0;
        final String number = "0123456789";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                continue;
            }
            if(number.indexOf(s.charAt(i))==-1){
                break;
            }
            long temp = res*10+(int)s.charAt(i);
            if(flag=='-'){
                if( temp < (Math.pow(2,31))){
                    return -(int)(flag + Math.pow(2,31));
                }else{
                    return (int)(flag + res);
                }
            }else{
                if(temp > (Math.pow(2,31)-1)){
                    return (int)(Math.pow(2,31)-1);
                }
                return  res;
            }
        }
        return res;
    }

}

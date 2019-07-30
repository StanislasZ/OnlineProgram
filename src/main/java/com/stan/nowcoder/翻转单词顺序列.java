package com.stan.nowcoder;

public class 翻转单词顺序列 {

    /*
        牛客最近来了一个新员工Fish，
        每天早晨总是会拿着一本英文杂志，写些句子在本子上。
        同事Cat对Fish写的内容颇感兴趣，
        有一天他向Fish借来翻看，但却读不懂它的意思。
        例如，“student. a am I”。后来才意识到，
        这家伙原来把句子单词的顺序翻转了，
        正确的句子应该是“I am a student.”。
        Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */


    /**
     * 先整个翻转，再逐个单词翻转
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {

        char[] arr = str.toCharArray();
        int N = arr.length;
        reverse(arr, 0, N - 1);

        int left = 0;
        int right = 0;
        while (right < N) {
            if (arr[right] != ' ') {
                right++;
            } else {
                reverse(arr, left, right - 1);
                left = right + 1;
                right = right + 1;

            }
        }
        reverse(arr, left, right - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {

        while (left < right) {
            char temp = arr[right];
            arr[right--] = arr[left];
            arr[left++] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new 翻转单词顺序列().ReverseSentence("student. a am I"));
    }
}

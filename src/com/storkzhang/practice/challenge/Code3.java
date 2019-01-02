package com.storkzhang.practice.challenge;

import java.util.Scanner;

public class Code3 {

    private static String solution(String line) {

        int fib[] = new int[10001];
        String[] array = line.split(" ");
        fib[0] = 1;
        fib[1] = 2;
        for (int i = 2; i <= 10000; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            if (fib[i]>10000) {
                break;
            }
        }
        int n = array.length;
        int max = 0;
        String win = "Xiaoai Win";
        int xiaoai = Integer.parseInt(array[0]);
        int xiaobing = Integer.parseInt(array[1]);
        if (xiaoai>xiaobing) {
            max = xiaoai;
        } else {
            max = xiaobing;
        }
        boolean first = false, second = false;
        for (int j = 0; j <= max; j++) {
            if (fib[j] == xiaoai) {
                first = true;
            }
        }
        for (int j = 0; j <= max; j++) {
            if (fib[j] == xiaobing) {
                second = true; break;
            }
        }
        if (first == second) {
            win = "Xiaobing Win";
        }

        String result = win;
        // 返回处理后的结果
        return result;

    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            System.out.println(solution(line));
        }
    }
}

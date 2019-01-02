package com.storkzhang.practice.challenge;

import java.util.Scanner;

public class Code1 {

    private static String solution(String line) {
        // 在此处理单行数据
        int[] tree;
        int size;
        String[] array = line.split(" ");
        int max_end_time = -10000000, min_start_time = 10000000;

        for (int i = 0; i < array.length; i = i + 4) {
            int id = Integer.parseInt(array[i]);
            int start_time = Integer.parseInt(array[i + 1]);
            int end_time = Integer.parseInt(array[i + 2]);
            int score = Integer.parseInt(array[i + 3]);
            if (end_time > max_end_time||start_time>max_end_time) {
                max_end_time = end_time;
            }
            if (start_time < min_start_time ) {
                min_start_time = start_time;
            }
        }
        size = max_end_time - min_start_time + 1;
        tree = new int[size+1];

        for (int i = 0; i < array.length; i = i + 4) {
            int id = Integer.parseInt(array[i]);
            int start_time = Integer.parseInt(array[i + 1]) - min_start_time;
            int end_time = Integer.parseInt(array[i + 2]) - min_start_time;
            int score = Integer.parseInt(array[i + 3]);
            for (int j = start_time; j < end_time; j++) {
                if(j>=0) {
                    tree[j] = tree[j] + score;
                }
            }
        }
        int max_score = 0;
        for (int i = 0; i <= size; i++) {
            int score_total = tree[i];
            if (score_total > max_score) {
                max_score = score_total;
            }
        }
        String result = Integer.toString(max_score);
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

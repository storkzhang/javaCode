package com.storkzhang.practice.challenge;

import java.util.Scanner;

public class Code1_1 {
    static int[] tree;
    static int size;

    public static void Update(int n, int value) {
        Update(1, 1, size, n, value);
    }

    private static void Update(int index, int left, int right, int n, int value) {
        tree[index] += value;
        if (left == right) {
            return;
        } else {
            int mid = (left + right) >> 1;
            if (mid >= n) {

                Update(index << 1, left, mid, n, value);
            } else {
                Update(index << 1 | 1, mid + 1, right, n, value);
            }
        }
    }

    // 差选线段起止之间的权值和
    public static int Query(int start, int end) {
        return Query(1, 1, size, start, end);
    }

    private static int Query(int index, int left, int right, int start, int end) {
//        System.out.println(left +" "+ right);
        int sum = 0;
        if (left >= start && right <= end) {
            return tree[index];
        }
        int mid = (left + right) >> 1;
        if (mid >= start && left <= end) {
            sum += Query(index << 1, left, mid, start, end);
        }
        if (mid <= end && right >= start) {
            sum += Query(index >> 1 | 1, mid + 1, right, start, end);
        }
        return sum;
    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] array = line.split(" ");
        int n = 10000;
        int max_end_time = 0, min_start_time = 0;
        size = n;
        tree = new int[n * 4 + 1];

        for (int i = 0; i < array.length; i = i + 4) {
            int id = Integer.parseInt(array[i]);
            int start_time = Integer.parseInt(array[i + 1]);
            int end_time = Integer.parseInt(array[i + 2]);
            int score = Integer.parseInt(array[i + 3]);
            if (end_time > max_end_time) {
                max_end_time = end_time;
            }
            if (start_time < min_start_time || min_start_time == 0) {
                min_start_time = start_time;
            }
            for (int j = start_time; j < end_time; j++) {
                Update(j, score);
            }
        }
        int max_score = 0;
        for (int i = min_start_time; i < max_end_time; i++) {
            int score_total = Query(i,i);
            if (score_total>max_score) {
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

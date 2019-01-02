package com.storkzhang.practice.challenge;

import java.util.Scanner;

public class Code2 {


    private static String solution(String line) {

        // 在此处理单行数据
        String[] array = line.split(" ");
        int n = array.length;
        int node[][] = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i = i + 1) {
            int id = Integer.parseInt(array[i - 1]);
            for (int j = i + 1; (j <= i + id) && (j <= n); j++) {
                node[i][j] = 1;
            }
        }
        String result = Boolean.toString(dfs(node, 1, n));
        // 返回处理后的结果
        return result;
    }

    private static boolean dfs(int node[][], int i, int n) {
        if (i == n) {
            return true;
        }
        boolean found = false;
        for (int k = 0; k <= n; k++) {
            if (node[i][k] == 1) {
                found = dfs(node, k, n);
                if (found) {
                    break;
                }
            }
        }
        return found;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            System.out.println(solution(line));
        }
    }
}

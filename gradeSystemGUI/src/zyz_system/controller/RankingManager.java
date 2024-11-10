package zyz_system.controller;

import java.util.Arrays;

/**
 * 成绩排名管理控制器
 * 负责处理各种成绩排名计算
 */
public class RankingManager {
    /**
     * 获取指定课程的成绩排名
     * @param data 成绩数据二维数组
     * @param colIndex 课程所在列索引
     * @return 格式化的排名结果字符串
     */
    public static String getCourseRanking(String[][] data, int colIndex) {
        StringBuilder result = new StringBuilder();
        result.append("课程: ").append(data[0][colIndex]).append(" 成绩排名\n\n");

        // 创建成绩数组，存储学生姓名和对应成绩
        String[][] scores = new String[data.length-1][2];
        for (int i = 1; i < data.length; i++) {
            scores[i-1][0] = data[i][1];    // 学生姓名
            scores[i-1][1] = data[i][colIndex];  // 课程成绩
        }

        // 按成绩降序排序
        Arrays.sort(scores, (a, b) -> {
            try {
                return Double.compare(
                    Double.parseDouble(b[1]),
                    Double.parseDouble(a[1])
                );
            } catch (NumberFormatException e) {
                return 0;
            }
        });

        // 生成排名结果
        for (int i = 0; i < scores.length; i++) {
            result.append(i + 1).append(". ")
                  .append(scores[i][0]).append(": ")
                  .append(scores[i][1]).append("\n");
        }

        return result.toString();
    }

    /**
     * 计算并获取平均分排名
     * @param data 成绩数据二维数组
     * @return 格式化的平均分排名结果字符串
     */
    public static String getAverageRanking(String[][] data) {
        StringBuilder result = new StringBuilder();
        result.append("平均分排名：\n\n");

        // 创建数组存储学生姓名和平均分
        String[][] averageScores = new String[data.length-1][2];

        // 计算每个学生的平均分
        for (int i = 1; i < data.length; i++) {
            double sum = 0;
            int count = 0;
            // 从第3列开始计算（跳过学号和姓名）
            for (int j = 2; j < data[i].length; j++) {
                try {
                    sum += Double.parseDouble(data[i][j]);
                    count++;
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            averageScores[i-1][0] = data[i][1];  // 学生姓名
            averageScores[i-1][1] = String.format("%.2f", count > 0 ? sum/count : 0);  // 平均分
        }

        // 按平均分降序排序
        Arrays.sort(averageScores, (a, b) ->
            Double.compare(Double.parseDouble(b[1]), Double.parseDouble(a[1])));

        // 生成排名结果
        for (int i = 0; i < averageScores.length; i++) {
            result.append(i + 1).append(". ")
                  .append(averageScores[i][0]).append(": ")
                  .append(averageScores[i][1]).append("\n");
        }

        return result.toString();
    }

    /**
     * 计算并获取总分排名
     * @param data 成绩数据二维数组
     * @return 格式化的总分排名结果字符串
     */
    public static String getTotalRanking(String[][] data) {
        StringBuilder result = new StringBuilder();
        result.append("总分排名：\n\n");

        // 创建数组存储学生姓名和总分
        String[][] totalScores = new String[data.length-1][2];

        // 计算每个学生的总分
        for (int i = 1; i < data.length; i++) {
            double sum = 0;
            // 从第3列开始计算（跳过学号和姓名）
            for (int j = 2; j < data[i].length; j++) {
                try {
                    sum += Double.parseDouble(data[i][j]);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
            totalScores[i-1][0] = data[i][1];  // 学生姓名
            totalScores[i-1][1] = String.format("%.2f", sum);  // 总分
        }

        // 按总分降序排序
        Arrays.sort(totalScores, (a, b) ->
            Double.compare(Double.parseDouble(b[1]), Double.parseDouble(a[1])));

        // 生成排名结果
        for (int i = 0; i < totalScores.length; i++) {
            result.append(i + 1).append(". ")
                  .append(totalScores[i][0]).append(": ")
                  .append(totalScores[i][1]).append("\n");
        }

        return result.toString();
    }
}
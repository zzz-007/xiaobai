package zyz_system.controller;

/**
 * 成绩计算控制器
 * 负责处理单个学生的成绩计算
 */
public class ScoreCalculator {
    /**
     * 计算指定学生的成绩统计信息
     * @param data 成绩数据二维数组
     * @param rowIndex 学生所在行索引
     * @return 格式化的成绩统计结果字符串
     */
    public static String calculateStudentScore(String[][] data, int rowIndex) {
        StringBuilder result = new StringBuilder();
        double sum = 0.0;
        int count = 0;

        try {
            // 从第3列开始计算（跳过学号和姓名）
            for (int i = 2; i < data[rowIndex].length; i++) {
                try {
                    double value = Double.parseDouble(data[rowIndex][i]);
                    sum += value;
                    count++;
                } catch (NumberFormatException e) {
                    // 跳过无法转换为数字的成绩
                    continue;
                }
            }

            // 生成统计结果
            if (count > 0) {
                double average = sum / count;
                result.append("学生: ").append(data[rowIndex][1])
                      .append("\n总分: ").append(sum)
                      .append("\n平均分: ").append(String.format("%.2f", average));
            } else {
                result.append("没有有效的数据可计算");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            result.append("行号超出范围！");
        }

        return result.toString();
    }
} 
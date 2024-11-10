package zyz_system.controller;

/**
 * 成绩显示管理器
 * 负责处理成绩数据的显示格式化
 */
public class ScoreDisplayManager {
    /**
     * 格式化显示成绩表
     * @param data 成绩数据二维数组
     * @return 格式化后的字符串
     */
    public static String formatScoreTable(String[][] data) {
        StringBuilder sb = new StringBuilder();
        // 添加表头
        sb.append("学生成绩表\n\n");
        
        // 计算每列的最大宽度
        int[] columnWidths = calculateColumnWidths(data);
        
        // 显示数据
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                sb.append(String.format("%-" + columnWidths[i] + "s", row[i])).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    /**
     * 计算每列的最大宽度
     */
    private static int[] calculateColumnWidths(String[][] data) {
        int[] widths = new int[data[0].length];
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                widths[i] = Math.max(widths[i], row[i].length());
            }
        }
        return widths;
    }
    
    /**
     * 查找并格式化特定学生的特定课程成绩
     */
    public static String findSpecificScore(String[][] data, String studentId, String courseName) {
        StringBuilder output = new StringBuilder();
        
        // 查找课程列
        int courseCol = -1;
        for (int j = 0; j < data[0].length; j++) {
            if (data[0][j].equals(courseName)) {
                courseCol = j;
                break;
            }
        }
        
        // 查找学生行
        int studentRow = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(studentId)) {
                studentRow = i;
                break;
            }
        }
        
        if (courseCol != -1 && studentRow != -1) {
            output.append("查询结果：\n\n")
                  .append("学生: ").append(data[studentRow][1])
                  .append("\n课程: ").append(courseName)
                  .append("\n成绩: ").append(data[studentRow][courseCol]);
        } else {
            output.append("未找到相关信息");
        }
        
        return output.toString();
    }
} 
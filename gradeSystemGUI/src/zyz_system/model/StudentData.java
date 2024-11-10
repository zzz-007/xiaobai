package zyz_system.model;

import zyz_system.utils.CSVReader;

/**
 * 学生数据模型类
 * 负责管理学生成绩数据的存储和访问
 */
public class StudentData {
    private String[][] data;        // 存储学生成绩数据的二维数组
    private String filePath;        // CSV文件路径

    /**
     * 构造函数
     * @param filePath CSV文件路径
     */
    public StudentData(String filePath) {
        this.filePath = filePath;
        refreshData();
    }

    /**
     * 重新从文件读取数据
     */
    public void refreshData() {
        this.data = CSVReader.read(filePath, 32);
    }

    /**
     * 获取成绩数据
     * @return 成绩数据的二维数组
     */
    public String[][] getData() {
        return data;
    }

    /**
     * 获取文件路径
     * @return CSV文件路径
     */
    public String getFilePath() {
        return filePath;
    }
} 
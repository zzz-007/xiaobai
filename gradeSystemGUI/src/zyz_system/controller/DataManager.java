package zyz_system.controller;

import java.io.IOException;
import zyz_system.utils.CSVModifier;
import zyz_system.utils.CSVWriter;

/**
 * 数据管理控制器
 * 负责处理数据的修改和添加操作
 */
public class DataManager {
    /**
     * 修改CSV文件中的数据
     * @param filePath CSV文件路径
     * @param data 当前数据数组
     * @param row 要修改的行号
     * @param col 要修改的列号
     * @param newValue 新的数据值
     * @return 操作结果消息
     */
    public static String modifyData(String filePath, String[][] data, int row, int col, String newValue) {
        try {
            CSVModifier.modifyCSVData(filePath, row, col, newValue);
            return "数据修改成功！";
        } catch (IOException e) {
            return "修改失败：" + e.getMessage();
        }
    }

    /**
     * 向CSV文件添加新的一行数据
     * @param filePath CSV文件路径
     * @param newData 要添加的新数据数组
     * @return 操作结果消息
     */
    public static String addNewRow(String filePath, String[] newData) {
        try {
            CSVWriter.addRow(filePath, newData);
            return "数据添加成功！";
        } catch (IOException e) {
            return "添加失败：" + e.getMessage();
        }
    }
} 
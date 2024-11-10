package zyz_system.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSV文件读取工具类
 * 用于将CSV文件内容读取到二维字符串数组中
 */
public class CSVReader {
    /**
     * 读取CSV文件内容
     * @param filePath CSV文件路径
     * @param columnCount 期望的列数
     * @return 包含CSV数据的二维字符串数组
     */
    public static String[][] read(String filePath, int columnCount) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 使用逗号分割每行数据
                String[] values = line.trim().split(",", -1);
                
                // 如果实际列数小于期望列数，用空字符串填充
                if (values.length < columnCount) {
                    String[] paddedRow = new String[columnCount];
                    System.arraycopy(values, 0, paddedRow, 0, values.length);
                    for (int i = values.length; i < columnCount; i++) {
                        paddedRow[i] = "";
                    }
                    values = paddedRow;
                }
                rows.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将List转换为二维数组返回
        return rows.toArray(new String[0][]);
    }
} 
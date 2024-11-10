package zyz_system.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * CSV文件修改工具类
 * 用于修改CSV文件中的特定单元格数据
 */
public class CSVModifier {
    /**
     * 修改CSV文件中的特定数据
     * @param filePath CSV文件路径
     * @param rowIndex 要修改的行索引
     * @param colIndex 要修改的列索引
     * @param newData 新的数据值
     * @throws IOException 如果文件操作失败
     * @throws IllegalArgumentException 如果索引无效
     */
    public static void modifyCSVData(String filePath, int rowIndex, int colIndex, String newData) 
            throws IOException {
        // 读取所有行
        List<String> lines = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        
        // 验证行索引
        if (rowIndex < 0 || rowIndex >= lines.size()) {
            throw new IllegalArgumentException("行索引无效！");
        }
        
        // 将目标行分割为数组
        String[] values = lines.get(rowIndex).split(",");
        // 验证列索引
        if (colIndex < 0 || colIndex >= values.length) {
            throw new IllegalArgumentException("列索引无效！");
        }
        
        // 修改指定位置的值
        values[colIndex] = newData;
        // 将修改后的数组重新组合为CSV行
        lines.set(rowIndex, String.join(",", values));
        
        // 写回文件
        Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
    }
} 
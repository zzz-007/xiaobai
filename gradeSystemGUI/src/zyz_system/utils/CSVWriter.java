package zyz_system.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * CSV文件写入工具类
 * 用于向CSV文件添加新的数据行
 */
public class CSVWriter {
    /**
     * 向CSV文件添加新的一行数据
     * @param filePath CSV文件路径
     * @param newData 要添加的新数据数组
     * @throws IOException 如果写入过程中发生IO错误
     * @throws IllegalArgumentException 如果数据点数量不正确
     */
    public static void addRow(String filePath, String[] newData) throws IOException {
        // 验证数据长度
        if (newData.length != 32) {
            throw new IllegalArgumentException("需要32个数据点");
        }
        
        // 将数组转换为CSV行格式并写入文件
        String newLine = String.join(",", newData);
        Files.write(Paths.get(filePath), 
                   (newLine + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
                   StandardOpenOption.APPEND);
    }
} 
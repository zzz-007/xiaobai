package zyz_system.controller;

/**
 * 数据显示管理器
 * 负责处理数据的查找和显示
 */
public class DataDisplayManager {
    /**
     * 查找元素并格式化显示结果
     * @param data 数据数组
     * @param searchValue 要查找的值
     * @return 格式化的查找结果
     */
    public static String findAndFormatElement(String[][] data, String searchValue) {
        int[] index = ElementFinder.find(data, searchValue);
        if (index != null) {
            return String.format("数据 %s 在 [%d, %d]{行（首行除外），列}",
                searchValue, index[0], index[1] + 1);
        } else {
            return searchValue + " 没有被找到.";
        }
    }
} 
package zyz_system.controller;

/**
 * 数据查找控制器
 * 用于在二维数组中查找特定元素的位置
 */
public class ElementFinder {
    /**
     * 在二维数组中查找指定值的位置
     * @param data 要搜索的二维数组
     * @param searchValue 要查找的值
     * @return 包含找到的元素的行列索引的数组[row, col]，如果未找到则返回null
     */
    public static int[] find(String[][] data, String searchValue) {
        // 输入验证
        if (data == null || searchValue == null) {
            return null;
        }

        // 遍历二维数组查找元素
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].length; j++) {
                    if (searchValue.equals(data[i][j])) {
                        return new int[]{i, j};
                    }
                }
            }
        }

        // 未找到指定元素
        return null;
    }
} 
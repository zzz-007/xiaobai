package zyz_system;

import javax.swing.SwingUtilities;
import zyz_system.view.StudentManagementGUI;

/**
 * 学生成绩管理系统的主类
 * 负责启动图形用户界面
 */
public class Main {
    /**
     * 程序入口点
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        // CSV文件路径
        String filePath = "D:\\文件\\java作业数据\\作业二题目一数据（修改后UTF）.csv";
        
        // 在事件分发线程中启动GUI
        SwingUtilities.invokeLater(() -> {
            try {
                new StudentManagementGUI(filePath).setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

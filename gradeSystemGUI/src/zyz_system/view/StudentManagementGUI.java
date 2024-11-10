package zyz_system.view;

import javax.swing.*;
import java.awt.*;
import zyz_system.model.StudentData;
import zyz_system.controller.*;
import zyz_system.view.dialog.*;
import zyz_system.view.panel.*;

/**
 * 学生成绩管理系统主界面
 */
public class StudentManagementGUI extends JFrame {
    private StudentData studentData;
    private JTextArea displayArea;
    
    public StudentManagementGUI(String filePath) {
        studentData = new StudentData(filePath);
        initializeGUI();
    }
    
    private void initializeGUI() {
        setupFrame();
        setupComponents();
    }
    
    private void setupFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setTitle("学生成绩管理系统");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void setupComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // 创建按钮面板
        ButtonPanel buttonPanel = new ButtonPanel(this::handleAction);
        
        // 创建显示区域
        displayArea = new JTextArea();
        displayArea.setFont(new Font("宋体", Font.PLAIN, 14));
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        setContentPane(mainPanel);
    }
    
    private void handleAction(int actionIndex) {
        switch (actionIndex) {
            case 0: displayData(); break;
            case 1: addNewData(); break;
            case 2: findElement(); break;
            case 3: calculateScore(); break;
            case 4: findSpecificScore(); break;
            case 5: rankCourse(); break;
            case 6: rankAverage(); break;
            case 7: rankTotal(); break;
            case 8: modifyData(); break;
            case 9: System.exit(0); break;
        }
    }
    
    private void displayData() {
        displayArea.setText(ScoreDisplayManager.formatScoreTable(studentData.getData()));
    }
    
    private void findSpecificScore() {
        ScoreQueryDialog dialog = new ScoreQueryDialog(this);
        if (dialog.isConfirmed()) {
            String studentId = dialog.getStudentId();
            String courseName = dialog.getCourseName();
            if (!studentId.isEmpty() && !courseName.isEmpty()) {
                String result = ScoreDisplayManager.findSpecificScore(
                    studentData.getData(), 
                    studentId, 
                    courseName
                );
                displayArea.setText(result);
            }
        }
    }

    private void calculateScore() {
        String input = JOptionPane.showInputDialog(this, "请输入要查询的学生所在行数（首行除外）：");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int rowIndex = Integer.parseInt(input);
                String result = ScoreCalculator.calculateStudentScore(studentData.getData(), rowIndex);
                displayArea.setText(result);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "请输入有效的数字！");
            }
        }
    }

    private void rankCourse() {
        String input = JOptionPane.showInputDialog(this, "请输入课程名称所在列数：");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int colIndex = Integer.parseInt(input) - 1;
                String result = RankingManager.getCourseRanking(studentData.getData(), colIndex);
                displayArea.setText(result);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "请输入有效的数字！");
            }
        }
    }

    private void rankAverage() {
        displayArea.setText(RankingManager.getAverageRanking(studentData.getData()));
    }

    private void rankTotal() {
        displayArea.setText(RankingManager.getTotalRanking(studentData.getData()));
    }

    private void addNewData() {
        ScoreInputDialog dialog = new ScoreInputDialog(this);
        dialog.setVisible(true);
        
        String[] newData = dialog.getInputData();
        if (newData != null) {
            String result = DataManager.addNewRow(studentData.getFilePath(), newData);
            if (result.contains("成功")) {
                studentData.refreshData();
                displayData();
            }
            JOptionPane.showMessageDialog(this, result);
        }
    }

    private void findElement() {
        String searchValue = JOptionPane.showInputDialog(this, "请输入要查找的数据：");
        if (searchValue != null && !searchValue.trim().isEmpty()) {
            String result = DataDisplayManager.findAndFormatElement(
                studentData.getData(), 
                searchValue
            );
            displayArea.setText(result);
        }
    }

    private void modifyData() {
        ModifyDataDialog dialog = new ModifyDataDialog(this);
        if (dialog.isConfirmed()) {
            try {
                String result = DataManager.modifyData(
                    studentData.getFilePath(),
                    studentData.getData(),
                    dialog.getRow(),
                    dialog.getColumn(),
                    dialog.getNewValue()
                );
                
                if (result.contains("成功")) {
                    studentData.refreshData();
                    displayData();
                }
                JOptionPane.showMessageDialog(this, result);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "请输入有效的数字！");
            }
        }
    }
} 
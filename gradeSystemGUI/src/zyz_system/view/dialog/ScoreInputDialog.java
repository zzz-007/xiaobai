package zyz_system.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * 成绩输入对话框
 * 用于添加新的学生成绩数据
 */
public class ScoreInputDialog extends JDialog {
    private JTextField[] fields;
    private boolean confirmed = false;
    
    public ScoreInputDialog(JFrame parent) {
        super(parent, "添加新数据", true);
        initializeDialog();
    }
    
    private void initializeDialog() {
        setLayout(new BorderLayout());
        
        // 创建输入面板
        JPanel inputPanel = new JPanel(new GridLayout(32, 2, 5, 5));
        fields = new JTextField[32];
        
        for (int i = 0; i < 32; i++) {
            inputPanel.add(new JLabel("数据 " + (i + 1) + ": "));
            fields[i] = new JTextField(20);
            inputPanel.add(fields[i]);
        }
        
        // 创建按钮
        JButton submitButton = new JButton("提交");
        submitButton.addActionListener(e -> {
            confirmed = true;
            dispose();
        });
        
        // 添加组件
        add(new JScrollPane(inputPanel), BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        
        // 设置对话框属性
        pack();
        setLocationRelativeTo(getOwner());
    }
    
    public String[] getInputData() {
        if (!confirmed) return null;
        
        String[] data = new String[32];
        for (int i = 0; i < 32; i++) {
            data[i] = fields[i].getText().trim();
        }
        return data;
    }
} 
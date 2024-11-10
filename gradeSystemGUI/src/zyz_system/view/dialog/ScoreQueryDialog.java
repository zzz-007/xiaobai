package zyz_system.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * 成绩查询对话框
 * 用于查询特定学生的特定课程成绩
 */
public class ScoreQueryDialog extends JDialog {
    private JTextField idField;
    private JTextField courseField;
    private boolean confirmed = false;
    
    public ScoreQueryDialog(JFrame parent) {
        super(parent, "查找成绩", true);
        initializeDialog();
    }
    
    private void initializeDialog() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        idField = new JTextField();
        courseField = new JTextField();
        
        panel.add(new JLabel("学生学号："));
        panel.add(idField);
        panel.add(new JLabel("课程名称："));
        panel.add(courseField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "查找成绩",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
        confirmed = (result == JOptionPane.OK_OPTION);
    }
    
    public String getStudentId() {
        return idField.getText().trim();
    }
    
    public String getCourseName() {
        return courseField.getText().trim();
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
} 
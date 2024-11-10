package zyz_system.view.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * 数据修改对话框
 * 用于修改已有的成绩数据
 */
public class ModifyDataDialog extends JDialog {
    private JTextField rowField;
    private JTextField colField;
    private JTextField valueField;
    private boolean confirmed = false;
    
    public ModifyDataDialog(JFrame parent) {
        super(parent, "修改数据", true);
        initializeDialog();
    }
    
    private void initializeDialog() {
        JPanel panel = new JPanel(new GridLayout(3, 2));
        rowField = new JTextField();
        colField = new JTextField();
        valueField = new JTextField();
        
        panel.add(new JLabel("行号（从1开始）："));
        panel.add(rowField);
        panel.add(new JLabel("列号（从1开始）："));
        panel.add(colField);
        panel.add(new JLabel("新数据："));
        panel.add(valueField);
        
        int result = JOptionPane.showConfirmDialog(this, panel, "修改数据",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                
        confirmed = (result == JOptionPane.OK_OPTION);
    }
    
    public int getRow() {
        return Integer.parseInt(rowField.getText().trim()) - 1;
    }
    
    public int getColumn() {
        return Integer.parseInt(colField.getText().trim()) - 1;
    }
    
    public String getNewValue() {
        return valueField.getText().trim();
    }
    
    public boolean isConfirmed() {
        return confirmed;
    }
} 
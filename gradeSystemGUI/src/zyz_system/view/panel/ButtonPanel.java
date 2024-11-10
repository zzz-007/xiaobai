package zyz_system.view.panel;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

/**
 * 按钮面板类
 * 包含所有功能按钮
 */
public class ButtonPanel extends JPanel {
    public ButtonPanel(Consumer<Integer> actionHandler) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(150, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        String[] buttonLabels = {
            "显示成绩表", "添加新数据", "查找数据位置", "计算学生成绩",
            "查找具体成绩", "课程成绩排名", "平均分排名", "总分排名",
            "修改数据", "退出系统"
        };
        
        Font buttonFont = new Font("微软雅黑", Font.PLAIN, 14);
        
        for (int i = 0; i < buttonLabels.length; i++) {
            if (i > 0) {
                add(Box.createVerticalStrut(10));
            }
            
            JButton button = new JButton(buttonLabels[i]);
            button.setFont(buttonFont);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setMaximumSize(new Dimension(150, 30));
            
            final int index = i;
            button.addActionListener(e -> actionHandler.accept(index));
            add(button);
        }
        
        add(Box.createVerticalGlue());
    }
} 
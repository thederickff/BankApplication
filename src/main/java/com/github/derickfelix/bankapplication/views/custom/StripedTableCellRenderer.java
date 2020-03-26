/* * Copyright (c) 2018 VR Fortaleza. All rights reserved. * */
package com.github.derickfelix.bankapplication.views.custom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Date: Mar 1, 2018.
 *
 * @author Derick Felix
 */
public class StripedTableCellRenderer extends DefaultTableCellRenderer {

    private final DefaultTableCellRenderer renderer;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public StripedTableCellRenderer(int alignment)
    {
        renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if (isSelected) {
            c.setBackground(new Color(50, 120, 255));
            String item = (String) value;
            if (item.contains("-") && !item.contains("/") && Character.isDigit(item.charAt(0))) {
                c.setForeground(Color.CYAN);
            } else {
                c.setForeground(Color.WHITE);
            }
        } else {
            if (row % 2 == 0) {
                c.setBackground(Color.WHITE);
            } else {
                c.setBackground(new Color(230, 230, 230));
            }

            String item = (String) value;
            if (item.contains("-") && !item.contains("/") && Character.isDigit(item.charAt(0))) {
                c.setForeground(Color.RED);
            } else {
                c.setForeground(Color.BLACK);
            }
        }

        return c;
    }

}

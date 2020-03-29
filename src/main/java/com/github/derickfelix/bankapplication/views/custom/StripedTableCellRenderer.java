/*
* The MIT License
*
* Copyright (c) 2020 Derick Felix
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in all
* copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
* SOFTWARE.
 */
package com.github.derickfelix.bankapplication.views.custom;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

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
            if (item.startsWith("-") && Character.isDigit(item.charAt(1))) {
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
            if (item.startsWith("-") && Character.isDigit(item.charAt(1))) {
                c.setForeground(Color.RED);
            } else {
                c.setForeground(Color.DARK_GRAY);
            }
        }

        return c;
    }

}

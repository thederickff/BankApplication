/*
 * The MIT License
 *
 * Copyright 2019 Derick Felix.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.derickfelix.bankapplication;

import com.github.derickfelix.bankapplication.views.Login;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author derickfelix
 */
public class BankApplication {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the System look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            String systemLookAndFeel = javax.swing.UIManager.getSystemLookAndFeelClassName();
            javax.swing.UIManager.setLookAndFeel(systemLookAndFeel);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Error: " + e);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(() -> {
            Login login = new Login(new javax.swing.JFrame(), true);
            login.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            login.setVisible(true);
        });
    }
}

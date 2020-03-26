/*
* The MIT License
*
* Copyright (c) 2019 Derick Felix
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
package com.github.derickfelix.bankapplication.utilities;

import com.github.derickfelix.bankapplication.views.dialogs.ExceptionDialog;
import javax.swing.JOptionPane;

public class MessageUtility {

    private MessageUtility()
    {
    }
    
    public static void info(String message)
    {
        info(null, message);
    }
    
    public static void info(java.awt.Frame parent, String message)
    {
        JOptionPane.showMessageDialog(parent, message, "Zwei Bank Application", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Show an exception dialog with two buttons, okay (closes the dialog) and
     * detail (shows another dialog detailing the exception).
     *
     * @param parent the calling frame of this dialog
     * @param e the exception which this dialog is showing
     */
    public static void error(java.awt.Frame parent, Exception e)
    {
        error(parent, e.getMessage(), e);
    }

    public static void error(java.awt.Frame parent, String message, Exception e)
    {
        Object[] choices = {"Ok", "Details >>>"};
        Object defaultChoice = choices[1];

        if (JOptionPane.showOptionDialog(null, message, "Bank Application", JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE, null, choices, defaultChoice) == 1) {
            new ExceptionDialog(parent, true, e).setVisible(true);
        }
    }
}

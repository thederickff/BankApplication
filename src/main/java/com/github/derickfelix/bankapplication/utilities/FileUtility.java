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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtility {
    private FileUtility()
    {
    }
    
    public static String home()
    {
        return System.getProperty("os.name").contains("Linux") ? "~/.zweibank/" : "C:\\zweibank\\";
    }
    
    public static void write(List<String> lines, String pathFile)
    {
        try (PrintWriter writer = new PrintWriter(pathFile)) {
            lines.forEach(line -> {
               writer.println(line);
            });
        } catch (IOException e) {
            MessageUtility.error(null, e);
        }
    }

    /**
     * Exports a table data to a file, user informs which colunms they
     * want, and a file divided by ';' will be generated.
     *
     * @param rows each row (String[]) has many columns
     * @param columns only export columns with the true value
     * @param filePath the path where the content will be exported
     */
    public static void exportTableDataToFile(List<String[]> rows, boolean[] columns, String filePath) throws Exception
    {
        if (rows.isEmpty()) {
            throw new Exception("Could not export, there is no data");
        }

        if (rows.get(0).length != columns.length) {
            throw new Exception("Could not export, the amount of columns is not the same of the columns of the data");
        }

        List<String> lines = rows.stream().map(row -> {

            String line = "";

            for (int i = 0; i < row.length; ++i) {
                if (columns[i]) {
                    line += row[i] + ";";
                }
            }

            return line;
        }).collect(Collectors.toList());

        write(lines, filePath);
    }
}

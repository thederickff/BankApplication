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
package com.github.derickfelix.bankapplication.database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * An interface used by {@link BankAppTemplate BankAppTemplate} for mapping rows of a
 * ResultSet on a per-row bases. Implementations of this interface perform the
 * actual work of mapping each row to a result object, but don't need to worry
 * about exception handling. {@code SQLExceptions} will be caught and handled by
 * the calling {@code BankAppTemplate}.
 *
 * @author derickfelix
 *
 * @param <T> the model of the row mapper
 */
public interface RowMapper<T> {
    
    /**
     * Implementations must implement this method to map each row of data in the
     * ResultSet. This method should not call next() on the ResultSet; it is
     * only supposed to map values of the current row.
     *
     * @param rs the ResultSet to map (pre-initialized for the current row)
     * @return the result object for the current row (may be null)
     * @throws java.sql.SQLException if a SQLException is encountered getting
     * column values (that is, there's no need to catch SQLException)
     */
    T mapRow(ResultSet rs) throws SQLException;
    
}

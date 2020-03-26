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

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.repositories.impl.UserRepositoryImpl.UserMapper;
import java.sql.SQLException;
import java.util.Optional;
import org.h2.tools.Server;

public class DBUtility {

    private static final BankAppTemplate template = new BankAppTemplate();

    private DBUtility()
    {
    }

    public static void prepare()
    {
        try {
            Server.createWebServer().start();
            checkDatabase();
        } catch (SQLException e) {
            MessageUtility.error(null, e);
        }
    }

    private static void checkDatabase()
    {
        checkTable("customers",
                "id identity", "name varchar", "address varchar",
                "sex char", "account_number varchar", "account_type varchar"
        );
        
        checkTable("staffs",
                "id identity", "name varchar", "address varchar",
                "sex char", "rank varchar"
        );
        
        checkTable("users",
                "id identity", "name varchar", "username varchar unique",
                "password varchar", "role varchar"
        );
        
        checkTable("deposits",
                "id identity", "account_number varchar", "deposit_amount decimal"
        );
        
        checkTable("withdraws",
                "id identity", "account_number varchar", "withdraw_amount decimal"
        );
        
        checkDefaultUser();
    }

    private static void checkTable(String tableName, String... fields)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("create table if not exists ");
        builder.append(tableName);
        builder.append('(');

        for (int i = 0; i < fields.length - 1; ++i) {
            builder.append(fields[i]);
            builder.append(", ");
        }

        builder.append(fields[fields.length - 1]);
        builder.append(')');

        template.update(builder.toString(), null);
    }
    
    private static void checkDefaultUser()
    {
        String sql = "select * from users where username = 'root'";
        Optional<User> optional = template.queryForObject(sql, null, new UserMapper());
        
        if (!optional.isPresent()) {            
            template.update("insert into users (name, username, password, role) values ('Admin', 'root', HASH('SHA256', '1234'), 'admin')", null);
        }
    }
}

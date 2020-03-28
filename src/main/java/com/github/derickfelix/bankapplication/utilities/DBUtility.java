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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
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
        
        // Optional
        seedTables();
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
            template.update("insert into users (name, username, password, role) values ('Admin User', 'root', HASH('SHA256', 'admin'), 'Administrator')", null);
        }
    }
    
    private static void seedTables()
    {
        if (!hasData("users")) {
            seedUsers();
        }
        if (!hasData("customers")) {
            seedCustomers();
        }
    }
    
    private static boolean hasData(String table)
    {
        String sql = "select count(*) as count from " + table;
        
        Integer count = template.queryForObject(sql, null, (ResultSet rs) -> rs.getInt("count")).orElse(0);
        
        return count > 0;
    }
    
    private static void seedUsers()
    {
        StringBuilder sql = new StringBuilder("insert into users (name, username, password, role) values\n");
        Random random = new Random();
        String[] maleNames = maleNames();
        String[] femaleNames = femaleNames();
        int amount = 100;

        for (int i = 0; i < amount; i++) {
            sql.append('(');
            boolean male = random.nextBoolean();
            String firstName = male ? maleNames[random.nextInt(maleNames.length)] : femaleNames[random.nextInt(femaleNames.length)];

            // Full name
            sql.append("'");
            sql.append(firstName);
            sql.append(' ');
            sql.append(maleNames[random.nextInt(maleNames.length)]);
            sql.append("', '");
            // username
            sql.append(firstName.toLowerCase());
            sql.append(random.nextInt(1000));
            // password
            sql.append("', HASH('SHA256', '123456'), 'Standard')");

            if ((i + 1) < amount) {
                sql.append(",\n");
            }
        }

        template.update(sql.toString(), null);
    }

    private static void seedCustomers()
    {
        StringBuilder sql = new StringBuilder("insert into customers (name, address, sex, account_number, account_type) values\n");
        Random random = new Random();
        String[] maleNames = maleNames();
        String[] femaleNames = femaleNames();
        String[] states = states();
        int amount = 1000;

        for (int i = 0; i < amount; i++) {
            sql.append('(');
            boolean male = random.nextBoolean();
            
            // Full name
            sql.append("'");
            sql.append(male ? maleNames[random.nextInt(maleNames.length)] : femaleNames[random.nextInt(femaleNames.length)]);    
            sql.append(' ');
            sql.append(maleNames[random.nextInt(maleNames.length)]);    
            
            sql.append("', '");
            // address
            sql.append(random.nextInt(8066) + 1000);
            sql.append(" Example St, ");
            sql.append(states[random.nextInt(states.length)]);
            sql.append(' ');
            sql.append(random.nextInt(38208) + 1000);
            
            sql.append("', '");
            // sex
            sql.append(male ? 'm': 'f');
            sql.append("', '");
            // account number
            sql.append(random.nextInt(175665) + 100000);
            sql.append("-");
            sql.append(random.nextInt(1000) + 100);
            sql.append("', '");
            // account type
            sql.append(random.nextBoolean() ? "Current" : "Savings");
            sql.append("')");
            
            if ((i + 1) < amount) {
                sql.append(",\n");
            }
        }
        
        template.update(sql.toString(), null);
    }
    
    private static String[] maleNames()
    {
        return new String[] {
            "Jeff", "Abel", "Daron", "Lenard", "Reinaldo", "Earnest",
            "Gilberto", "Thaddeus", "Rafael", "Leland", "Cristopher",
            "Nickolas", "Darrick", "Jon", "Houston", "Rashad",
            "Jason", "Archie", "Carmen", "Thurman", "Forest", "Dannie",
            "Dick", "David", "Nick", "Stefan", "Stephen", "Mauricio",
            "Sidney", "Pat", "Garry", "Dee", "Rosario", "Ellis",
            "Bob", "Julio", "Chung", "Raymond", "Timmy", "Xavier",
            "Clay", "Clark", "Kris", "Raleigh", "Neville", "Brendon",
            "Wilford", "Zachariah", "Ollie", "Silas", "Terry", "Bennett",
            "Asa", "Olen", "Everett", "Benjamin", "Bobbie", "Renaldo",
            "Murray", "Josue", "Jamison", "Boyce", "Carson", "Edgardo",
            "Kenton", "Ernesto", "Brain", "Jack", "Truman", "Les", "Antonia",
            "Thurman", "Robby", "Kris", "Raymon", "Adam", "Damon", "Bernardo",
            "Christoper", "Hank", "Man", "Ivory", "Markus", "Weston",
            "Kendall", "Edmond", "Royal", "Mervin", "Art", "Moshe",
            "Dorian", "Eugenio", "Noe", "Ronald", "Emerson", "Ambrose",
            "Avery", "Miquel", "Ruben", "Wyatt"
        };
    }
    
    private static String[] femaleNames()
    {
        return new String[] {
            "Eladia", "Phylicia", "Karey", "Lissa", "Shela", "Maryetta",
            "Kimberely", "Estrella", "Bev", "Vallie", "Tonda", "Carline",
            "Agripina", "Tiffani", "Yan", "Dori", "Amberly", "Noreen",
            "Susan", "Josphine", "Garnet", "Cori", "Trina", "Lyla", "Felicia",
            "Nikole", "Katelynn", "Laveta", "Latasha", "Inell", "Teressa",
            "Temple", "Oma", "Marlen", "Larhonda", "Fae", "Carole", "Tess", 
            "Zofia", "Noelia", "Lyndsay", "Odessa", "Yolanda", "Antonina", 
            "Delorse", "Marry", "Misty", "Winnifred", "Alethia", "Marth"
        };
    }
    
    private static String[] states()
    {
        return new String[] {
           "NY", "CA", "MS", "MD", "GA", "PA", "NJ", "WI", "IL", "MA",
           "CT", "SC", "NC", "VA", "TN", "FL"
        };
    }
}

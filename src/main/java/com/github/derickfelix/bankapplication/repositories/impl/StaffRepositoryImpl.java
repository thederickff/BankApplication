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
package com.github.derickfelix.bankapplication.repositories.impl;

import com.github.derickfelix.bankapplication.database.BankAppTemplate;
import com.github.derickfelix.bankapplication.database.RowMapper;
import com.github.derickfelix.bankapplication.models.Staff;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.github.derickfelix.bankapplication.repositories.StaffRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StaffRepositoryImpl implements StaffRepository {

    private final BankAppTemplate template;
    
    public StaffRepositoryImpl()
    {
        this.template = new BankAppTemplate();
    }

    @Override
    public List<Staff> findAll()
    {
        String sql = "select * from staffs";

        return template.queryForList(sql, null, new StaffMapper());
    }

    @Override
    public Optional<Staff> find(Long id)
    {
        String sql = "select * from staffs where id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return template.queryForObject(sql, params, new StaffMapper());
    }

    @Override
    public void save(Staff model)
    {
        String sql;
        Map<String, Object> params = new HashMap<>();

        if (model.getId() != null) {
            sql = "insert into staffs (name, address, sex, rank) "
                    + "values (:name, :address, :sex, :rank)";
        } else {
            sql = "update staffs set name = :name, address = :address, "
                    + "sex = :sex, rank = :rank where id = :id";

            params.put("id", model.getId());
        }

        params.put("name", model.getName());
        params.put("address", model.getAddress());
        params.put("sex", model.getSex());
        params.put("rank", model.getRank());

        template.update(sql, params);
    }

    @Override
    public Optional<Staff> deleteById(Long id)
    {
        Optional<Staff> optional = find(id);

        optional.ifPresent(staff -> {
            String sql = "delete from staffs where id = :id";
            Map<String, Object> params = new HashMap<>();
            params.put("id", staff.getId());

            template.update(sql, params);
        });

        return optional;
    }
   
    public class StaffMapper implements RowMapper<Staff> {

        @Override
        public Staff mapRow(ResultSet rs) throws SQLException
        {
            Staff staff = new Staff();
            staff.setId(rs.getLong("id"));
            staff.setName(rs.getString("name"));
            staff.setAddress(rs.getString("address"));
            staff.setSex(rs.getString("sex").charAt(0));
            staff.setRank(rs.getString("rank"));

            return staff;
        }
        
    }
}

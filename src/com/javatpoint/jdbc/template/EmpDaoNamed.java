package com.javatpoint.jdbc.template;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus x556 on 24-Nov-16.
 */
public class EmpDaoNamed {
    private NamedParameterJdbcTemplate template;

    public EmpDaoNamed(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    public void save(Employee e){
        String query = "insert into employee values(:id,:name,:salary)";
        Map<String,Object> map = new HashMap<>();
        map.put("id",e.getId());
        map.put("name",e.getName());
        map.put("salary",e.getSalary());
        template.execute(query,map, new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.execute();
            }
        });

    }
}

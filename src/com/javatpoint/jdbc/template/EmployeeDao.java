package com.javatpoint.jdbc.template;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ionela on 11/22/2016.
 */
public class EmployeeDao {

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveEmployee(Employee e){
        String query = "insert into employee values('"
                +e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
        return jdbcTemplate.update(query);
    }
    public int updateEmployee(Employee e){
        String query="update employee set   name='"
                +e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public int deleteEmployee(Employee e){
        String query="delete from employee where id='"+e.getId()+"' ";
        return jdbcTemplate.update(query);
    }
    public Boolean saveEmployeeByPreparedStatement(final Employee e){
        String query="insert into employee values(?,?,?)";
        return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                preparedStatement.setInt(1,e.getId());
                preparedStatement.setString(2,e.getName());
                preparedStatement.setFloat(3,e.getSalary());
                return preparedStatement.execute();
            }
        });
    }
    public List<Employee> getAllEmployees(){
        return jdbcTemplate.query("select * from employee", new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Employee> list = new ArrayList<Employee>();
                while(resultSet.next()){
                    Employee e = new Employee();
                    e.setId(resultSet.getInt(1));
                    e.setName(resultSet.getString(2));
                    e.setSalary(resultSet.getInt(3));
                    list.add(e);
                }

                return list;
            }
        });
    }
}

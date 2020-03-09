package ru.kuper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.kuper.User;

import javax.sql.DataSource;

@Repository
public class DatabaseDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    protected void setDatasource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public boolean createTable(String tableName) {
        boolean success = false;

        try {
            jdbcTemplate.execute("CREATE TABLE "+ tableName + " (id INT IDENTITY, name varchar(30), age INT, sex varchar(1))");
            success = true;
        } catch (DataAccessException ex) {
            //logging
        }
        return success;
    }

    public boolean dropTable(String tableName){
        boolean success = false;

        try {
            jdbcTemplate.execute("DROP TABLE "+ tableName);
            success = true;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean insertUser(User user, String tableName) {
        boolean success = false;
        if (user != null) {
            try {
                success = jdbcTemplate.update("INSERT INTO "+ tableName + "VALUES(null,?,?,?)",user.getName(),user.getAge(), user.getSex()) == 1;
            } catch (DataAccessException ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }



}

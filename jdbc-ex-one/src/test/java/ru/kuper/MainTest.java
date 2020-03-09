package ru.kuper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import ru.kuper.dao.DatabaseDAO;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    private DatabaseDAO dao = null;

    @Autowired
    private Environment env;

//    @Value("${tableName}")
    private String tableName;

    @Before
    public void setup() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = applicationContext.getBean(DatabaseDAO.class);
        tableName = env.getProperty("tableName");
    }

//    @Test
//    public void createAndDropTable() {
//        assertTrue(dao.createTable(tableName));
//        assertTrue(dao.dropTable(tableName));
//        assertEquals("user_table", tableName);
//    }

    @Test
    public void testDB() {
        User user = new User();
        user.setName("Alex");
        user.setAge(12);
        user.setSex("M");


    }


}

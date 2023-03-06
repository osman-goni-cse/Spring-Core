package com.learnwithosman;

import com.learnwithosman.dao.StudentDao;
import com.learnwithosman.dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("5v*RjZZWSVUXnVH#");

        return driverManagerDataSource;
    }
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

//    By Default Bean Name will be method name
//    Below code can be replace with @Autowired
    @Bean(name = { "studentDao" })
    public StudentDao studentDao() {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.setJdbcTemplate(getJdbcTemplate());
        return studentDao;
    }
}

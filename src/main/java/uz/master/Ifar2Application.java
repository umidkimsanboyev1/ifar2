package uz.master;

import org.postgresql.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Ifar2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ifar2Application.class, args);
    }


}

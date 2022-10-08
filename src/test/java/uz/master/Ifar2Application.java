package uz.master;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@EnableJpaRepositories()
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Ifar2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ifar2Application.class, args);
    }

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/ifar_uz")
                .username("postgres")
                .password("apalon13")
                .build();
    }
}

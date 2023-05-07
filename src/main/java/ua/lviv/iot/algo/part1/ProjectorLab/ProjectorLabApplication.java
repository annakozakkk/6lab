package ua.lviv.iot.algo.part1.ProjectorLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan({"ua.lviv.iot.algo.part1.dataaccess",
        "ua.lviv.iot.algo.part1.business",
        "ua.lviv.iot.algo.part1.ProjectorLab.controller"})
//@EnableJpaRepositories({"ua.lviv.iot.algo.part1.dataaccess"})
public class ProjectorLabApplication {


    public static void main(String[] args) {
        SpringApplication.run(ProjectorLabApplication.class, args);
    }

}

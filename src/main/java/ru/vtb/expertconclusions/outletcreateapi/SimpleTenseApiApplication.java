package ru.vtb.expertconclusions.outletcreateapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.vtb.expertconclusions.outletcreateapi.job.Job;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.WorldService;
import ru.vtb.expertconclusions.outletcreateapi.service.printservice.world.impl.WorldServiceImpl;

@SpringBootApplication
public class SimpleTenseApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SimpleTenseApiApplication.class, args);
        System.setProperty("java.awt.headless", "false");
        SimpleTenseApiApplication outletCreateApiApplication = new SimpleTenseApiApplication();
        outletCreateApiApplication.job(context);
    }

    private void job(ConfigurableApplicationContext context) {
        Job job = context.getBean(Job.class);
        WorldService worldService=context.getBean(WorldServiceImpl.class);
        job.job();
    }

}

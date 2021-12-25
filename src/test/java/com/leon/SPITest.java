package com.leon;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Driver;
import java.util.ServiceLoader;

@SpringBootTest
public class SPITest {

    /**
     * 查询所有
     */
    @Test
    void showAllDriverInfo() {
        ServiceLoader<Driver> drivers = ServiceLoader.load(Driver.class);
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }

}

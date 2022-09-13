package com.pequenosgenios.pg.config;

import com.pequenosgenios.pg.services.impl.DBService;
import org.springframework.beans.factory.annotation.Autowired;

//@Configuration
//@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

//    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateTestDatabase();
        return true;
    }

}

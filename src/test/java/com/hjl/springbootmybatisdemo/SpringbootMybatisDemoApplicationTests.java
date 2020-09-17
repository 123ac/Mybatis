package com.hjl.springbootmybatisdemo;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {

    private static final Logger logger= Logger.getLogger(SpringbootMybatisDemoApplicationTests.class);
    @Test
    void contextLoads() {
        logger.info("test");
    }

}

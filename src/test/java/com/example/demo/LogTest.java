package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.taf.log.TAFLog;
import com.example.demo.test1.component.TestLogComponent;

@RunWith(SpringRunner.class)
// 引入SpringBootTest并生成随机接口
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LogTest {
    // 注入随机接口
    @LocalServerPort
    private int port;

    @Autowired
    private TestLogComponent testLogComponent;

    @Test
    public void testLog() {
        // testLogComponent.test();
        testLogComponent.test1();
    }

    public static void main(String[] args) {
        TAFLog.error("sss");
    }
}

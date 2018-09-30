package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.test1.component.TaskComponent;

@RunWith(SpringRunner.class)
// 引入SpringBootTest并生成随机接口
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AsyncTest {

    // 注入随机接口
    @LocalServerPort
    private int port;

    @Autowired
    private TaskComponent taskComponent;

    @Test
    public void testTask() {
        try {
            taskComponent.test1();
            taskComponent.test2();
            taskComponent.test3();
            System.out.println("执行主线程");
            // 主线程休眠10秒等待上述异步方法执行
            Thread.sleep(10000);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}

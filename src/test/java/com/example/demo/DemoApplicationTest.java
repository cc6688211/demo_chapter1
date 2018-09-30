package com.example.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.demo.test1.pojo.Param;
import com.example.demo.test1.pojo.Params;

@RunWith(SpringRunner.class)
// 引入SpringBootTest并生成随机接口
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTest {
    // 注入随机接口
    @LocalServerPort
    private int port;

    // 引入测试模版类
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private Param param;

    @Autowired
    private Params params;

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Test
    public void testHello() {
        System.out.println(port);
        // 构建参数
        MultiValueMap < String, Object > form = new LinkedMultiValueMap <>();
        // 使用restTemplate的exchange方法进行调用
        ResponseEntity < String > entity = this.restTemplate.exchange("/hello", HttpMethod.POST,
                new HttpEntity <>(form, null), String.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
    }

    @Test
    public void testSwagger2() {
        MultiValueMap < String, Object > form = new LinkedMultiValueMap <>();
        form.set("id", 1);
        form.set("name", "cc");
        form.set("age", 18);
        ResponseEntity < String > entity = this.restTemplate.exchange("/testSwagger/users/", HttpMethod.POST,
                new HttpEntity <>(form, null), String.class);
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getBody());
        ResponseEntity < String > entity1 = this.restTemplate.exchange("/testSwagger/users/", HttpMethod.GET,
                new HttpEntity <>(form, null), String.class);
        System.out.println(entity1.getStatusCode());
        System.out.println(entity1.getBody());
        ResponseEntity < String > entity2 = this.restTemplate.exchange("/testSwagger/users/1?id=1&name=ccc&age=28",
                HttpMethod.PUT, new HttpEntity <>(null, null), String.class);
        System.out.println(entity2.getStatusCode());
        System.out.println(entity2.getBody());
        ResponseEntity < String > entity3 = this.restTemplate.exchange("/testSwagger/users/", HttpMethod.GET,
                new HttpEntity <>(form, null), String.class);
        System.out.println(entity3.getStatusCode());
        System.out.println(entity3.getBody());
    }

    @Test
    public void testPropertiesParams() {
        System.out.println(param.toString());
        System.out.println(params.toString());
    }
}

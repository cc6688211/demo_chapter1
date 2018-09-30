
/**
 * @模块名：demo
 * @包名：com.example.demo.test1.component
 * @描述：SchedulingComponent.java
 * @版本：1.0
 * @创建人：cc
 * @创建时间：2018年9月29日上午10:19:37
 */

package com.example.demo.test1.component;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @模块名：demo
 * @包名：com.example.demo.test1.component @类名称： SchedulingComponent
 * @类描述：【类描述】用于测试定时任务 @版本：1.0
 * @创建人：cc
 * @创建时间：2018年9月29日上午10:19:37
 */
@Component
public class SchedulingComponent {

   /**
    * 
    * @方法名：testScheduling1
    * @方法描述【方法功能描述】测试定时任务，没三秒执行一次
    * @修改描述【修改描述】
    * @版本：1.0
    * @创建人：cc
    * @创建时间：2018年9月29日 上午10:26:20
    * @修改人：cc
    * @修改时间：2018年9月29日 上午10:26:20
    */
    @Scheduled(fixedRate = 3000)
    public void testScheduling1() {

        System.out.println("执行时间为"+new Date()+"执行testScheduling1");
    }
}

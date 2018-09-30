
/**
 * @模块名：demo
 * @包名：com.example.demo.taf.log
 * @描述：TAFLog.java
 * @版本：1.0
 * @创建人：cc
 * @创建时间：2018年9月29日下午2:48:43
 */

package com.example.demo.taf.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @模块名：demo
 * @包名：com.example.demo.taf.log 
 * @类名称： TAFLog
 * @类描述：【类描述】 log4j2封装工具类
 * @版本：1.0
 * @创建人：cc
 * @创建时间：2018年9月29日下午2:48:43
 */

public class TAFLog {
    public static String top = "";

    private static Logger log = LogManager.getLogger();;

    public static void debug(String message) {
        if (log.isDebugEnabled()) {
            log.debug(top + "-" + message);
        }
    }

    public static void debug(String message, Exception e) {
        if (log.isDebugEnabled()) {
            getTop();
            log.debug(top + "-" + message, e);
        }
    }

    public static void info(String message) {
        if (log.isInfoEnabled()) {
            getTop();
            log.info(top + "-" + message);
        }
    }

    public static void info(String message, Exception e) {
        if (log.isInfoEnabled()) {
            getTop();
            log.info(top + "-" + message, e);
        }
    }

    public static void warn(String message) {
        getTop();
        log.warn(top + "-" + message);
    }

    public static void warn(String message, Exception e) {
        getTop();
        log.warn(top + "-" + message, e);
    }

    public static void error(String message) {
        getTop();
        log.error(top + "-" + message);
    }

    public static void error(String message, Exception e) {
        getTop();
        log.error(top + "-" + message, e);
    }

    public static void getTop() {
        // 获取堆栈信息
        StackTraceElement[] callStack = Thread.currentThread().getStackTrace();
        if (null == callStack) {
            top = "";
        }
        else {
            // 最原始被调用的堆栈信息
            StackTraceElement caller = null;
            // 日志类名称
            String logClassName = TAFLog.class.getName();
            // 循环遍历到日志类标识
            boolean isEachLogClass = false;

            // 遍历堆栈信息，获取出最原始被调用的方法信息
            for (StackTraceElement s : callStack) {
                // 遍历到日志类
                if (logClassName.equals(s.getClassName())) {
                    isEachLogClass = true;
                }
                // 下一个非日志类的堆栈，就是最原始被调用的方法
                if (isEachLogClass) {
                    if (!logClassName.equals(s.getClassName())) {
                        isEachLogClass = false;
                        caller = s;
                        break;
                    }
                }
            }
            top = caller.toString();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        TAFLog.error("自定义LOG");
    }
}

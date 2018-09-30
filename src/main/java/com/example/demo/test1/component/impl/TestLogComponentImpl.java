package com.example.demo.test1.component.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.example.demo.taf.log.TAFLog;
import com.example.demo.test1.component.TestLogComponent;

@Component
public class TestLogComponentImpl implements TestLogComponent {
	static final Logger logger = LogManager.getLogger(TestLogComponentImpl.class.getName());

	@Override
	public void test() {
		// TODO Auto-generated method stub
		logger.info("String类型");
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			logger.error("Error类型", e);
		}

	}

	@Override
    public void test1() {
		TAFLog.info("String类型");
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			TAFLog.error("Error类型", e);
		}

	}

}

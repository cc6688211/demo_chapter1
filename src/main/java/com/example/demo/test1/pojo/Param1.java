package com.example.demo.test1.pojo;

import java.util.Arrays;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "com.tit.properties.param")
@PropertySource(value = { "config/param.properties" })
@Component("param1")
public class Param1 {
	private String name;

	private String value;

	private String desc;

	private String random;

	private int random1;

	private long random2;

	private int random3;

	private int random4;

	private String[] strArr;

	private int[] intArr;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRandom() {
		return random;
	}

	public void setRandom(String random) {
		this.random = random;
	}

	public int getRandom1() {
		return random1;
	}

	public void setRandom1(int random1) {
		this.random1 = random1;
	}

	public long getRandom2() {
		return random2;
	}

	public void setRandom2(long random2) {
		this.random2 = random2;
	}

	public int getRandom3() {
		return random3;
	}

	public void setRandom3(int random3) {
		this.random3 = random3;
	}

	public int getRandom4() {
		return random4;
	}

	public void setRandom4(int random4) {
		this.random4 = random4;
	}

	public String[] getStrArr() {
		return strArr;
	}

	public void setStrArr(String[] strArr) {
		this.strArr = strArr;
	}

	public int[] getIntArr() {
		return intArr;
	}

	public void setIntArr(int[] intArr) {
		this.intArr = intArr;
	}

	@Override
	public String toString() {
		return "Param [name=" + name + ", value=" + value + ", desc=" + desc + ", random=" + random + ", random1="
				+ random1 + ", random2=" + random2 + ", random3=" + random3 + ", random4=" + random4 + ", strArr="
				+ Arrays.toString(strArr) + ", intArr=" + Arrays.toString(intArr) + "]";
	}

}

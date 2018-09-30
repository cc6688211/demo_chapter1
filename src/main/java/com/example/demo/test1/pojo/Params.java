package com.example.demo.test1.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("params")
public class Params {
	@Value("${com.tit.properties.params.name}")
	private String name;

	@Value("${com.tit.properties.params.value}")
	private String value;

	@Value("${com.tit.properties.params.desc}")
	private String desc;

	@Value("${com.tit.properties.params.random}")
	private String random;

	@Value("${com.tit.properties.params.random1}")
	private int random1;

	@Value("${com.tit.properties.params.random2}")
	private long random2;

	@Value("${com.tit.properties.params.random3}")
	private int random3;

	@Value("${com.tit.properties.params.random4}")
	private int random4;

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

	@Override
	public String toString() {
		return "Params [name=" + name + ", value=" + value + ", desc=" + desc + ", random=" + random + ", random1="
				+ random1 + ", random2=" + random2 + ", random3=" + random3 + ", random4=" + random4 + "]";
	}

}

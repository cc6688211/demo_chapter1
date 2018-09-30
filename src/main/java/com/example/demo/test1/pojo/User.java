package com.example.demo.test1.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "User", description = "用户对象user")
public class User {
	// @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
	// value–字段说明
	// name–重写属性名字
	// dataType–重写属性类型
	// required–是否必填
	// example–举例说明
	// hidden–隐藏
	@ApiModelProperty(value = "id", name = "id", example = "1", required = true)
	private Long id;

	@ApiModelProperty(value = "名称", name = "id", example = "cc")
	private String name;

	@ApiModelProperty(value = "年龄", name = "id", example = "18", hidden = true)
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
		super();
	}

}

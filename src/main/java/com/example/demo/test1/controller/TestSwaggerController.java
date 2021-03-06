package com.example.demo.test1.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test1.pojo.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

//Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
//如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
@RestController
@RequestMapping(value = "/testSwagger")
// 指明类作用，前端展示格式为tags+description
@Api(value = "testSwaggerController", tags = { "用户管理接口" }, description = "测试Swagger2")
public class TestSwaggerController {

	// 创建线程安全的Map
	static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

	@ApiOperation(value = "获取用户列表", notes = "")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}

	// 添加方法描述
	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	// 添加参数描述
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User", paramType = "body")
	@RequestMapping(value = "", method = RequestMethod.POST)
	// 指明参数取值类型为RequestBody
	public String postUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	// 指明参数取值类型为PathVariable
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	// 多个参数添加说明方式
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
			@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User", paramType = "query") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @RequestBody User user) {
		User u = users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		users.remove(id);
		return "success";
	}

	// 标注此注解则不添加到 Swagger Api中；也可直接标注到类上
	@ApiIgnore
	@RequestMapping(value = { "testApiIgnore" }, method = RequestMethod.GET)
	public List<User> testApiIgnore() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}
}

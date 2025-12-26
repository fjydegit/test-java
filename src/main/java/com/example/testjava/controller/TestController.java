package com.example.testjava.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/test")
public class TestController {

    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public Map<String, Object> healthCheck() {
        Map<String, Object> result = new HashMap<>();
        result.put("status", "UP");
        result.put("message", "服务运行正常");
        result.put("timestamp", System.currentTimeMillis());
        return result;
    }

    /**
     * 欢迎接口
     */
    @GetMapping("/welcome")
    public Map<String, String> welcome() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "欢迎使用测试API服务");
        result.put("version", "1.0.0");
        return result;
    }

    /**
     * 获取用户信息接口
     */
    @GetMapping("/user/{id}")
    public Map<String, Object> getUser(@PathVariable String id) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "测试用户" + id);
        user.put("email", "user" + id + "@example.com");
        user.put("createdAt", System.currentTimeMillis());
        return user;
    }

    /**
     * 创建用户接口
     */
    @PostMapping("/user")
    public Map<String, Object> createUser(@RequestBody Map<String, String> userRequest) {
        Map<String, Object> result = new HashMap<>();
        result.put("id", "user_" + System.currentTimeMillis());
        result.put("name", userRequest.get("name"));
        result.put("email", userRequest.get("email"));
        result.put("status", "created");
        result.put("createdAt", System.currentTimeMillis());
        return result;
    }

    /**
     * 计算接口
     */
    @GetMapping("/calculate")
    public Map<String, Object> calculate(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b) {
        Map<String, Object> result = new HashMap<>();
        result.put("a", a);
        result.put("b", b);
        result.put("sum", a + b);
        result.put("difference", a - b);
        result.put("product", a * b);
        result.put("quotient", b != 0 ? (double) a / b : "undefined");
        return result;
    }
}

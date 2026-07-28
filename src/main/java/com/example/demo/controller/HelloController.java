package com.example.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.LoginDTO;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String showHelloPage(Model model) {
        model.addAttribute("message", "Spring MVC 구조 실습");
        return "hello";
    }

    @GetMapping("/user")
    @ResponseBody
    public String getUser(@RequestParam("id") String userId) {
        return "User ID: " + userId;
    }

    @GetMapping("/page")
    @ResponseBody
    public String page(@RequestParam(value = "size", required = false) Integer size) {
        return "페이지 크기: " + size;
    }

    @GetMapping("/search")
    @ResponseBody
    public String search(
            @RequestParam("keyword") String keyword,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        return "검색어: " + keyword + ", 페이지: " + page;
    }

    @GetMapping("/params")
    @ResponseBody
    public String params(@RequestParam Map<String, String> paramMap) {
        return "요청 파라미터: " + paramMap;
    }

    // 경로 변수(@PathVariable)를 이용한 단건 조회
    @GetMapping("/item/{id}")
    @ResponseBody
    public String getItem(@PathVariable("id") int id, Model model) {
        model.addAttribute("message", "상품번호: " + id);
        System.out.println("상품번호: " + id);
        return "itemDetail";
    }

    // 다중 URL 매핑과 선택적 경로 변수(required = false)
    @GetMapping({ "/user/{id}", "/users" })
    @ResponseBody
    public String getUser(@PathVariable(value = "id", required = false) Integer id) {
        if (id == null) {
            return "전체 사용자 목록";
        }
        return "사용자 ID: " + id;
    }

    // @GetMapping("/info")
    // public String showInfo(Model model) {
    //     model.addAttribute("title", "Spring MVC");
    //     model.addAttribute("version", "3.x");
    //     return "info";
    // }

    @GetMapping("/info")
    public ModelAndView showInfo(Model model) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "Spring MVC");
        mav.addObject("version", "3.x");
        mav.setViewName("info");
        return mav;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("login") LoginDTO dto) {
        dto.setUserid("honggildong");
        dto.setPasswd(12345678);
        return "success";
    }
}

package hello.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

// 스프링 타입 컨버터 - 스프링 타입 컨버터 소개
// 문자 타입을 숫자 타입으로 변경
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request) {
        // HTTP 요청 파라미터는 모두 문자로 처리된다. 숫자 10이 아닌 문자 10이 오는거다.
        // "data"라는 파라미터가 넘어오면 문자 타입 조회
        String data = request.getParameter("data");
        Integer intValue = Integer.valueOf(data); // 숫자 타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    // 스프링 MVC가 제공하는 @RequestParam 을 사용
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data) {
        System.out.println("data = " + data);
        return "ok";
    }
}
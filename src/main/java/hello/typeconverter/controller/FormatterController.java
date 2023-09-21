package hello.typeconverter.controller;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

// 스프링 타입 컨버터 - 스프링이 제공하는 기본 포맷터
@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";
    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form) {
        // @ModelAttribute는 자동으로 model.addAttribute("form", form)으로 담아준다.
        return "formatter-view";
    }

    @Data
    static class Form {
        // 숫자 관련 형식 지정 포맷터 사용, NumberFormatAnnotationFormatterFactory
        @NumberFormat(pattern = "###,###") // 내가 원하는 포맷 지정
        private Integer number;

        // 날짜 관련 형식 지정 포맷터 사용, Jsr310DateTimeFormatAnnotationFormatterFactory
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 내가 원하는 포맷 지정
        private LocalDateTime localDateTime; // 자바8의 날짜
    }
}

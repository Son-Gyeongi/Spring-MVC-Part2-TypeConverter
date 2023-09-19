package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 타입 컨버터 - 스프링에 Converter 적용하기
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // addFormatters() - converter의 확장된 기능
    //  컨버터 등록
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToIntegerConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        // 컨버터 추가하지 않아도 스프링이 제공하는 기본 컨버터가 있어서 타입 변환이 잘 된다.
    }
}

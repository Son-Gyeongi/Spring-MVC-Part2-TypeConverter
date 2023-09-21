package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
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
        // 스프링 타입 컨버터 - 포맷터 적용하기
        // 우선순위 때문에 아래 2개 주석처리(컨버터가 우선순위가 높다. 그러면 포맷터는 우선순위에서 밀려나 적용이 안된다.)
        // registry.addFormatter(new MyNumberFormatter())하고 아래 2개가 비슷해서 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        // 컨버터 추가하지 않아도 스프링이 제공하는 기본 컨버터가 있어서 타입 변환이 잘 된다.

        // 스프링 타입 컨버터 - 포맷터 적용하기
        // 추가 - 스프링이 기본적으로 들고 있는 컨버전 서비스에 등록이 된다.
        registry.addFormatter(new MyNumberFormatter());
    }
}

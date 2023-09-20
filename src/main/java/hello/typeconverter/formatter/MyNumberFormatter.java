package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// 포맷터 - Formatter
@Slf4j
// Formatter<String>은 기본으로 변환, String 제외한 나머지 적어주자.
// Number - Integer, Long, Float, Double 등 Number 추상클래스를 가지고 있다, Number의 자식이다.
public class MyNumberFormatter implements Formatter<Number> {

    // 문자를 객체로 변경한다.
    @Override
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text = {}, locale = {}", text, locale);
        // "1,000" -> 1000
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
    }

    // 객체를 문자로 변경한다.
    @Override
    public String print(Number object, Locale locale) {
        log.info("object = {}, locale = {}", object, locale);
        return NumberFormat.getInstance(locale).format(object);
    }
}

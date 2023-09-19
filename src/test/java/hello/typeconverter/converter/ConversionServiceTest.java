package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

// 컨버전 서비스 - ConversionService
public class ConversionServiceTest {

    @Test
    void conversionService() {
        // 등록 - 우리가 쓸 컨버터들을 컨버전 서비스에 등록
        // DefaultConversionService는 ConversionService 인터페이스를 구현한 구현체
        // 추가로 DefaultConversionService는 컨버터를 등록할 수 있다.
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        /*
        // 사용
        Integer result = conversionService.convert("10", Integer.class);// Integer.class 반환되고 싶은 타입
        System.out.println("result = " + result);

        // 검증
        assertThat(result).isEqualTo(10);
         */

        // 사용 및 검증
        // 문자 -> 숫자
        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        // 숫자 -> 문자
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        // 문자 -> IpPort 객체
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
        // IpPort 객체 -> 문자
        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}

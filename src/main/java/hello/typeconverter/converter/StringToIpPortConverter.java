package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

// 타입 컨버터 - Converter
// "127.0.0.1:8080" 문자가 들어오면 컨버터를 이용해서 IpPort 객체로 바꾸고 싶다
@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

    @Override
    public IpPort convert(String source) {
        log.info("convert source = {}", source);
        // "127.0.0.1:8080" 문자가 들어올 거다. -> IpPort 객체
        String[] split = source.split(":");
        String ip = split[0];
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip, port);
    }
}

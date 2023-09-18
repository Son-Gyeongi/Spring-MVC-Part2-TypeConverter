package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

// 타입 컨버터 - Converter
@Getter
@EqualsAndHashCode // a=b, ip/port 값만 같으면 true가 나온다.
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}

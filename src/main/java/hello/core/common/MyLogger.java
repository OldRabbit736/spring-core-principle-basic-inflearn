package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println(bracket(uuid) + bracket(requestURL) + " " + message);
    }

    private String bracket(String target) {
        return "[" + target + "]";
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println(bracket(uuid) + " " + "request scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println(bracket(uuid) + " " + "request scope bean close: " + this);
    }

}

package lazy_singleton;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */
@Component
@Lazy
public class Launcher {


    @PostConstruct
    private void init(){
        System.out.println("ракетница доставлена, с вам 100500");
    }

    public void fire() {
        System.out.println("бабах");
    }
}

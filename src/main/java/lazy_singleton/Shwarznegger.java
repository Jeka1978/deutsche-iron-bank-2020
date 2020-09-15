package lazy_singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Component
@Lazy
public class Shwarznegger {

    private int power=100;


    @Autowired
    @Lazy
    private Launcher launcher;

    @Scheduled(fixedDelay = 500)
    private void стареть(){
        System.out.println("я старею...");
//        power-=100;
    }

    public void killAll() {
        if (power < 10) {
            launchRocket();
        }
        else {
            killWithHands();
        }
    }

    private void launchRocket() {
        launcher.fire();
    }

    private void killWithHands() {
        System.out.println("Всех задушил");
        power--;
    }

}

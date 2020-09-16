package olya.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Qualifier("abc")
public class MyhImpl3 implements Myh {
}

package gs.buildingFirstMaven;

import gs.buildingFirstMaven.Greeter;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
/**
 * Created by Asus x556 on 16-May-17.
 */
public class GreeterTest {

    private Greeter greeter = new Greeter();

    @Test
    public void greeterSaysHello() {
        assertThat(greeter.sayHello(), containsString("Hello"));
    }

}

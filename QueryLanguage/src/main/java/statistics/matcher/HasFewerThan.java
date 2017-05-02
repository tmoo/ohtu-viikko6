package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;

/**
 *
 * @author tuomo
 */
public class HasFewerThan implements Matcher {

    private int value;
    private String category;

    public HasFewerThan(int value, String category) {
        this.value = value;
        this.category = category;
    }

    @Override
    public boolean matches(Player p) {
        return new Not(new HasAtLeast(value, category)).matches(p);
    }

}

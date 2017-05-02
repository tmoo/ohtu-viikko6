package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuomo
 */
public class QueryBuilder {

    private List<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList();
    }

    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }

    public Matcher build() {
        Matcher matcher = new And(matchers.toArray(new Matcher[0]));
        this.matchers.clear();
        return matcher;
    }
}

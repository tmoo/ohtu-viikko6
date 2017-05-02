package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        Matcher ma = new And(new PlaysIn("PHI"),
                new HasFewerThan(10, "goals"),
                new HasFewerThan(10, "assists"));

        Matcher me = new PlaysIn("PHI");

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("");

        for (Player player : stats.matches(ma)) {
            System.out.println(player);
        }

//        System.out.println("");
//        for (Player p : stats.matches(me)) {
//            System.out.println(p);
//        }
    }
}

package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(60, "points").build();

        Matcher m = query.oneOf(m1, m2).build();

//        Matcher m1 = query.playsIn("PHI")
//                .hasAtLeast(10, "goals")
//                .hasFewerThan(20, "assists").build();
//
//        Matcher m2 = query.playsIn("EDM")
//                .hasAtLeast(60, "points").build();
//
//        Matcher m = query.oneOf(m1, m2).build();
//        Matcher ma = new And(new HasAtLeast(10, "goals"),
//                new HasFewerThan(25, "assists"),
//                new PlaysIn("PHI")
//        );
//        Matcher m1 = query.playsIn("PHI")
//                .hasFewerThan(10, "goals").build();
////                .hasFewerThan(10, "assists").build();
//
//        Matcher m2 = query.playsIn("PHI")
//                .hasFewerThan(10, "assists").build();
//        
//        Matcher m = query.oneOf(m1, m2).build();
//        
//        Matcher ma = new And(new PlaysIn("PHI"),
//                new Or(new HasFewerThan(10, "goals"),
//                        new HasFewerThan(10, "assists")));

        Matcher me = new And(new PlaysIn("EDM"), new HasAtLeast(60, "points"));

        for (Player player : stats.matches(me)) {
            System.out.println(player);
        }

        System.out.println("");
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}

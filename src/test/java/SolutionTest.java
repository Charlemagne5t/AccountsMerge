import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SolutionTest {

    @Test
    public void test2(){
        List<List<String>> listOfLists = new ArrayList<>();

        listOfLists.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        listOfLists.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        listOfLists.add(Arrays.asList("Mary","mary@mail.com"));
        listOfLists.add(Arrays.asList("John","johnnybravo@mail.com"));

        List<List<String>> expected = Arrays.asList(
                Arrays.asList("John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"),
                Arrays.asList("Mary","mary@mail.com"),
                Arrays.asList("John","johnnybravo@mail.com")
        );

        List<List<String>> actual = new Solution().accountsMerge(listOfLists);
        Collections.sort(actual, Comparator.comparing(l -> l.get(0)));
        Collections.sort(expected, Comparator.comparing(l -> l.get(0)));
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        List<List<String>> listOfLists = new ArrayList<>();

        listOfLists.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"));
        listOfLists.add(Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"));
        listOfLists.add(Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"));
        listOfLists.add(Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"));
        listOfLists.add(Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"));

        List<List<String>> expected = Arrays.asList(
                Arrays.asList("Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"),
                Arrays.asList("Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"),
                Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"),
                Arrays.asList("Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"),
                Arrays.asList("Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co")
        );

        List<List<String>> actual = new Solution().accountsMerge(listOfLists);
        Collections.sort(actual, Comparator.comparing(l -> l.get(0)));
        Collections.sort(expected, Comparator.comparing(l -> l.get(0)));
        Assert.assertEquals(expected, actual);
    }

}

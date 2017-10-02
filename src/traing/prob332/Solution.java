package traing.prob332;

import utils.DataGenerator;

import java.util.*;

/**
 * Reconstruct Itinerary
 * Link: https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * I first try to solve this problem by using PriorityQueue + backtrack. But I got some problems.
 * 1. The priority queue doesn't play well with backtrack. Because all you can do with priority queue is get the priorities one, you can't get second and third without dumping any data.
 * So if I decide to use backtrack, I should use array instead of priority queue.
 * 2. I thought this problem is a topological sort problem, but it's a Eulerian path problem.
 *
 * A DFS + Priority queue(helpful for the sort thing) should do the job.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/2/17
 */
public class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) map.computeIfAbsent(ticket[0], key -> new PriorityQueue<>()).offer(ticket[1]);
        dfs("JFK");
        return res;
    }

    private void dfs(String departure) {
        while (map.containsKey(departure) && !map.get(departure).isEmpty()) dfs(map.get(departure).poll());
        res.add(0, departure);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.findItinerary(DataGenerator.createStringBoard("MUC,LHR|JFK,MUC|SFO,SJC|LHR,SFO")));
//        System.out.println(s.findItinerary(DataGenerator.createStringBoard("JFK,SFO|JFK,ATL|SFO,ATL|ATL,JFK|ATL,SFO")));
//        System.out.println(s.findItinerary(DataGenerator.createStringBoard("JFK,SFO")));
        System.out.println(s.findItinerary(DataGenerator.createStringBoard("JFK,KUL|JFK,NRT|NRT,JFK")));
    }
}

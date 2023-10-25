import java.util.*;

public class Main {
    public static void main(String[] args) {
        String beef = "beef";
        String beeef = "beeef";
        System.out.println(beef.compareTo(beeef));



    }
}


class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1); // get either an existing value of word or if doesn't exist then get 0. then +1 for new occurence
        }
        PriorityQueue<String> h = new PriorityQueue<>(
                (w1, w2) -> cnt.get(w1).equals(cnt.get(w2)) ? w2.compareTo(w1) : cnt.get(w1) - cnt.get(w2));
        // are word 1 and word two of equivalent map vals? if yes, compare the words for lexicographic ordering. If no, sort in ascending frequency
        // compareTo is a string class method that sorts items lexicographically
        // tried to expand this statement into an if statement, but appears we can't define a priorityQueue sort like that. has to be just lambda

        for (String word : cnt.keySet()) {
            h.offer(word); // add all words
            if (h.size() > k) // knock off least frequent from head
                h.poll();
        }

        List<String> res = new ArrayList<>();
        while (!h.isEmpty())
            res.add(h.poll());  // add all remaining strings
        Collections.reverse(res); // reverse so most frequent at head
        return res;
    }
}
//
//
//
//// attempt
//class Solution {
//    public List<String> topKFrequent(String[] words, int k) {
//        PriorityQueue<String> pq = new PriorityQueue<>();
//        for(String word: words){
//            pq.add(word);
//        }
//        List<String> ans = new ArrayList<>();
//        while(k > 0){
//            ans.add(pq.poll());
//        }
//        return ans;
//    }
//}
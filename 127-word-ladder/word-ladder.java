// Data Structure that is used
class Pair {
    String first;
    int second;
    
    Pair(String word, int step) {
        this.first = word;
        this.second = step;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Preliminary Steps
        // Make set for easy lookup
        Set<String> set = new HashSet<String>(wordList);
        if (!set.contains(endWord)) return 0;
        // Bfs will be used
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.first;
            int step = current.second;
            
            // Base Case
            if (word.equals(endWord)) return step;

            for (int i = 0; i < word.length(); i++) {
                char[] replacedWordArray = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    replacedWordArray[i] = ch;
                    String replacedWordString = new String(replacedWordArray);
                    // If contains remove from the set and add queue with step ++
                    if (set.contains(replacedWordString)) {
                        set.remove(replacedWordString);
                        queue.add(new Pair(replacedWordString, step + 1));
                    }
                }
            }
        }
        // If not found return 0
        return 0;
    }
}


class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count frequency of each task
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        // Step 2: Max-heap to always pick the task with highest remaining count
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int f : freq) if (f > 0) pq.add(f);

        int time = 0;

        // Step 3: Simulate execution in cycles of size n + 1
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1); // execute task
                }
            }

            // Step 4: Put remaining tasks back into the heap
            for (int t : temp) {
                if (t > 0) pq.add(t);
            }

            // Step 5: Add time: full cycle or just tasks left
            time += pq.isEmpty() ? temp.size() : cycle;
        }

        return time;
    }
}

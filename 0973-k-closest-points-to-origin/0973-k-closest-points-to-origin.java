

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max-heap: largest distance on top
        PriorityQueue<Pair<List<Integer>, Double>> pq =
            new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt(x*x + y*y);

            if (pq.size() == k) {
                Pair<List<Integer>, Double> max = pq.peek();
                if (max != null && distance < max.getValue()) {
                    pq.poll(); // remove farthest
                    pq.add(new Pair<>(List.of(x, y), distance));
                }
            } else {
                pq.add(new Pair<>(List.of(x, y), distance));
            }
        }

        // Convert PriorityQueue to int[][]
        int[][] result = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair<List<Integer>, Double> pair = pq.poll();
            List<Integer> list = pair.getKey();
            result[i][0] = list.get(0);
            result[i][1] = list.get(1);
            i++;
        }

        return result;
    }
}

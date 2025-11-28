class KthLargest {
    private PriorityQueue<Integer> minHeap;  // Notre min-heap
    private int k;    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(); // Min-heap par défaut
        
        // Ajouter tous les éléments initiaux
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {

        if(minHeap.size()<k){
            minHeap.add(val);
        }else if(minHeap.size()==k){
            if((int)minHeap.peek()<val){
                minHeap.poll();
                minHeap.add(val);
            }
        }
        return minHeap.peek(); 
    }
}

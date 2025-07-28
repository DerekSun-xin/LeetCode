class Solution {
    private int[] representative; 

    private int find(int i){
        if (representative[i] == i){
            return i; 
        }
        return find(representative[i]); 
    }
    
    private void union(int i, int j){
        int irep = find(i);
        int jrep = find(j);
        representative[jrep] = irep; 
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length + 1;
        representative = new int[N]; 
        for (int i = 1; i < N; i++) {
            representative[i] = i;
        }

        for (int[] edge: edges){
            if (find(edge[0]) == find(edge[1])) {
                return new int[] {edge[0], edge[1]}; 
            }
            union(edge[0], edge[1]); 
        }
        return new int[] {}; 
    }
}
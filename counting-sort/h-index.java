class Solution {
    public int hIndex(int[] citations) {
        int h_index = 0;
        // We can sort in ascending order and check from the end
        Arrays.sort(citations); 

        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]>citations.length-1-i){
                h_index++;
            }
        }
        return h_index;
    }
}
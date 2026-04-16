class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int n = gas.length;
       int total_gas = 0;
       int total_cost = 0;

       for(int i = 0; i < n; i++){
        total_gas += gas[i];
        total_cost += cost[i];
       } 

       if(total_gas < total_cost){
        return -1;
       }

       int startidx = 0;
       int currentgas = 0;
       
       for(int i = 0; i < n; i++){
        currentgas += gas[i] - cost[i];
        if(currentgas < 0){
            startidx = i + 1; 
            currentgas = 0;  
        }
       } 

       return startidx;
    }
}
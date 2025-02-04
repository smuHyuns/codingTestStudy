import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> uniquePokemons = new HashSet<>();
        
        for (int num : nums) {
            uniquePokemons.add(num); 
        }

        int maxSelectable = nums.length / 2; 
        int uniqueCount = uniquePokemons.size(); 

        return Math.min(maxSelectable, uniqueCount);
    }
}

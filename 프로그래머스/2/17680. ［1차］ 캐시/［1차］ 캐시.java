import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> cache = new ArrayDeque<>();
        int runTime = 0;
        
        if(cities.length == 0) return 0;
        if(cacheSize == 0) return 5 * cities.length;
        for(String city : cities){
          city = city.toLowerCase();
          if(cache.contains(city)){           
            runTime ++;
            //앞으로 당겨주는 작업
            cache.remove(city);
            cache.offerFirst(city);
          } else {
              //캐시사이즈 꽉찬경우
              if(cache.size() == cacheSize){
                  cache.pollLast();
              } 
              cache.offerFirst(city);
              runTime += 5;
            
          }
        }
        
        
        return runTime;
    }
}
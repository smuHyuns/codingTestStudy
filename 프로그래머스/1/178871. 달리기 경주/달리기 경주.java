import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> list = new ArrayList<>(Arrays.asList(players));

        Map<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }
        
        for (String call : callings) {
            int currentIndex = playerIndexMap.get(call);
            if (currentIndex > 0) {
                String previousPlayer = list.get(currentIndex - 1);
                list.set(currentIndex - 1, call);
                list.set(currentIndex, previousPlayer);
                
                playerIndexMap.put(call, currentIndex - 1);
                playerIndexMap.put(previousPlayer, currentIndex);
            }
        }
        
        return list.toArray(new String[0]);
    }
}

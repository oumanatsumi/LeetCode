package Q1797;

import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {
    Map<String, Integer> users = new HashMap<>();
    int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        users.put(tokenId, currentTime+timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(users.containsKey(tokenId) && users.get(tokenId) > currentTime){
            users.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for(String tokenID: users.keySet()){
            if(users.get(tokenID) > currentTime) cnt++;
        }
        return cnt;
    }
}

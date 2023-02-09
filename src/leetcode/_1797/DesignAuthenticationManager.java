package leetcode._1797;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DesignAuthenticationManager {

}

class AuthenticationManager {

    Map<String, Integer> tokens;
    int ttl;

    public AuthenticationManager(int timeToLive) {
        tokens = new HashMap<>();
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (!tokens.containsKey(tokenId)) return;
        int ex = tokens.get(tokenId);
        if (ex <= currentTime)
            tokens.remove(tokenId);
        else
            tokens.put(tokenId, currentTime + ttl);

    }

    public int countUnexpiredTokens(int currentTime) {
//        int count = 0;
//        for (Integer t : tokens.values()) {
//            if (t > currentTime) {
//                count++;
//            }
//        }

        Iterator<Map.Entry<String, Integer>> it = tokens.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getValue() <= currentTime) it.remove();
        }
        return tokens.size();
    }
}

class AuthenticationManager1 {

    Map<String, Integer> tokens;
    int ttl;
    int N = 2010;
    String[] ids = new String[N];
    int[] exs = new int[N];
    int idx = 0;
    int start = 0;

    public AuthenticationManager1(int timeToLive) {
        tokens = new HashMap<>();
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + ttl);
        ids[idx] = tokenId;
        exs[idx++] = currentTime + ttl;
    }

    public void renew(String tokenId, int currentTime) {
        if (!tokens.containsKey(tokenId)) return;
        int ex = tokens.get(tokenId);
        if (ex > currentTime) {
            tokens.put(tokenId, currentTime + ttl);
            ids[idx] = tokenId;
            exs[idx++] = currentTime + ttl;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        // System.out.println("count: " + start + ", " + idx + ", " + currentTime + ", " + tokens);
        int i = start;
        for (; i < idx; i++) {
            String tokenId = ids[i];
            int ex = exs[i];
            if (ex > currentTime) break;
            // System.out.println(i + ": " + ex + ": " + tokenId);
            if (tokens.containsKey(tokenId) && tokens.get(tokenId) <= currentTime) {
                tokens.remove(tokenId);
            }
        }
        start = i;
        return tokens.size();
    }
}
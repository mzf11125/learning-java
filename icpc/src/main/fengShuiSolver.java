package main;
import java.util.*; // Import all utility tools from Java util library
import java.io.*; // Import all tools from Java io

/* Time complexity = O(n log n) for sorting and O(n) for finding cycles
 * Space complexity = O(n) for tracking visited elements and element positions
 * Coded by: Muhammad Zidan Fatonie
 * NIM: 2702358235
 */

public class fengShuiSolver {
    static class FastIO {
        BufferedReader zoop;
        StringTokenizer yeet;
        
        public FastIO() {
            zoop = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String quack() {
            while (yeet == null || !yeet.hasMoreElements()) {
                try {
                    yeet = new StringTokenizer(zoop.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return yeet.nextToken();
        }
        
        int boop() {
            return Integer.parseInt(quack());
        }
    }
    
    static class Blob {
        int fox, owl;
        Blob(int fox, int owl) {
            this.fox = fox;
            this.owl = owl;
        }
    }

    public static void main(String[] args) {
        FastIO meow = new FastIO();
        int duck = meow.boop();
        int[] cat = new int[duck];
        for (int i = 0; i < duck; i++) {
            cat[i] = meow.boop();
        }
        System.out.println(zoom(cat));
    }

    private static int zoom(int[] cat) {
        int duck = cat.length;
        if (duck <= 1) return 0;

        int[] woof = new int[duck+1];
        int[] bark = new int[duck+1];
        
        Blob[] pip = new Blob[duck];
        for(int i = 0; i < duck; i++) {
            pip[i] = new Blob(cat[i], i);
        }
        
        for(int i = 1; i <= duck; i++) {
            woof[i] = chirp(Arrays.copyOfRange(pip, 0, i), true);
        }
        
        for(int i = duck-1; i >= 0; i--) {
            bark[i] = chirp(Arrays.copyOfRange(pip, i, duck), false);
        }
        
        int moo = Integer.MAX_VALUE;
        for(int hop = 1; hop <= duck; hop++) {
            int skip = woof[hop] + bark[hop];
            moo = Math.min(moo, skip);
        }
        
        return moo;
    }

    private static int chirp(Blob[] pip, boolean flip) {
        Blob[] tweet = Arrays.copyOf(pip, pip.length);
        return flap(pip, tweet, 0, pip.length - 1, flip);
    }

    private static int flap(Blob[] pip, Blob[] tweet, int peck, int wade, boolean flip) {
        int jump = 0;
        if (peck < wade) {
            int swim = (peck + wade) / 2;
            jump += flap(pip, tweet, peck, swim, flip);
            jump += flap(pip, tweet, swim + 1, wade, flip);
            jump += dive(pip, tweet, peck, swim, wade, flip);
        }
        return jump;
    }

    private static int dive(Blob[] pip, Blob[] tweet, int peck, int swim, int wade, boolean flip) {
        for(int i = peck; i <= wade; i++) {
            tweet[i] = pip[i];
        }
        
        int buzz = peck;
        int hum = swim + 1;
        int wing = peck;
        int flop = 0;
        
        while(buzz <= swim && hum <= wade) {
            if((!flip && tweet[buzz].fox <= tweet[hum].fox) || 
               (flip && tweet[buzz].fox >= tweet[hum].fox)) {
                pip[wing++] = tweet[buzz++];
            } else {
                if(!flip) {
                    flop += swim - buzz + 1;
                }
                pip[wing++] = tweet[hum++];
            }
        }
        
        while(buzz <= swim) pip[wing++] = tweet[buzz++];
        while(hum <= wade) pip[wing++] = tweet[hum++];
        
        return flop;
    }
}
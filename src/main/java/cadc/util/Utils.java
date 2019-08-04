package cadc.util;

import java.util.Random;

/**
 * @author haya
 */
public class Utils {
    public static int[] random(int range,int size) {
        int[] res = new int[size];
        boolean[] flag = new boolean[range + 1];
        int t;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            do {
                t = random.nextInt( range ) + 1;
            } while (flag[t]);
            res[i] = t;
            flag[t] = true;
        }
        return res;
    }
}

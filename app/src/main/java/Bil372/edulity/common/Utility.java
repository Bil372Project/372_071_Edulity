package Bil372.edulity.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Common utility functions for this project
 */
public class Utility {

    static List<Integer> generatedIds = new ArrayList<>();

    public static int randomIdGenerator() {
        while(true) {
            int rand = (int)((Math.random() * 100000) + 1); // generates random number between 1 and 100000
            if(!generatedIds.contains(rand)){
                generatedIds.add(rand);
                return rand;
            }
        }
    }
}

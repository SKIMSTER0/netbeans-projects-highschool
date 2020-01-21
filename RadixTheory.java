/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radixtheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Default
 */
public class RadixTheory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    //PRIME RADIXES UNABLE TO DETECT PRIME DIGITS, WHAT ARE BEST RADIXES TO USE?
        
//        Set<String> set = new HashSet<String>();
//        for (int g = 30; g <= 30; g++) {
//            for (int c = g; c < 1000; c++) {
//                if (primeCheck(c)) {
//                    Integer num = new Integer(c);
//                    Character based = num.toString(c, g).charAt(num.toString(c, g).length() - 1);
//                    set.add(based.toString());
//                    System.out.println(based.toString());
//                }
//            }
//            double primePercentage = 100-((double)set.size()/g)*100;
//            System.out.println("BASE"+g+":"+Arrays.toString(set.toArray())+" PERCENTAGE: "+primePercentage);
//            set.clear();
//        }

        
        Set<Integer> Set = new HashSet<Integer>();
        
        for(int i=2;i<100;i++){
            for(int p=2;p<1000;p++){
                if(primeCheck(p) && p>i){
                    Set.add(p%i);
                }
            }
            //System.out.println("MODULO "+i+":"+Arrays.toString(Set.toArray()));
            System.out.println("SIEVE EFFICIENCY OF MODULO "+i+": "+(100-((double)Set.size()/i)*100)+"%");
            Set.clear();
        }
    }

    public static boolean primeCheck(long n) {
    if (n <= 3) {
        return n > 1;
    } else if (n % 2 == 0 || n % 3 == 0) {
        return false;
    } else {
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

}

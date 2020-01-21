
package cryptohash;

import java.util.ArrayList;
public class CryptoHash {
    
    public static void main(String[] args) {
//        charHash charHash=new charHash();
//        System.out.println(charHash.convertChar("hello FATHER"));
//        System.out.println(charHash.deconvertChar("10410110810811132706584726982"));

//        int[] ex1={16,20,19,22,13,15,25,4,10};
//        int[] mod={5};
//        modulo modTest=new modulo(ex1,mod);
//        System.out.println(modTest.calcPrimRoot(8));
        
//        passHash passHash=new passHash("password123");
//        System.out.println(passHash.getPassword());
//        System.out.println(passHash.getModulos());
        
//        ArrayList bla=new ArrayList();
//        bla.add(2);
//        bla.add(5);
//        bla.add(20);
//        bla.add(50);
//        bla.add(1117);
//        prime prime=new prime();
//        System.out.println(prime.calcRand(50,100));
        prime prime=new prime();
        
//        for(int g=2;g<100;g++){
//            System.out.println(g+" :"+prime.factorize(g));
//        }
        for(int h=2;h<1000;h++){
            if(prime.test(h))
        }
        
        

    }
}



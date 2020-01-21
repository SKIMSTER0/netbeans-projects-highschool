
package cryptohash;

import java.util.ArrayList;
import java.util.Random;

public class prime{
    private final ArrayList primeRange=new ArrayList();
    private final ArrayList primeFactors=new ArrayList();
    private int i,b;
    private int randPrime;

    private ArrayList calcRange(int min,int max){
        for(b=min;b<=max;b++){
            if(test(b))primeRange.add(b);
        }
        return primeRange;
    }
    public ArrayList getRange(int min,int max){
        return calcRange(min,max);
    }
    private boolean calcTest(int num){
        if(num%2==0)return(false);
        for(i=3;i*i<=num;i+=2){
            if(num%i==0)return(false);
        }
        return(true);
    }
    public boolean test(int num){
        return calcTest(num);
    }
    private ArrayList calcKeepPrime(ArrayList primeList){
        for(i=0;i<primeList.size();i++){
            if(test((int)primeList.get(i))==false){
                primeList.remove(i);
                i-=1;
            }
        }
        return primeList;
    }
    public ArrayList keepPrime(ArrayList primeList){
        return calcKeepPrime(primeList);
    }
    private int calcRand(int min,int max){
        Random rand=new Random();
        randPrime=rand.nextInt((getRange(min,max)).size());
        return((int)primeRange.get(randPrime));
    }
    public int getRand(int min,int max){
        return(calcRand(min,max));
    }
    private ArrayList calcFactorize(int num){   ///OPTIMIZE THROUGH CALCRANGE
        for(i=2;i<=num;i++){
            if(num%i==0){
                primeFactors.add(i);
                num/=i;
                i--;
            }
        }
        return primeFactors;
    }
    public ArrayList factorize(int num){
        primeFactors.clear();
        return calcFactorize(num);
    }    
}
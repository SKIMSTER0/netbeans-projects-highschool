
package cryptohash;

import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.Collections;

public class modulo{       ///tests modulos with info data
    private ArrayList results=new ArrayList();
    private ArrayList testRoots=new ArrayList();
    private ArrayList firstRoots=new ArrayList();
    private int primitiveRoot;
    private boolean isPrimeRoot=false;
    private int[] testData;
    private int[] modulos;
    private int i,b;
    
    public modulo(int[] testData,int[] modulos){
        this.testData=testData;
        this.modulos=modulos;
    }
    public void testModulos(){
        for(i=0;i<testData.length;i++){
            for(b=0;b<modulos.length;b++){
                results.add(testData[i]%modulos[b]);
                System.out.println(testData[i]+"%"+modulos[b]+"="+results.get(i));
            }
        }
    }
    public void getExample(){
        for(i=0;i<testData.length;i++)System.out.println(testData[i]);
    }
    public void getModulos(){
        for(i=0;i<modulos.length;i++)System.out.println(modulos[i]);
    }
    public int calcPrimRoot(int modulus) {  ///NEEDS MASSIVE OPTIMIZATION
        for(b=2;!isPrimeRoot;b++){
            isPrimeRoot=true;
            for (i=1;i<modulus;i++) {
                if(b==2)firstRoots.add((pow(b,i)%modulus));
                testRoots.add(pow(b,i)%modulus);
            }
            Collections.sort(testRoots);
            for(i=0;i<testRoots.size()-1;i++){
                if((double)testRoots.get(i)+1!=(double)testRoots.get(i+1)){
                    isPrimeRoot=false;
                    break;
                }
            }
            
            System.out.println(testRoots);
            if(!isPrimeRoot)testRoots.clear();
            else{primitiveRoot=b;}
        }
        return primitiveRoot;
    }
}

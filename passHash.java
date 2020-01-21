
package cryptohash;

import java.util.ArrayList;

public class passHash{      ///medium-strength password encryption
    public String password;
    private String passcode="";
    private int i;
    prime prime=new prime();
    private int passModulo;
    private ArrayList passModuloList=new ArrayList();
    
    public passHash(String password){
        this.password=password;
    }
    private int passModulos(){
        passModulo=prime.getRand(100000,200000);
        passModuloList.add(passModulo);
        return((int)passModuloList.get(passModuloList.size()-1));
    }
    public ArrayList getModulos(){
        return(passModuloList);
    }
    private String passEncrypt(){
        for(i=0;i<password.length();i++){
            int temp=passModulos();
            passcode+=(temp%((int)password.charAt(i)));
            System.out.println("The modulo: "+temp);
            System.out.println("The number: "+((int)password.charAt(i)));
            System.out.println("The result: "+temp%(int)password.charAt(i));
            System.out.println("Is this prime: "+prime.test((temp%(int)password.charAt(i))));
        }
        System.out.println("This code is "+passcode.length()+" digits long");
        return passcode;
    }
    public String getPassword(){
        return passEncrypt();
    }
}

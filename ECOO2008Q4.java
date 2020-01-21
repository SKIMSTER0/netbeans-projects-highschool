
package ecoo.pkg2008.q4;

import java.util.Scanner;

public class ECOO2008Q4 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String sentence=input.nextLine();
        
        System.out.println(encodeShift(sentence));
    }
    public static String encodeShift(String sentence){
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String encoded="";
        int wordLength;
        
        sentence=sentence.toUpperCase();
        for(int i=0;i<sentence.length();i++){
            for(int b=0;b<alphabet.length();b++){
                if(sentence.charAt(i)==alphabet.charAt(b)){
                    if(b+shiftValue>=alphabet.length()){
                        encoded+=alphabet.charAt((b+shiftValue)-alphabet.length());
                    }else encoded+=alphabet.charAt(b+shiftValue);
                }
            }
        }
        return encoded;
    }
    
}

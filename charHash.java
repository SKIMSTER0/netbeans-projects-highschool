
package cryptohash;

public class charHash{     ///weak limited ASCII encryption
    private String word;
    private String wordCode="";
    private String decoded="";
    private int i;
    
    private String encryptChar(String word){
        wordCode="";
        for(i=0;i<word.length();i++){
            wordCode+=(int)word.charAt(i);
        }
        return wordCode;
    }
    public String convertChar(String word){
        return encryptChar(word);
    }
    private String decryptChar(String code){
        decoded="";
        for(i=0;i<code.length();i++){
            if(code.charAt(i)=='1'){        ///does not work if 1-2 digit 1's
                decoded+=((char)Integer.parseInt(code.substring(i,i+3)));
                i+=2;
            }else{
                decoded+=((char)Integer.parseInt(code.substring(i,i+2)));
                i+=1;
            }
        }
        return(decoded);
    }
    public String deconvertChar(String code){
        return decryptChar(code);
    }
}

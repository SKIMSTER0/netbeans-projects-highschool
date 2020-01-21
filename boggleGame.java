

package boggle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class boggleGame {
    public int height,width,letterPos;
    public String word;
    public char[][] pseudoBoard;
    
    public boggleGame(){
        height=0;
        width=0;
        letterPos=0;
    }
    public boggleGame(String word,int height,int width){ ///overloading constructor
        this.word=word;
        this.height=height;
        this.width=width;
    }
    public void showBoard(char[][] boggleBoard) throws FileNotFoundException{
        for(int i=0;i<height;i++){
            for(int b=0;b<width;b++){
                System.out.print(boggleBoard[i][b]+" ");
            }
            System.out.println();
        }
    }
    public char[][] getBoggle() throws FileNotFoundException, IOException{
        //Fills boggleBoard array with file board
        Scanner input=new Scanner (new File("boggleboard.txt"));
        this.height=input.nextInt();
        this.width=input.nextInt();
        input.close();
        
        BufferedReader br=new BufferedReader(new FileReader("boggleboard.txt"));
        char[][] boggleBoard=new char[width][height];
        
        for(int c=0;c<height;c++){
            boggleBoard[c]=br.readLine().toCharArray();           
        }
        
        pseudoBoard=boggleBoard;
        return boggleBoard;
    }
    public int findWord(char[][] boggleBoard,int posX,int posY) throws FileNotFoundException{
        if(posX<0 || posY<0 || posX>=height || posY>=width){    ///boundaries
            return 0;
        }else if(boggleBoard[posX][posY]=='.')return 0;     ///if letter already taken
        if(letterPos==word.length())return 0;   //if word already found

        System.out.println(boggleBoard[posX][posY]);
        
        if(boggleBoard[posX][posY]==word.charAt(letterPos)){    //if letter found
            letterPos++;
            boggleBoard[posX][posY]='.';    ///destructive algorithm process
            
            return(findWord(boggleBoard,posX+1,posY)    +   ///finds letters around 8 tiles
            findWord(boggleBoard,posX,posY+1)           +
            findWord(boggleBoard,posX+1,posY+1)         +
            findWord(boggleBoard,posX-1,posY)           +
            findWord(boggleBoard,posX,posY-1)           +
            findWord(boggleBoard,posX-1,posY-1)         +
            findWord(boggleBoard,posX+1,posY-1)         +
            findWord(boggleBoard,posX-1,posY+1));
        }
        return 0;
    }
    public char[][] refreshBoard(){
        return pseudoBoard;
    }
    public static boolean testWord(String word) throws FileNotFoundException{
        Scanner input = new Scanner(new File("wordlist.txt"));
        boolean isWord=false;
        
        while(input.hasNextLine()){
            if(input.nextLine().equals(word))isWord=true;
            if(isWord)break;
        }
        return isWord;
    }
}



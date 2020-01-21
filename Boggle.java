package boggle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Boggle {
    
    public static char[][] boggle;
    public static char[][] pseudoBoard;
    public static ArrayList<String> temp=new ArrayList();
    public static int letterPos;
    public static String boggleWord;
    
    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        ArrayList<String> wordList = sortList();
        String word="";
        boolean foundWord;
        boggle=generateBoggle(5,5); //generates boggleboard baesed on given height-width paramenter
        
        while(!word.equals("999")){
            showBoard(boggle);
            
            System.out.println("Input word");
            word=input.next();
            
            boggleWord=word.toLowerCase();
            letterPos=0;
            foundWord=false;
            
            if(!binSearch(wordList,boggleWord))System.out.println("This word is not a legit word");
         else{
            for(int i=0;i<boggle.length;i++){
                    for (int b = 0; b < boggle[0].length; b++) {
                        if (boggle[i][b] == boggleWord.charAt(0)) {
                            findWord(i, b);
                            if (letterPos == boggleWord.length()) {
                                foundWord=true;
                            }
                            letterPos=0;
                            refreshBoard(boggle);
                        }
                    }
                }
                
            if(foundWord){
                System.out.println("This word is found in the boggle board");
            }
            else System.out.println("This word is not in the boggle board");
            
            }
        }
        
    }
    
    public static ArrayList<String> sortList() throws FileNotFoundException{
        Scanner dictionary=new Scanner(new BufferedReader(new FileReader("dictionary.txt")));
        ArrayList<String> wordList=new ArrayList();
        
        while(dictionary.hasNextLine()){
            wordList.add(dictionary.nextLine());
        }
        
        for(int i=0;i<wordList.size();i++){
            temp.add(wordList.get(i));
        }
        
        mergeSort(wordList,0,wordList.size()-1);
        
        return wordList;
    }
    
    public static void showBoard(char[][] boggle){
        for(int i=0;i<boggle.length;i++){
            for(int b=0;b<boggle[0].length;b++){
                System.out.print(boggle[i][b]+" ");
            }
            System.out.println();
        }
    }
    
    public static void refreshBoard(char[][] boggle){
        for(int i=0;i<boggle.length;i++){
            for(int b=0;b<boggle[0].length;b++){
                boggle[i][b]=pseudoBoard[i][b];
            }
            System.out.println();
        }
    }
    
    public static char[][] generateBoggle(int height,int width){
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand= new Random();
        
        char[][] boggle = new char [height][width];
        pseudoBoard=new char[height][width];
        
        for(int i=0;i<height;i++){
            for(int g=0;g<width;g++){
                boggle[i][g]=alphabet.charAt(rand.nextInt(alphabet.length()));
                pseudoBoard[i][g]=boggle[i][g];
            }
        }
        
        return boggle;
    }
    
    public static int findWord(int posX,int posY) throws FileNotFoundException{
        if(posX<0 || posY<0 || posX>=boggle.length || posY>=boggle[0].length){    ///boundaries
            return 0;
        }else if(boggle[posX][posY]=='.')return 0;     ///if letter already taken
        if(letterPos==boggleWord.length())return 0;   //if word already found

//        System.out.println(boggle[posX][posY]);
        
        if(boggle[posX][posY]==boggleWord.charAt(letterPos)){    //if letter found
            letterPos++;
            boggle[posX][posY]='.';    ///destructive algorithm process
            
            return(findWord(posX+1,posY)    +   ///finds letters around 8 tiles
            findWord(posX,posY+1)           +
            findWord(posX+1,posY+1)         +
            findWord(posX-1,posY)           +
            findWord(posX,posY-1)           +
            findWord(posX-1,posY-1)         +
            findWord(posX+1,posY-1)         +
            findWord(posX-1,posY+1));
        }
        return 0;
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
    
    public static boolean binSearch(ArrayList<String> wordList, String word){       //BINARY SORT
        int low=0;
        int middle;
        int high=wordList.size()-1;
        
        while(high>=low){
            middle=(low+high)/2;
            if(wordList.get(middle).equals(word))return true;
            else if(wordList.get(middle).compareToIgnoreCase(word)<0)low=middle+1;
            else high=middle-1;
        }
        return false;
    }
    
    public static ArrayList<String> mergeSort(ArrayList<String> list, int start, int end) {     //MERGE SORT *(NOT WORKING)
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(list, start, mid);
            mergeSort(list, mid + 1, end);
            merge(list, start, mid, end);
        }
        return list;
    }

    private static void merge(ArrayList<String> list, int start, int mid, int end) {
        int pos1 = start;
        int pos2 = mid + 1;
        int spot = start;

        while (!(pos1 > mid && pos2 > end)) {
            if ((pos1 > mid) || ((pos2 <= end) && (list.get(pos2).compareTo(list.get(pos1))<0))) {
                temp.set(spot,list.get(pos2));
                pos2++;
            } else {
                temp.set(spot,list.get(pos1));
                pos1++;
            }
            spot++;
        }
        for (int i = start; i <= end; i++) {
            list.set(i,temp.get(i));
        }
    }
    
}
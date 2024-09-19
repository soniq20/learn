import java.io.*;
import java.util.*;
import java.util.Scanner;

public class IsogramClass {

    static boolean is_isogram(String str){
        str = str.toLowerCase();
        int len = str.length();
        char arr[] = str.toCharArray();
        Arrays.sort(arr);

        for(int i=0; i<len-1; i++){
            if(arr[i]==arr[i+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        String str1 = "Machine";
        System.out.println(is_isogram(str1));
        System.out.println("please enter the word you want to check: ");
        Scanner scan = new Scanner(System.in);
        String str2 = scan.nextLine();
        System.out.println(is_isogram(str2));
    }
}

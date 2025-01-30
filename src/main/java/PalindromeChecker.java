import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String word)
{
  word = onlyLetters(word);
  String r = reverse(word);
  return r.equals(word);
}
public String reverse(String str)
{
    String reverseString = new String();
    for(int i = str.length()-1; i >= 0; i--){
      reverseString += str.charAt(i);
    }
    return reverseString;
}
  public String onlyLetters(String sString){
  StringBuilder letters = new StringBuilder();
   for (int i = 0; i < sString.length(); i++) {
  if (Character.isLetter(sString.charAt(i))) {
    letters.append(sString.charAt(i)); 
      }
    }
  return letters.toString().toLowerCase();
  }
}

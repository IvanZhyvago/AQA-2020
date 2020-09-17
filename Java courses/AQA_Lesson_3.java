import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;

public class AQA_Lesson_3 {

    public static String createNewString (String stringToChange){
        String converteString = "";
        if (stringToChange.equals("")){
            return "";
        }
        else if (stringToChange.length()<2){
            return stringToChange.substring(0);
        }
        else {
            return stringToChange.substring(0,2);
        }
    }
    public static String builtHTML (String html){
        StringBuffer sb = new StringBuffer(40);
        return sb.append("<p>").append(html).append("</p>").toString();
    }
    public static boolean startCheck (String taskFour){
        return taskFour.startsWith("The");
    }
    public static String setLowerCase (String upperCase){
        String result = upperCase.replaceAll("[AEIOUY]","");
        return result.toLowerCase();
    }
    public static String shortLongshort (String strOne, String strTwo){
        StringBuffer sb = new StringBuffer(40);
        if(strOne.length()==strTwo.length()){
            System.out.println("Strings are the same lenght !!!");
            return sb.append(strOne).append(strTwo).append(strOne).toString();
        }
        else if  (strOne.length()<strTwo.length()){
            return sb.append(strOne).append(strTwo).append(strOne).toString();
        }
        else{
            return sb.append(strTwo).append(strOne).append(strTwo).toString();
        }
    }
    public static String pullOutTheName (String email){
        String name =  email.substring(0,email.indexOf("_"));
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        String surname = email.substring(email.indexOf("_")+1,email.indexOf("@"));
        surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
       return name+" "+surname;
    }
    public static void sortNames(String names){
        String [] result;
        result = names.split(", ");
        for (String c : result){
            System.out.println(c);
        }

    }
    public static String verifyEnds (String str){
        if (str.endsWith(".")){
            return str;
        }
        else {
            StringBuilder result = new StringBuilder();
            return result.append(str).append(".").toString();
        }
    }

    private static ArrayList<Character> transformIntToChar(int... values) {
        ArrayList<Character> buffer = new ArrayList<>();
        for (int i: values) {
            buffer.add(((char) i));
        }
        return buffer;
    }
    private static void printList(ArrayList<Character> characters) {
        for (char c: characters) {
            System.out.print(c);
        }
    }




    public static void main (String [] args) {
// 1. Given string firstName = "Den" and lastName = "Brown".
// Print to the console the full name in the following format: "FirstName LastName"
        System.out.println("Home Task #3 part #1:");
        String firstName = "Den";
        String lastName = "Brown";
        System.out.println(firstName+' '+lastName);

//2. Given a string. Write a code that will creates a new string made of its first two chars of the initial string,
// so the String "Hello" yields "He".
//If the string is shorter than length 2, return whatever there is, so "X" yields "X",
// and the empty string "" yields the empty string "".
        System.out.println("Home Task #3 part #2:");

        System.out.println("If string empty print ---> " + createNewString(""));
        System.out.println("If string shorter than length 2 print ---> " + createNewString("J"));
        System.out.println("Made of its first two chars of the initial string print ---> " + createNewString("NBA"));

//3. The web is built with HTML strings like "<i>Hello</i>" which draws Hello as italic text.
//   In this example, the "i" tag makes <i> and </i> which surround the word "Hello".
//   Given tag and word strings, create the HTML string with tags around the word, e.g. "<i>Hello</i>".
//
//   Task: word = "Welcome to Java World", tag="p"
        System.out.println("Home Task #3 part #3:");
        String word = "Welcome to Java World";
        System.out.println(builtHTML(word));

//4. Given two strings. Check if they start with "The".
//
//   Task: word1 = "The End", word2="End The";
        System.out.println("Home Task #3 part #4:");
        String word1 = "The End";
        String word2 = "End The";
        System.out.println("String word1 is start with The ? --> " + startCheck (word1));
        System.out.println("String word2 is start with The ? --> " + startCheck (word2));

//5. Given a string "ABCDEFGHIJK". You need to make this string lowercased and remove all vowels.
        System.out.println("Home Task #3 part #5:");
        String upperCase = "ABCDEFGHIJK";
        System.out.println(setLowerCase(upperCase));

//6. Given 2 strings, a and b. Create a string c of the form short+long+short,
// with the shorter string on the outside and the longer string on the inside.
//
//   Task: a = "hop", b = "hello"
        System.out.println("Home Task #3 part #6:");

        String a = "hop";
        String b = "hello";
        System.out.println (shortLongshort(a,b));

//7. Given a user's email address: john_smith@example.com.
// Create two strings "login" and "domain" which will be substrings of full email address.
// The First Name and Last Name of the user should be in the following format: "Name Surname".
        System.out.println("Home Task #3 part #7:");

        String emailAddress = "john_smith@example.com";
        System.out.println(pullOutTheName(emailAddress));
//8. Given a string "Den, John, Will, Kate, Adam, Robin".
// Print all the names from the following string each from a new line.
//   Example:
//   Den
//   John
//   Will
//   Kate
//   ...
        System.out.println("Home Task #3 part #8:");

        String names = "Den, John, Will, Kate, Adam, Robin";
        sortNames (names);

//9. Given some random string s. Verify if that string ends with ".".
// If so, leave this string as is. If not - add it. Test strings create on your own.

        System.out.println("Home Task #3 part #9:");
        String withDot = "Hello Java.";
        String withOutDot = "My Name is Ivan";
        System.out.println("That string ends with \".\" ---> " + verifyEnds(withDot));
        System.out.println("That string ends without \".\" ---> " + verifyEnds(withOutDot));

// 10. Write a program which prints "Hello world"
// to the console using methods transformIntToChar and printList only.
        System.out.println("Home Task #3 part #10:");
        printList(transformIntToChar(72,101,108,108,111,32,87,111,114,108,100));

    }
}

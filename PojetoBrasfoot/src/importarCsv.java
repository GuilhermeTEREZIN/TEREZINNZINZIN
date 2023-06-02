import java.io.*;
import java.util.Scanner;
public class importarCsv
{
    public static void main(String[] args) throws Exception
    {
//parsing a CSV file into Scanner class constructor
        File file = new File("./PojetoBrasFoot/base/time.CSV");
//        System.out.println(file.exists());
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");   //sets the delimiter pattern
        //System.out.println("aaaaaaa");
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();  //closes the scanner
    }
}

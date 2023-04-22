package Assestment_8;import Assestment_8.TelephoneDirectory;import java.io.File;import java.io.FileNotFoundException;import java.util.Iterator;import java.util.Scanner;/**   A driver that demonstrates the class TelephoneDirectory.      @author Frank M. Carrano   @author Timothy M. Henry   @version 4.0*/public class TelephoneDirectoryDriver{   private static final Name INPUT_ERROR = new Name("error", "error");   private static final Name QUIT = new Name("quit", "quit");   public static void main(String[] args)   {      TelephoneDirectory directory = new TelephoneDirectory();      String fileName = "data.txt"; // Or file name could be read      try      {         Scanner data = new Scanner(new File(fileName));         directory.readFile(data);      }      catch (FileNotFoundException e)      {         System.out.println("File not found: " + e.getMessage());      }//=======================// This part is not in the book		System.out.println("The directory contains " + directory.getSize() + " names, as follows:\n");		Iterator<Name> nameTraverser   = directory.getKeyIterator();		Iterator<String> numberTraverser = directory.getValueIterator();		while (nameTraverser.hasNext() && numberTraverser.hasNext())			System.out.println(nameTraverser.next() + " " + numberTraverser.next());					Name joey  = new Name("Joey", "Jones");		Name jude  = new Name("Jude", "Jones");		Name jim   = new Name("Jimmy", "Jones");		Name jamie = new Name("Jamie", "Smith");		Name june  = new Name("June", "Jones");		Name judy  = new Name("Judy", "Jones");		Name bogus = new Name("Bo", "Gus");     // not in directory				System.out.println("\n\nLooking up phone numbers:");		System.out.println("Joey's number is "  + directory.getPhoneNumber(joey)  + " (should be 401-555-1234)");		System.out.println("Jude's number is "  + directory.getPhoneNumber(jude)  + " (should be 401-555-2345)");		System.out.println("Jimmy's number is " + directory.getPhoneNumber(jim)   + " (should be 401-555-3456)");		System.out.println("Jamie's number is " + directory.getPhoneNumber(jamie) + " (should be 401-555-4567)");		System.out.println("June's number is "  + directory.getPhoneNumber(june)  + " (should be 401-555-5678)");		System.out.println("Judy's number is "  + directory.getPhoneNumber(judy)  + " (should be 401-555-6789)");		System.out.println("Bo's number is "    + directory.getPhoneNumber(bogus) + " (should be null");//=======================      Name nextName = getName(); // Get name for search from user      while (!nextName.equals(QUIT))      {         if (nextName.equals(INPUT_ERROR))            System.out.println("Error in entering name. Try again.");         else         {            String phoneNumber = directory.getPhoneNumber(nextName);            if (phoneNumber == null)               System.out.println(nextName + " is not in the directory.");            else               System.out.println("The phone number for " + nextName +                                   " is " + phoneNumber);         } // end if         nextName = getName();      } // end while      System.out.println("Bye!");   } // end main   // Returns either the name read from user, INPUT_ERROR, or QUIT.   private static Name getName()   {      Name result = null;      Scanner keyboard = new Scanner(System.in);      System.out.print("Enter first name and last name, " +                       "or quit to end: ");      String line = keyboard.nextLine();      if (line.trim().toLowerCase().equals("quit"))         result = QUIT;      else      {         String firstName = null;         String lastName = null;         Scanner scan = new Scanner(line);         if (scan.hasNext())         {            firstName = scan.next();            if (scan.hasNext())               lastName = scan.next();            else               result = INPUT_ERROR;         }         else            result = INPUT_ERROR;                     if (result == null)         {            // First and last names have been read            result = new Name(firstName, lastName);         } // end if      } // end if      return result;   } // end getName} // end Driver/*The directory contains 6 names, as follows:Jimmy Jones 401-555-3456Joey Jones 401-555-1234Jude Jones 401-555-2345Judy Jones 401-555-6789June Jones 401-555-1111Jamie Smith 401-555-4567Looking up phone numbers:Joey's number is 401-555-1234 (should be 401-555-1234)Jude's number is 401-555-2345 (should be 401-555-2345)Jimmy's number is 401-555-3456 (should be 401-555-3456)Jamie's number is null (should be 401-555-4567)June's number is 401-555-1111 (should be 401-555-5678)Judy's number is 401-555-6789 (should be 401-555-6789)Bo's number is null (should be nullEnter first name and last name, or quit to end: Jude JonesThe phone number for Jude Jones is 401-555-2345Enter first name and last name, or quit to end: Jude SmithJude Smith is not in the directory.Enter first name and last name, or quit to end: quitBye!*/
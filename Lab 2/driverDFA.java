import java.io.*;
/**
* A Java application to demonstrate the ManWolf class by
* using it to filter the command line input stream. 
* Solutions are evaluated and confirmation or denial
* messages are printed to the command line.
*/
public class driverDFA {
 public static void main(String[] args)
  throws IOException {

 ManWolf m = new ManWolf(); // The DFA
 Console c = System.console(); // Standard input
  if (c == null) {
   System.exit(1);
  }
// Read line
 String s = c.readLine();
 if (s!=null) {
  m.process(s);
  if (m.isCorrect()) System.out.println("That is a solution.");
  else System.out.println("That is not a solution.");
  }
 }
}
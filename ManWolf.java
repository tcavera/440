/**
* A deterministic finite-state automaton that
* recognizes strings that are valid solutions
* to the man-wolf-goat-cabbage problem.
*/
public class ManWolf {
/*
* Constants q0 through q10 represent states, and
* an int holds the current state code.
*/
private static final int q0 = 0;
private static final int q1 = 1;
private static final int q2 = 2;
private static final int q3 = 3;
private static final int q4 = 4;
private static final int q5 = 5;
private static final int q6 = 6;
private static final int q7 = 7;
private static final int q8 = 8;
private static final int q9 = 9;
private static final int q10 = 10;

int state = q0;

static private int[][] delta = 
    {{q9,q1,q9,q9},   //q0
     {q9,q0,q2,q9},   //q1
     {q3,q9,q1,q7},   //q2
     {q2,q4,q9,q9},   //q3
     {q9,q3,q9,q5},   //q4
     {q8,q9,q6,q4},   //q5
    {q9,q10,q5,q9},  //q6
    {q9,q8,q9,q2},   //q7
    {q5,q7,q9,q9},   //q8
     {q9,q9,q9,q9},   //q9
    {q9,q6,q9,q9}};  //q10

/**
 * Makes one transition on each char in 
 * the given string
 * @param in: the string to use as input
**/
public void process (String in) {
    for (int i = 0; i < in.length(); i++) {
      char c = in.charAt(i);
      try {
        state = delta[state][c-'a']; // fix me
      }
    catch (ArrayIndexOutOfBoundsException ex) {
      state = delta[state][1]; // possible solution
    }
  }
}

public boolean isCorrect () {
  return state == q10;
 }
}

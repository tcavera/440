/*
 * file: DFA.java
 * author: Tyler Cavera
 * course: Formal Languages and Computability
 * assignment: Final Project
 * due date: May 2nd, 2016
 * version 1.0
 * 
 * This is the file for the DFA of our Text Editor project. 
 *
 */

public class DFA {
  
  private static final int q0 = 0; // the initial state
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
  private static final int q11 = 11;
  private static final int q12 = 12; 
  private static final int q13 = 13;
  private static final int q14 = 14;
  private static final int q15 = 15;
  private static final int q16 = 16;
  private static final int q17 = 17; 
  private static final int q18 = 18;
  private static final int q19 = 19;
  private static final int q20 = 20;
  private static final int q21 = 21;
  private static final int q22 = 22; 
  private static final int q23 = 23;
  private static final int q24 = 24;
  private static final int q25 = 25;
  private static final int q26 = 26;
  private static final int q27 = 27; 
  private static final int q28 = 28;
  private static final int q29 = 29;
  private static final int q30 = 30;
  private static final int q31 = 31;
  private static final int q32 = 32;
  private static final int q33 = 33;
  private static final int q34 = 34;
  private static final int q35 = 35;
  private static final int q36 = 36;
  private static final int q37 = 37;
  private static final int q38 = 38;
  private static final int q39 = 39;
  private static final int q40 = 40;
  private static final int err = 41; //error state
  
  public static int currentState;

  private int[][] delta = {
      {q1,   q23,  q23,  q23,  q23,  err,  q13,  q23,  err,  err,  q23,  err,  err,  q18,  err,  err,  err,  err}, //q0
      {err,  q2,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q1
      {err,  err,  q3,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q2
      {err,  err,  err,  q4,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q3
      {err,  err,  err,  err,  q5,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q4
      {err,  err,  err,  err,  err,  q6,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q5
      {err,  err,  err,  err,  err,  err,  err,  err,  q7,   err,  err,  err,  err,  err,  err,  err,  err,  err}, //q6
      {err,  err,  err,  err,  err,  q8,   err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q7
      {q9,   q9,   q9,   q9,    q9,  q33,  q9,   q9,   err,  err,  q9,   q10,  err,  err,  err,  q30,  err,  err}, //q8
      {err,  err,  err,  err,  err,  q11,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q9
      {err,  err,  err,  err,  err,  q11,  err,  err,  err,  err,  err,  q10,  err,  err,  err,  err,  err,  err}, //q10
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  q12,  err,  err,  err,  err,  err,  err,  err,  err}, //q11
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q12
      {err,  err,  err,  err,  err,  err,  err,  q14,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q13
      {err,  q15,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q14
      {err,  err,  err,  err,  err,  q16,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q15
      {q23,  q23,  q23,  q23,  q23,  err,  q23,  q23,  err,  err,  q23,  err,  err,  err,  err,  err,  err,  err}, //q16
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q17
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q19,  err,  err,  err}, //q18
      {q20,  q20,  q20,  q20,  q20,  q20,  q20,  q20,  err,  err,  q20,  err,  err,  err,  err,  err,  err,  err}, //q19
      {q20,  q20,  q20,  q20,  q20,  q20,  q20,  q20,  err,  err,  q20,  err,  err,  err,  q21,  err,  err,  err}, //q20
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q22,  err,  err,  err,  err}, //q21
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q22
      {err,  err,  err,  err,  err,  q24,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q23
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q25,  err}, //q24
      {err,  err,  err,  err,  err,  q26,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q25
      {q27,  q27,  q27,  q27,  q27,  err,  q27,  q27,  err,  err,  q27,  q35,  err,  err,  err,  q37,  err,  err}, //q26
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q27
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q29,  err,  err,  err,  err,  err}, //q28
      {err,  err,  err,  err,  err,  q36,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q29
      {q31,  q31,  q31,  q31,  q31,  q31,  q31,  q31,  err,  err,  q31,  err,  err,  err,  err,  err,  err,  err}, //q30
      {q31,  q31,  q31,  q31,  q31,  q34,  q31,  q31,  err,  err,  q31,  err,  err,  err,  err,  err,  err,  err}, //q31
      {err,  err,  err,  err,  err,  q11,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q32
      {err,  err,  err,  err,  err,  q11,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q33
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q32,  err,  err}, //q34
      {err,  err,  err,  err,  err,  q28,  err,  err,  err,  err,  err,  q27,  err,  err,  err,  err,  err,  err}, //q35
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q27,  err,  err,  err,  err,  err,  err}, //q36
      {err,  err,  err,  err,  err,  q38,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}, //q37
      {q39,  q39,  q39,  q39,  q39,  q39,  q39,  q39,  err,  err,  q39,  err,  err,  err,  err,  err,  err,  err}, //q38
      {q39,  q39,  q39,  q39,  q39,  q40,  q39,  q39,  err,  err,  q39,  err,  err,  err,  err,  err,  err,  err}, //q39
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  q27,  err,  err}, //q40
      {err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err,  err}  //err
  };

 
  public static void reset(){
    currentState = q0;
  }
  
  public static String process(String inputString){
      reset();
           
      for(int i = 0; i < inputString.length(); i++){
    	  //...
    	  switch (currentState) {
    	  	case q1:
    	  	case q2:
    	  	case q3:
    	  	case q4:
    	  	case q5:
    	  	case q6:
			case q7:
			case q8:
			case q9:
			case q10:
			case q11:
			case q12:
			case q13:
			case q14:
			case q15: 
			case q16:
			case q17: 
			case q18: 
			case q19:
			case q20:
			case q21:
			case q22: 
			case q23:
			case q24:
			case q25:
			case q26:
			case q27:	
			case q28:
			case q29:
			case q30:
			case q31:
			case q32:
			case q33:
			case q34: 
			case q35:
			case q36:
			case q37:
			case q38:
			case q39:
			case q40: 
			case err:
    	  }
	}
    
     //everything is red
  	
  	 return  inputString = new StringBuilder(inputString).insert(0, "<font color='red'>").toString();
   }
}
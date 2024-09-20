/*You are given a string s consisting of different types of parentheses: (), {}, and []. Your task is to determine whether the given string is valid.
A string is considered valid if:
Every opening bracket has a corresponding closing bracket of the same type.
The brackets are closed in the correct order. This means that a closing bracket must close the most recent unmatched opening bracket.*/

import java.util.*;
public class Main
{
    public static boolean parantheses(String s)
    {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray())
        {
            if(c=='(' || c=='{'||c=='[')
            {
                st.push(c);
            }
            else if(c==')' && st.peek()=='(' && !st.isEmpty())
            {
                st.pop();
            }
            else if(c=='}' && st.peek()=='{' && !st.isEmpty())
            {
                st.pop();
            }
            else if(c==']' && st.peek()==']' && !st.isEmpty())
            {
                st.pop();
            }
            else{
                return false;
            }
        }
        return st.isEmpty();
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    String input = sc.nextLine();
	    
	    boolean result=parantheses(input);
	    System.out.println(result);
	    sc.close();
	}
}


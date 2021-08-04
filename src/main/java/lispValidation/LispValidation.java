package main.java.lispValidation;

import java.util.Stack;

public class LispValidation {
	
	public static boolean checkCode(String lispCode) {
//create a stack of chars to track brackets
		Stack<Character> stk = new Stack<Character>();
//iterate over the string character by character
		for(char c : lispCode.toCharArray()) {
//if an open bracket is found push it to the stack
			if(c == '(') {
				stk.push(c);
//if a closed bracket is found check if the stack is empty if it is return false as 
//the given code has too many closed brackets thus it will fail
//if the stack is not empty pop the stack once
			}else if(c ==')') {
				if(stk.empty()) {
					return false;
				}else{
					stk.pop();
				}
			}
		}
//after all characters are read check if the stack is empty
//if it is not there were too many open brackets and code will not run
		if(!stk.empty()) {
			return false;
		}
//return true because no condition that would result in false occurred 
		return true;
	}

}

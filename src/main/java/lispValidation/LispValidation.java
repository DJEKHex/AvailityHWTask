package main.java.lispValidation;

import java.util.Stack;

public class LispValidation {
	
	public static boolean checkCode(String lispCode) {
		
		Stack<Character> stk = new Stack<Character>(); 
		for(char c : lispCode.toCharArray()) {
			if(c == '(') {
				stk.push(c);
			}else if(c ==')') {
				if(stk.empty()) {
					return false;
				}else{
					stk.pop();
				}
			}
		}
		if(!stk.empty()) {
			return false;
		}
		return true;
	}

}

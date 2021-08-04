package main.java;

import java.io.FileNotFoundException;
import java.io.IOException;

import main.java.enrollmentParser.service.Parser;
import main.java.lispValidation.LispValidation;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(LispValidation.checkCode("(defun double (x) (* x 2))"));
		System.out.println(LispValidation.checkCode("((defun double (x) (* x 2))"));
		System.out.println(LispValidation.checkCode("()defun double (x) (* x 2))"));
		
		try {
			Parser.sortCSVFile("resource/testCSV1.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

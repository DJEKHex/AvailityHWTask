package tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import main.java.enrollmentParser.service.Parser;
import main.java.lispValidation.LispValidation;


public class AllTests {

//run sortCSVFile method before tests to generate insurance co files.	
	@Before
	public void generateCVS() {
		try {
			Parser.sortCSVFile("resource/testCSV1.csv");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//test one two and three test the lisp validation 	
	@Test
	public void test1() {
		assert(LispValidation.checkCode("(defun double (x) (* x 2))") == true);
	}

	@Test
	public void test2() {
		assert(LispValidation.checkCode("((defun double (x) (* x 2))") == false);
	}
	
	@Test
	public void test3() {
		assert(LispValidation.checkCode("(defun double (x)) (* x 2))") == false);
	}
//test that one of the co files matches with the expected file result	
	@Test
	public void CSVTestAetna() {
		File file1 = new File("resource/aetnaCSVSample.CSV");
		File file2 = new File("resource/aetna.csv");
		try {
			byte[] file1bytes = Files.readAllBytes(file1.toPath());
			byte[] file2bytes = Files.readAllBytes(file2.toPath());
			assert(Arrays.equals(file1bytes, file2bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//test that two different files create are not the same ensuring it is not just one data set in all files.	
	@Test
	public void CSVTestAetnaFailCase() {
		File file1 = new File("resource/metLife.CSV");
		File file2 = new File("resource/aetna.csv");
		try {
			byte[] file1bytes = Files.readAllBytes(file1.toPath());
			byte[] file2bytes = Files.readAllBytes(file2.toPath());
			assert(!Arrays.equals(file1bytes, file2bytes));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

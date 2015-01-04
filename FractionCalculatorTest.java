/**
 * Created by Zsolt Balvanyos for PiJ coursework 2 
 * 22.11.2014
 */
 
import java.util.Scanner;
 
 public class FractionCalculatorTest {
	public static void main(String[] args) {
		
		FractionCalculator FTtest = new FractionCalculator();
		Fraction testValue = new Fraction(0,1);
		String testInput = "";
		
		//test for correct input
		testInput = "4/5 + 2/3";
		Fraction a = new Fraction(22,15);
		if(!FTtest.evaluate(testValue,testInput).equals(a)) System.out.println("Evaluation failed");
		
		testInput = "3/5 / -8/12 neg * 4/7 c 5";
		Fraction b = new Fraction(5);
		if(!FTtest.evaluate(testValue,testInput).equals(b)) System.out.println("Evaluation failed");
		
		testInput = "-1/2 abs + 1/2 - 8/3 neg";
		Fraction c = new Fraction(5,3);
		if(!FTtest.evaluate(testValue,testInput).equals(c)) System.out.println("Evaluation failed");
		
		//test for two consecutive operations
		testInput = "4/5 + * 2/3";
		Fraction d = new Fraction(22,15);
		if(!FTtest.evaluate(testValue,testInput).equals(d)) System.out.println("Evaluation failed");
	}
 }
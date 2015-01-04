/**
 * Created by Zsolt Balvanyos for PiJ coursework 2 
 * 22.11.2014
 */
 
import java.util.Scanner;

public class FractionCalculator {
	private boolean error = false;
	
	public static void main(String[] args) {
		FractionCalculator FT = new FractionCalculator();
		FT.run();
	}
	
	private void run() {
		Scanner in = new Scanner(System.in);
		String input = "";
		
		Fraction value = new Fraction(0,1);
	
		System.out.println("-------------------------------------------------");
		System.out.println("FRACTION CALCULATOR created by Zsolt Balvanyos. |");
		System.out.println("-------------------------------------------------");
		
		System.out.println("To exit enter q, Q, or quit.");
		System.out.println("Press ENTER to evaluate.");
		System.out.println("");
		System.out.print("> ");
		
		do{
			input = in.nextLine();
			value = this.evaluate(value,input);
			if(!(input.equals("quit") || input.equals("q") || input.equals("Q"))) {
				System.out.println("Result: " + value.toString());	
				System.out.print("> ");
			}
			if(this.getError()) {
				this.setError(false);
			}
		}while(!(input.equals("quit") || input.equals("q") || input.equals("Q")));
		
		System.out.println("Goodbye");
	}
	
	public Fraction evaluate(Fraction fraction, String inputString) {
		String nextToken = "";
		String operation = "";
		int i = 0;
		
		while(i < inputString.length() && !error) {
			while(i < inputString.length() && inputString.charAt(i) != ' ') {
				nextToken = nextToken + inputString.charAt(i);
				i++;
			}
			if(i == inputString.length() || inputString.charAt(i) == ' ') {
				if(nextToken.equals("+") || nextToken.equals("-") || nextToken.equals("*") || nextToken.equals("/")) {
					if(!operation.equals("")){
						return handleError();
					}else{
						operation = nextToken;
					}
				}
				else if(checkIfFraction(nextToken)){
					if(operation.equals("")) {
						fraction = createFraction(nextToken);
					}
					if(operation.equals("+")) {
						fraction = fraction.add(createFraction(nextToken));
						operation = "";
					}
					if(operation.equals("-")) {
						fraction = fraction.subtract(createFraction(nextToken));
						operation = "";
					}
					if(operation.equals("*")) {
						fraction = fraction.multiply(createFraction(nextToken));
						operation = "";
					}
					if(operation.equals("/")) {
						fraction = fraction.divide(createFraction(nextToken));
						operation = "";
					}
				}
				else if(nextToken.equals("a") || nextToken.equals("A") || nextToken.equals("abs")) {
					fraction = fraction.absValue();
				}
				else if(nextToken.equals("n") || nextToken.equals("N") || nextToken.equals("neg")) {
					fraction = fraction.negate();
				}
				else if(nextToken.equals("c") || nextToken.equals("C") || nextToken.equals("clear")) {
					fraction.setNumerator(0);
					fraction.setDenominator(1);
				}
				else if(nextToken.equals("q") || nextToken.equals("Q") || nextToken.equals("quit")) {
					return new Fraction(fraction.getNumerator(),fraction.getDenominator());
				}else{
					handleError();
				}
				nextToken = "";
				i++;
			}
		}
		if(error) {
			return new Fraction(0,1);
		}
		return new Fraction(fraction.getNumerator(),fraction.getDenominator());
	}
	
	public boolean getError() {
		return error;
	}
	
	public void setError(boolean error) {
		this.error = error;
	}
	
	private boolean checkIfFraction(String fraction){
		int counterOver = 0;
		int counterMinus = 0;
		if(fraction.equals("-")) {
			return false;
		}
		if(fraction.charAt(0)=='/' || fraction.charAt(fraction.length()-1)=='/'){
			return false;
		}
		for(int i=0; i<fraction.length(); i++) {
			if(!(Character.isDigit(fraction.charAt(i)) || fraction.charAt(i) == '/' || fraction.charAt(i) == '-')) {
				return false;
			}
			if(fraction.charAt(i) == '/') {
				counterOver++;
				if(counterOver > 1) {
					return false;
				}
			}
			if(fraction.charAt(i) == '-') {
				counterMinus++;
				if(i == 0) {
					if(!Character.isDigit(fraction.charAt(i + 1))) {
						return false;
					}
				}
				if(i > 0) {
					if(fraction.charAt(i - 1) != '/' || !Character.isDigit(fraction.charAt(i + 1))) {
						return false;
					}
				}
				if(counterMinus > 2) {
					return false;
				}
			}
		}
		return true;
	}
	
	private Fraction createFraction(String fraction) {
		int i = 0;
		String temp = "";
		
		while(i<fraction.length() && fraction.charAt(i)!='/') {
			temp = temp + fraction.charAt(i);
			i++;
		}
		int num = Integer.parseInt(temp);
		
		if(i==fraction.length()) {
			return new Fraction(num);
		}
		
		i++;
		temp = "";
		
		while(i<fraction.length()) {
			temp = temp + fraction.charAt(i);
			i++;
		}
		int denom = Integer.parseInt(temp);
		
		if(denom == 0) {
			handleError();
		}
		return new Fraction(num,denom);
	}
	private Fraction handleError() {
		error = true;
		System.out.println("Error");
		return new Fraction(0,1);
	}
}
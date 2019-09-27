import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintNumbers {

	private static Scanner scan = new Scanner(System.in);

	// DON'T MODIFY MAIN!
	public static void main(String[] args) {
		printNumber(true);
		printNumber(false);
	}

	public static void printNumber(boolean mayContainsDecimals) {
		System.out.println("Enter a number " + (mayContainsDecimals ? "possibly with" : "without") + " decimals:");
		if (mayContainsDecimals) {
			double d = readDouble();
			System.out.println("Your number is: " + d);
		} else {
			int n = readInteger();
			System.out.println("Your non-decimal number is: " + n);
		}
	}

	private static int readInteger() {
		int number = Integer.parseInt(scan.nextLine());
		return number;
	}

	private static double readDouble() {
		double number = Double.parseDouble(scan.nextLine());
		return number;
	}
}

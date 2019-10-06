import java.util.Scanner;

public class Lab1b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in).useDelimiter("\\r\\n");

		System.out.printf("Enter a positive whole number to approximate its square root (ex. 4): ");
		// Prevent non-long input
		while (!in.hasNextLong()) {
			System.out.printf("\nEnter a positive whole number (ex. 13): ");
			in.next();
		}
		long input = in.nextLong();
		
		//Ensure positive input
		input = checkNeg(input);

		double output = sqrt(input);

		System.out.printf("\nThe approximate square root of %d is %f.", input, output);
		//System.out.println("\n" + output * output);

	}

	// Ensure positive input value
	public static long checkNeg(long input) {
		Scanner in = new Scanner(System.in).useDelimiter("\\r\\n");
		while (input <= 0) {
			System.out.printf("\nEnter a positive whole number.\n\nEnter value: ");
			input = in.nextLong();
		}
		long output = input;
		return output;
	}
	
	// Calculate square root with the Babylonian method (pg. 239)
	public static double sqrt(long input) {
		double nextGuess, lastGuess = 1, diffGuess;
		for (diffGuess = 1; diffGuess > 0.0001;) {
			nextGuess = (lastGuess + input / lastGuess) / 2;
			diffGuess = Math.abs(nextGuess - lastGuess);
			lastGuess = nextGuess;
		}
		return lastGuess;
	}

}

package loopfusion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoopFusion {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		int result = Arrays.stream(numbers)
			.filter(n -> n % 2 != 0)
			.map(n -> n * n)
			.reduce(1, (a, b) -> a * b);


		System.out.println("홀수를 제곱한 곱: " + result);


		int result2 = Arrays.stream(numbers)
			.filter(n -> {
				System.out.println("filtering : " + n);
				return n % 2 != 0;
			})
			.map(n -> {
				System.out.println("mapping : " + n);
				return n * n;
			})
			.peek(p -> System.out.println("reducing: " + p))
			.reduce(1, (a, b) -> a * b);

		System.out.println("\n홀수를 제곱한 곱: " + result2);
	}
}

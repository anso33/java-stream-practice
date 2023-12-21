package loopfusion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LoopFusion {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		long start = System.currentTimeMillis();
		long result = Arrays.stream(numbers)
			.filter(n -> n % 2 != 0)
			.map(n -> n * n)
			.reduce(1, (a, b) -> a * b);
		long end = System.currentTimeMillis();

		System.out.println("홀수를 제곱한 곱: " + result);
		System.out.println("Stream 걸린 시간: " + (end - start) + "ms");


		int result2 = Arrays.stream(numbers)
			.filter(n -> {
				System.out.println("filtering : " + n);
				return n % 2 != 0;
			})
			.map(n -> {
				System.out.println("mapping : " + n);
				return n * n;
			})
			.reduce(1, (a, b) -> {
				System.out.println("reducing: " + b + "\n");
				return a * b;
			});

		System.out.println("\n홀수를 제곱한 곱: " + result2);

		List<Integer> numbersList = new ArrayList<>();
		for (int i = 1; i <= 100_000_000; i++) {
			numbersList.add(i);
		}

		long startCollection = System.currentTimeMillis();
		long res = numbersList.stream()
			.filter(n -> n % 2 != 0)
			.map(n -> n + n)
			.reduce(1, (a, b) -> a + b);
		long endCollection = System.currentTimeMillis();

		System.out.println("\n홀수를 2번씩 더한 값: " + res);
		System.out.println("Stream 걸린 시간: " + (endCollection - startCollection) + "ms");


	}
}

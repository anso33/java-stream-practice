package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class Parallel {

	public static void main(String[] args) {
		ArrayList<Participant> participantList = Util.init();

		long start = System.currentTimeMillis();
		participantList.stream()
			.filter(participant ->
				("kernel360".equals(participant.getCompany()) && "software engineer".equals(participant.getPosition())))
			.forEach(p -> System.out.println(p));
		long end = System.currentTimeMillis();

		System.out.println("Stream: " + (end - start) + "ms");

		long parallelStart = System.currentTimeMillis();
		participantList.stream()
			.parallel()
			.filter(participant ->
				("kernel360".equals(participant.getCompany()) && "software engineer".equals(participant.getPosition())))
			.forEach(p -> System.out.println(p));
		long parallelEnd = System.currentTimeMillis();

		System.out.println("Parallel Stream: " + (parallelEnd - parallelStart) + "ms");

	}

}

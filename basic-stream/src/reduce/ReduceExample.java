package reduce;

import java.util.List;

import common.Participant;
import common.Util;

public class ReduceExample {

	public static void main(String[] args) {

		List<Participant> participantList = Util.init();

		// reduce by for loop
		int sumAge = 0;
		for (Participant participant : participantList) {
			sumAge += participant.getAge();
		}
		double averageAgeByForLoop = sumAge / (double) participantList.size();

		System.out.println("For-Loop | Average Age: " + averageAgeByForLoop);

		// reduce by stream
		double averageAge = participantList.stream()
			.mapToInt(Participant::getAge)
			.reduce(0, (sum, age) -> sum + age)
			/ (double) participantList.size();

		System.out.println("Stream | Average Age: " + averageAge);

	}
}

package reduce;

import java.util.List;
import java.util.function.BinaryOperator;

import common.Participant;
import common.Util;

class ParticipantFilter implements BinaryOperator<Participant> {
	@Override
	public Participant apply(Participant participant, Participant participant2) {
		if (participant.getAge() > participant2.getAge()) {
			return participant;
		} else if (participant.getAge() < participant2.getAge()) {
			return participant2;
		}
		return participant;
	}
}


public class ReduceExample {

	public static void main(String[] args) {

		List<Participant> participantList = Util.init();

		Participant oldestParticipant = participantList.stream()
			.reduce((participant, participant2) -> {
				if (participant.getAge() > participant2.getAge()) {
					return participant;
				} else if (participant.getAge() < participant2.getAge()) {
					return participant2;
				}
				return participant;
			}).get();
		System.out.println("Oldest Participant: " + oldestParticipant);


		Participant oldestParticipantByReduce = participantList.stream().reduce(new ParticipantFilter()).get();
		System.out.println("Oldest Participant: " + oldestParticipantByReduce);







		// reduce by for loop
		int sumAge = 0;
		for (Participant participant : participantList) {
			sumAge += participant.getAge();
		}
		double averageAgeByForLoop = sumAge / (double)participantList.size();

		System.out.println("For-Loop | Average Age: " + averageAgeByForLoop);

		// reduce by stream
		double averageAge = participantList.stream()
			.mapToInt(Participant::getAge)
			.reduce(0, (sum, age) -> sum + age)
			/ (double)participantList.size();

		System.out.println("Stream | Average Age: " + averageAge);

	}
}



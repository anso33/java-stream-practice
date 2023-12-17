package limit;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class LimitExample {

	public static void main(String[] args) {
		List<Participant> participantList = Util.init();

		// // limit by for loop
		// List<Participant> limit5ThatAgeIs20sByForLoop = new ArrayList<>();
		// int count = 0;
		// for (Participant participant : participantList) {
		// 	if (participant.getAge() >= 20 && participant.getAge() < 30) {
		// 		limit5ThatAgeIs20sByForLoop.add(participant);
		// 		count++;
		// 		if (count == 5) {
		// 			break;
		// 		}
		// 	}
		// }
		//
		// System.out.println("limit 5 that age is 20s by for loop");
		// System.out.println(limit5ThatAgeIs20sByForLoop);


		// limit by stream
		List<Participant> limit5ThatAgeIs20sByStream = participantList.stream()
				.filter(participant -> participant.getAge() >= 20 && participant.getAge() < 30)
				.limit(5)
				.collect(Collectors.toList());

		System.out.println("limit 5 that age is 20s by stream");
		System.out.println(limit5ThatAgeIs20sByStream);


	}
}

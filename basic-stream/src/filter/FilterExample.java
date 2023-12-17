package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class FilterExample {

	public static void main(String[] args) {
		ArrayList<Participant> participantList =Util.init();

		// filter by for loop
		// List<Participant> kernel360CrewListByForLoop = new ArrayList<>();
		// for (Participant participant : participantList) {
		// 	if ("kernel360".equals(participant.getCompany()) && "software engineer".equals(participant.getPosition())) {
		// 		kernel360CrewListByForLoop.add(participant);
		// 	}
		// }
		// System.out.println(kernel360CrewListByForLoop);


		// filter by stream
		List<Participant> kernel360CrewListByStream = participantList.stream()
				.filter(participant ->
					("kernel360".equals(participant.getCompany()) && "software engineer".equals(participant.getPosition())))
				.collect(Collectors.toList());

		System.out.println(kernel360CrewListByStream);
	}
}

package distinct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class DistinctExample {

	public static void main(String[] args) {
		ArrayList<Participant> participantList = Util.init();

		/**
		 * distinct elements by for loop
		 */
		List<String> distinctCompanyListByForLoop = new ArrayList<>();
		for (Participant participant : participantList) {
			if (!distinctCompanyListByForLoop.contains(participant.getCompany())) {
				distinctCompanyListByForLoop.add(participant.getCompany());
			}
		}
		System.out.println("distinct Company List By For-Loop");
		System.out.println(distinctCompanyListByForLoop);


		/**
		 * distinct elements by stream
		 */
		List<String> distinctCompanyListByStream = participantList.stream()
				.map(Participant::getCompany)
				.distinct()
				.collect(Collectors.toList());

		System.out.println("distinct Company List By Stream");
		System.out.println(distinctCompanyListByStream);
	}
}

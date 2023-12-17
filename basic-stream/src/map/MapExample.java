package map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class MapExample {

	public static void main(String[] args) {
		ArrayList<Participant> participantList = Util.init();

		/**
		 * generate a new list of specific elements by for loop
		 */
		List<String> distinctCompanyListByForLoop = new ArrayList<>();
		for (Participant participant : participantList) {
			distinctCompanyListByForLoop.add(participant.getCompany());
		}

		System.out.println("map Company List By For-Loop");
		System.out.println(distinctCompanyListByForLoop);


		/**
		 * generate a new list of specific elements by stream
		 */
		List<String> distinctCompanyListByStream = participantList.stream()
			.map(Participant::getCompany)
			.collect(Collectors.toList());

		System.out.println("map Company List By Stream");
		System.out.println(distinctCompanyListByStream);
	}
}

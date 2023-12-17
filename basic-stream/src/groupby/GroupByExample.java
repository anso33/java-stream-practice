package groupby;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.Participant;
import common.Util;

public class GroupByExample {

	public static void main(String[] args) {

		List<Participant> participantList = Util.init();

		// group by for loop
		Map<String, Integer> sumByRole = new HashMap<>();
		Map<String, Integer> countByRole = new HashMap();

		// 직군별로 나이의 합과 개수를 계산
		for (Participant participant : participantList) {
			String role = participant.getPosition();
			int age = participant.getAge();

			sumByRole.put(role, sumByRole.getOrDefault(role, 0) + age);
			countByRole.put(role, countByRole.getOrDefault(role, 0) + 1);
		}

		// 직군별 나이의 평균을 계산하고 출력
		Map<String, Double> averageAgeByRole = new HashMap<>();
		for (String role : sumByRole.keySet()) {
			int sum = sumByRole.get(role);
			int count = countByRole.get(role);
			double averageAge = (double) sum / count;

			averageAgeByRole.put(role, averageAge);
		}

		// 결과 출력
		System.out.println("Grouping And Get Average By For Loop");
		averageAgeByRole.forEach((role, averageAge) ->
			System.out.println(role + ": " + averageAge));

		System.out.println("\n\n\n");


		// group by stream
		Map<String, Double> averagePositionAgeByStream = participantList.stream()
			.collect(Collectors.groupingBy(Participant::getPosition,
				Collectors.mapping(Participant::getAge, Collectors.averagingInt(Integer::intValue))));

		// 결과 출력
		System.out.println("Grouping And Get Average By Stream");
		averagePositionAgeByStream.forEach((role, averageAge) ->
			System.out.println(role + ": " + averageAge));

	}
}

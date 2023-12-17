package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

	public static ArrayList<Person> init(ArrayList<Person> list) {
		list.add(new Person("hodako", 20));
		list.add(new Person("green", 21));
		list.add(new Person("zorba", 16));
		list.add(new Person("lune", 22));
		list.add(new Person("ross", 23));
		list.add(new Person("abu", 24));
		list.add(new Person("kelly", 34));
		list.add(new Person("daco", 35));
		list.add(new Person("stone", 36));
		list.add(new Person("han", 37));
		list.add(new Person("jinny", 17));
		list.add(new Person("fanta", 18));
		list.add(new Person("san", 19));
		list.add(new Person("milo", 42));
		list.add(new Person("seon", 48));
		list.add(new Person("xixo", 47));
		list.add(new Person("alex", 49));
		list.add(new Person("dante", 51));
		list.add(new Person("emil", 54));
		list.add(new Person("juby", 58));
		return list;
	}

	public static void main(String[] args) {

		/**
		 * example for internal iteration
		 */
		List<String> list = List.of("a", "b", "c", "d", "e");
		list.stream()
			.filter(s -> "d".equals(s))
			.forEach(System.out::println);

		for (String s : list) {
			if ("d".equals(s)) {
				System.out.println(s);
			}
		}

		/**
		 * example for intermediate operation
		 */

		ArrayList<Person> participantList = new ArrayList<>();
		participantList = init(participantList);

		List<String> result = participantList.stream()
			.filter(p -> (p.getAge() > 20 && p.getAge() < 40))
			.map(p -> p.getName())
			.limit(2)
			.collect(Collectors.toList());

		/**
		 * example for pipelining
		 */
		List<String> result2 = participantList.stream()
			.filter(p -> {
				System.out.println("filtering : " + p.getName());
				return p.getAge() > 20 && p.getAge() < 40;
			})
			.map(p -> {
				System.out.println("mapping : " + p.getName());
				return p.getName();
			})
			.limit(2)
			.peek(p -> System.out.println("limiting: " + p))
			.collect(Collectors.toList());



	}
}

package common;

import java.util.ArrayList;

public class Util {

	public static ArrayList<Participant> init() {
		ArrayList<Participant> list = new ArrayList<>();

		list.add(new Participant("hodako", "software engineer", "kernel360", 20));
		list.add(new Participant("green", "software engineer", "kernel360", 21));
		list.add(new Participant("lune", "software engineer", "kernel360", 22));
		list.add(new Participant("ross", "software engineer", "kernel360", 23));
		list.add(new Participant("abu", "software engineer", "kernel360", 24));
		list.add(new Participant("kelly", "software engineer", "kernel360", 34));
		list.add(new Participant("daco", "software engineer", "kernel360", 35));
		list.add(new Participant("stone", "software engineer", "kernel360", 36));
		list.add(new Participant("han", "software engineer", "kernel360", 37));
		list.add(new Participant("zorba", "software engineer", "kernel360", 16));
		list.add(new Participant("jinny", "software engineer", "kernel360", 17));
		list.add(new Participant("fanta", "software engineer", "kernel360", 18));
		list.add(new Participant("san", "software engineer", "kernel360", 19));
		list.add(new Participant("milo", "software engineer", "kernel360", 42));
		list.add(new Participant("seon", "software engineer", "kernel360", 48));
		list.add(new Participant("xixo", "software engineer", "kernel360", 47));
		list.add(new Participant("alex", "software engineer", "kernel360", 49));
		list.add(new Participant("dante", "software engineer", "kernel360", 51));
		list.add(new Participant("emil", "software engineer", "kernel360", 54));
		list.add(new Participant("juby", "software engineer", "kernel360", 58));

		list.add(new Participant("zero", "product manager", "kernel360", 25));
		list.add(new Participant("swim", "product manager", "kernel360", 26));
		list.add(new Participant("bible", "product manager", "kernel360", 27));

		list.add(new Participant("silver", "director", "kernel360", 31));
		list.add(new Participant("good", "director", "kernel360", 32));
		list.add(new Participant("min", "director", "kernel360", 33));

		list.add(new Participant("tomas", "recruiter", "naver", 46));
		list.add(new Participant("jake", "recruiter", "naver", 62));
		list.add(new Participant("jim", "recruiter", "kakao", 27));
		list.add(new Participant("suji", "recruiter", "kakao", 56));
		list.add(new Participant("wonyoung", "recruiter", "line", 28));
		list.add(new Participant("youjin", "recruiter", "line", 28));
		list.add(new Participant("winter", "recruiter", "coupang", 33));
		list.add(new Participant("ningning", "recruiter", "coupang", 36));

		list.add(new Participant("karina", "software engineer", "woowahan", 45));
		list.add(new Participant("chaewon", "software engineer", "woowahan", 38));
		list.add(new Participant("sakura", "software engineer", "woowahan", 42));
		list.add(new Participant("minji", "software engineer", "daangn", 29));
		list.add(new Participant("haerin", "software engineer", "daangn", 32));
		list.add(new Participant("sohee", "software engineer", "daangn", 36));
		list.add(new Participant("daniel", "software engineer", "toss", 42));
		list.add(new Participant("jenny", "software engineer", "toss", 54));
		list.add(new Participant("jisoo", "software engineer", "toss", 48));
		list.add(new Participant("lisa", "software engineer", "toss", 30));

		return list;
	}
}

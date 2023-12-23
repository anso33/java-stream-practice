package com.anso.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.anso.demo.dto.CompanyParticipantList;
import com.anso.demo.dto.StreamResponse;
import com.anso.demo.entity.Participant;
import com.anso.demo.repository.DemoEMRepository;
import com.anso.demo.repository.DemoRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {
	private final DemoRepository demoRepository;
	private final DemoEMRepository demoEMRepository;

	public StreamResponse getListByStream() {
		List<Participant> participantList = demoRepository.findAllByPosition("software engineer");

		long start = System.currentTimeMillis();
		List<CompanyParticipantList> result = participantList.stream()
			.collect(Collectors.groupingBy(Participant::getCompany))
			.entrySet().stream()
			.map(entry -> {
				String companyName = entry.getKey();
				List<Participant> sortedParticipants = entry.getValue().stream()
					.sorted(Comparator.comparing(Participant::getCreatedAt))
					.collect(Collectors.toList());
				return CompanyParticipantList.of(companyName, sortedParticipants);
			})
			.collect(Collectors.toList());
		// List<CompanyParticipantList> result = participantList.parallelStream()
		// 	.collect(Collectors.groupingBy(Participant::getCompany))
		// 	.entrySet().parallelStream()  // 전체 스트림에 parallel()을 사용
		// 	.map(entry -> {
		// 		String companyName = entry.getKey();
		// 		List<Participant> sortedParticipants = entry.getValue().parallelStream()  // 각 그룹에 대한 스트림에 parallel()을 사용
		// 			.sorted(Comparator.comparing(Participant::getCreatedAt))
		// 			.collect(Collectors.toList());
		// 		return CompanyParticipantList.of(companyName, sortedParticipants);
		// 	})
		// 	.collect(Collectors.toList());

		long end = System.currentTimeMillis();
		log.info("[stream] elapsed time: {}", end - start);
		 return StreamResponse.of(result);
	}

	public StreamResponse getListByForLoop() {
		List<Participant> participantList = demoRepository.findAllByPosition("software engineer");

		long start = System.currentTimeMillis();
		Map<String, List<Participant>> companyMap = new HashMap<>();
		for (Participant participant : participantList) {
			companyMap.computeIfAbsent(participant.getCompany(), key -> new ArrayList<>()).add(participant);
		}

		List<CompanyParticipantList> result = new ArrayList<>();
		for (Map.Entry<String, List<Participant>> entry : companyMap.entrySet()) {
			String companyName = entry.getKey();
			List<Participant> sortedParticipants = new ArrayList<>(entry.getValue());
			Collections.sort(sortedParticipants, Comparator.comparing(Participant::getCreatedAt));
			result.add(CompanyParticipantList.of(companyName, sortedParticipants));
		}

		long end = System.currentTimeMillis();
		log.info("[for-loop] elapsed time: {}", end - start);
		return StreamResponse.of(result);
	}

	public StreamResponse getListByQuery() {
		return demoEMRepository.getParticipantList();
	}
}

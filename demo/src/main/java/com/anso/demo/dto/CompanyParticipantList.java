package com.anso.demo.dto;

import java.util.List;

import com.anso.demo.entity.Participant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CompanyParticipantList {
	private final String companyName;
	private final List<Participant> participantList;

	public static CompanyParticipantList of(String companyName, List<Participant> participantList) {
		return new CompanyParticipantList(companyName, participantList);
	}
}

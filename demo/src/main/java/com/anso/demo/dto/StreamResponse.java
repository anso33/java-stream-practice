package com.anso.demo.dto;


import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StreamResponse {
	private final List<CompanyParticipantList> companyParticipantList;

	public static StreamResponse of(List<CompanyParticipantList> companyParticipantList) {
		return new StreamResponse(companyParticipantList);
	}
}

package com.anso.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.anso.demo.dto.CompanyParticipantList;
import com.anso.demo.dto.StreamResponse;
import com.anso.demo.entity.Participant;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class DemoEMRepository {


		@PersistenceContext
		private EntityManager entityManager;

		public StreamResponse getCompanyParticipantList() {
			// 1. 데이터베이스에서 company 목록을 조회하는 native query
			Query companyQuery = entityManager.createNativeQuery("SELECT DISTINCT company FROM participant");
			List<String> companyList = companyQuery.getResultList();

			// 2. 각 company 별로 Software Engineer를 그룹화하고 정렬하여 StreamResponse를 생성
			List<CompanyParticipantList> result = companyList.stream()
				.map(company -> {
					String nativeQueryString = "SELECT * FROM participant " +
						"WHERE position = 'software engineer' AND company = :company " +
						"ORDER BY created_at";
					Query participantQuery = entityManager.createNativeQuery(nativeQueryString, Participant.class);
					participantQuery.setParameter("company", company);

					@SuppressWarnings("unchecked")
					List<Participant> softwareEngineers = participantQuery.getResultList();
					return CompanyParticipantList.of(company, softwareEngineers);
				})
				.collect(Collectors.toList());

			return StreamResponse.of(result);
		}

	public StreamResponse getParticipantList() {
		Query companyQuery = entityManager.createNativeQuery("SELECT DISTINCT company FROM participant");
		List<String> companyList = companyQuery.getResultList();

		List<CompanyParticipantList> result = new ArrayList<>();
		for (String company : companyList) {
			String nativeQueryString = "SELECT * FROM participant " +
				"WHERE position = 'software engineer' AND company = :company " +
				"ORDER BY created_at";
			Query participantQuery = entityManager.createNativeQuery(nativeQueryString, Participant.class);
			participantQuery.setParameter("company", company);

			@SuppressWarnings("unchecked")
			List<Participant> softwareEngineers = participantQuery.getResultList();
			result.add(CompanyParticipantList.of(company, softwareEngineers));
		}

		return StreamResponse.of(result);
	}
}

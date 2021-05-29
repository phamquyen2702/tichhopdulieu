package com.project.group14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.group14.document.JobInfo;
import com.project.group14.repository.CustomRP;
import com.project.group14.repository.JobInfoRepository;

@Service
public class JobService {

	@Autowired
	private JobInfoRepository jobInfoRepository;

	@Autowired
	private CustomRP customRP;

	public List<JobInfo> findPage(int start, int offset) {
		return jobInfoRepository.findAll(PageRequest.of(start, offset)).getContent();
	}

	public List<JobInfo> findAll() {
		return jobInfoRepository.findAll();
	}

	public List<JobInfo> findById(String id) {
		return jobInfoRepository.findById(id);
	}

//	public List<JobInfo> findBy3Criteria(String criteria1, String criteria2, String criteria3, String value1,
//			String value2, String value3, int start, int offset) {
//		return customRP.findBy3Criteria(criteria1, criteria2, criteria3, value1, value2, value3, start, offset);
//
//	}

	public List<JobInfo> findBy3Criteria(String value1, String value2, String value3, int start, int offset) {
		return customRP.findBy3Criteria(value1, value2, value3, start, offset);

	}

	public List<JobInfo> findJobName(String jobName) {
		return jobInfoRepository.findByJobName(jobName);

	}

	public int count(String criteria1, String criteria2, String criteria3, String value1, String value2,
			String value3) {
		return customRP.count3Criteria(criteria1, criteria2, criteria3, value1, value2, value3);
	}

//	public List<String> findAllTypeJob() {
//		return jobInfoRepository.findAll();
//	}

}

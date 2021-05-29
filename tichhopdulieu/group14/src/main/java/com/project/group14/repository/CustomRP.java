package com.project.group14.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.project.group14.document.JobInfo;

@Repository
public class CustomRP {

	@Autowired
	MongoTemplate mongoTemplate;

	public List<JobInfo> findByCriteria(String criteria, String value, int start, int offset) {
		Query query = new Query();
		query.addCriteria(Criteria.where(criteria).regex(value)).limit(offset).skip(start);
		List<JobInfo> list = mongoTemplate.find(query, JobInfo.class);
		return list;
	}

	public List<JobInfo> findBy2Criteria(String criteria1, String criteria2, String value1, String value2, int start,
			int offset) {
		Query query = new Query();
		query.addCriteria(Criteria.where(criteria1).regex(value1));
		query.addCriteria(Criteria.where(criteria2).regex(value2));
		query.limit(offset).skip(start);
		List<JobInfo> list = mongoTemplate.find(query, JobInfo.class);
		return list;
	}

	public List<JobInfo> findBy3Criteria(String value1, String value2, String value3, int start, int offset) {
		Query query = new Query();
		query.addCriteria(Criteria.where("Company_Name").regex(value1));
		query.addCriteria(Criteria.where("Address").regex(value2));
		query.addCriteria(Criteria.where("Type_Job").regex(value3));
		query.limit(offset).skip(start);
		List<JobInfo> list = mongoTemplate.find(query, JobInfo.class);
		return list;
	}

	public int count3Criteria(String criteria1, String criteria2, String criteria3, String value1, String value2,
			String value3) {
		Query query = new Query();
		query.addCriteria(Criteria.where(criteria1).regex(value1));
		query.addCriteria(Criteria.where(criteria2).regex(value2));
		query.addCriteria(Criteria.where(criteria3).regex(value3));
		List<JobInfo> list = mongoTemplate.find(query, JobInfo.class);
		return list.size();
	}
//	public List<String> getAllTypeJob() {
//		Query query = new Query();
//		query.addCriteria(Criteria.where("Company_Name").);
//		
//		List<JobInfo> list = mongoTemplate.find(query, JobInfo.class);
//		return list;
//	}
}

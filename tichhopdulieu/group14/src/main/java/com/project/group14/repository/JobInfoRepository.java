package com.project.group14.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.group14.document.JobInfo;

@Repository
public interface JobInfoRepository extends MongoRepository<JobInfo, Long>{
	
	
	List<JobInfo> findById(String id);
	@Query("{Address:/?0/}")
	List<JobInfo> findByAddress(String jobName);
	
	@Query("{Job_Name:/?0/}")
	List<JobInfo> findByJobName(String jobName);
	
	@Query("{Company_Name:/?0/}")
	List<JobInfo> findByCompanyName(String companyName);
	
	@Query("{Job_Kind:/?0/}")
	List<JobInfo> findByJobKind(String jobKind);
	
	@Query("{Salary:/?0/}")
	List<JobInfo> findBySalary(String salary);
	
	@Query("{Level:/?0/}")
	List<JobInfo> findByLevel(String level);
	
}

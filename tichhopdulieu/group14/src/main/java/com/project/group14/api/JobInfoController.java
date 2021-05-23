package com.project.group14.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.group14.document.JobInfo;
import com.project.group14.service.JobService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class JobInfoController {

	@Autowired
	private JobService jobService;

	@GetMapping("/jobs")
	public List<JobInfo> getAllJobInfo() {
		return jobService.findAll();

	}

	@GetMapping("/page")
	public List<JobInfo> getPage(@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "offset", required = false) int offset) {
		return jobService.findPage(start, offset);

	}

	@GetMapping("/job")
	public List<JobInfo> getJobInfo(@RequestParam(value = "id", required = false) String id) {
		return jobService.findById(id);

	}

	@GetMapping("/criteria")
	public List<JobInfo> findByCriteria(@RequestParam(value = "filter", required = false) String criteria,
			@RequestParam(value = "value", required = false) String value,
			@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "offset", required = false) int offset) {
		return jobService.findByCriteria(criteria, value, start, offset);

	}

	@GetMapping("/criteria2")
	public List<JobInfo> findBy2Criteria(@RequestParam(value = "filter1", required = false) String criteria1,
			@RequestParam(value = "filter2", required = false) String criteria2,
			@RequestParam(value = "value1", required = false) String value1,
			@RequestParam(value = "value2", required = false) String value2,
			@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "offset", required = false) int offset) {
		return jobService.findBy2Criteria(criteria1, criteria2, value1, value2, start, offset);

	}

	@GetMapping("/criteria3")
	public List<JobInfo> findBy3Criteria(@RequestParam(value = "filter1", required = false) String criteria1,
			@RequestParam(value = "filter2", required = false) String criteria2,
			@RequestParam(value = "filter3", required = false) String criteria3,
			@RequestParam(value = "value1", required = false) String value1,
			@RequestParam(value = "value2", required = false) String value2,
			@RequestParam(value = "value3", required = false) String value3,
			@RequestParam(value = "start", required = false) int start,
			@RequestParam(value = "offset", required = false) int offset) {
		return jobService.findBy3Criteria(criteria1, criteria2, criteria3, value1, value2, value3, start, offset);

	}
}

package com.project.group14.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/job/{id}")
	public List<JobInfo> getJobInfo(@PathVariable("id") String id) {
		return jobService.findById(id);

	}

	@GetMapping("/filter")
	public List<JobInfo> filter(@RequestParam(value = "CompanyName", required = false) String value1,
			@RequestParam(value = "Address", required = false) String value2,
			@RequestParam(value = "TypeJob", required = false) String value3,
			@RequestParam(value = "start", required = false) Integer start,
			@RequestParam(value = "offset", required = false) Integer offset) {
		return jobService.findBy3Criteria(value1, value2, value3, start, offset);

	}

	@GetMapping("/count")
	public int count(@RequestParam(value = "CompanyName", required = false) String value1,
			@RequestParam(value = "Address", required = false) String value2,
			@RequestParam(value = "TypeJob", required = false) String value3) {
		return jobService.count("Company_Name", "Address", "Type_Job", value1, value2, value3);

	}
}

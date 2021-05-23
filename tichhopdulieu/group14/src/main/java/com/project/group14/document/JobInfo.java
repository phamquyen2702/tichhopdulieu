package com.project.group14.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "job")
public class JobInfo {

	@Id
	private String id;

	private String Job_Name;

	private String Company_Name;

	private String Address;

	private String[] Salary;

	private String Level;

	private String Form;

	private String Deadline;

	private String[] Describe;

	private String[] Requirement;

	private String[] Type_Job;

	public JobInfo() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJob_Name() {
		return Job_Name;
	}

	public void setJob_Name(String job_Name) {
		Job_Name = job_Name;
	}

	public String getCompany_Name() {
		return Company_Name;
	}

	public void setCompany_Name(String company_Name) {
		Company_Name = company_Name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String[] getSalary() {
		return Salary;
	}

	public void setSalary(String[] salary) {
		Salary = salary;
	}

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}

	public String getForm() {
		return Form;
	}

	public void setForm(String form) {
		Form = form;
	}

	public String getDeadline() {
		return Deadline;
	}

	public void setDeadline(String deadline) {
		Deadline = deadline;
	}

	public String[] getDescribe() {
		return Describe;
	}

	public void setDescribe(String[] describe) {
		Describe = describe;
	}

	public String[] getRequirement() {
		return Requirement;
	}

	public void setRequirement(String[] requirement) {
		Requirement = requirement;
	}

	public String[] getType_Job() {
		return Type_Job;
	}

	public void setType_Job(String[] type_Job) {
		Type_Job = type_Job;
	}

	public JobInfo(String id, String job_Name, String company_Name, String address, String[] salary, String level,
			String form, String deadline, String[] describe, String[] requirement, String[] type_Job) {
		super();
		this.id = id;
		Job_Name = job_Name;
		Company_Name = company_Name;
		Address = address;
		Salary = salary;
		Level = level;
		Form = form;
		Deadline = deadline;
		Describe = describe;
		Requirement = requirement;
		Type_Job = type_Job;
	}

}

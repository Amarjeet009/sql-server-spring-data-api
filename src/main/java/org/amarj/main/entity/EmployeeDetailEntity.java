package org.amarj.main.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details", schema = "empl")
public class EmployeeDetailEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "emp_address")
	private String address;
	
	@Column(name = "contact_num")
	private String contactNumber;
	
	@Column(name = "salary")
	private Float salary;
	
	@Column(name = "join_at")
	private Date joinAt;
	

    @Column(name = "emp_id")
    private Integer empId;
	

	public EmployeeDetailEntity() {
		// TODO Auto-generated constructor stub
	}
	
	

	public EmployeeDetailEntity(Integer id, String firstName, String lastName, String emailId, String address,
			String contactNumber, Float salary, Date joinAt, EmployeeSignupEntity employeeSignupEntity) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
		this.contactNumber = contactNumber;
		this.salary = salary;
		this.joinAt = joinAt;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Date getJoinAt() {
		return joinAt;
	}

	public void setJoinAt(Date joinAt) {
		this.joinAt = joinAt;
	}



	public Integer getEmpId() {
		return empId;
	}



	public void setEmpId(Integer empId) {
		this.empId = empId;
	}



	@Override
	public String toString() {
		return "EmployeeDetailEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + ", address=" + address + ", contactNumber=" + contactNumber + ", salary=" + salary
				+ ", joinAt=" + joinAt + ", empId=" + empId + "]";
	}

	

	
	

	
}

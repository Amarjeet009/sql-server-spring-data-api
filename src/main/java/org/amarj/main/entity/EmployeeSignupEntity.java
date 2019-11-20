package org.amarj.main.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employee_signup", schema = "empl")
public class EmployeeSignupEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    
    @Column(name = "email_id")
    private String emailId;
    
    @Column(name = "emp_password")
    private String password;
    
    @Column(name = "emp_conf_password")
    private String emp_conf_password;
    
	
	public EmployeeSignupEntity() {
		// TODO Auto-generated constructor stub
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmp_conf_password() {
		return emp_conf_password;
	}

	public void setEmp_conf_password(String emp_conf_password) {
		this.emp_conf_password = emp_conf_password;
	}

	@Override
	public String toString() {
		return "Employee_Signup [empId=" + empId + ", emailId=" + emailId + ", password=" + password
				+ ", emp_conf_password=" + emp_conf_password + "]";
	}

	
}

package org.amarj.main.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.amarj.main.entity.EmployeeDetailEntity;
import org.amarj.main.entity.EmployeeSignupEntity;
import org.amarj.main.exception.ResourceNotFoundException;
import org.amarj.main.repository.EmployeeDetailRepository;
import org.amarj.main.repository.EmployeeSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeDetailController {

	public EmployeeDetailController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private EmployeeDetailRepository employeeDetailRepository;

	@Autowired
	private EmployeeSignupRepository EmployeeSignupRepository;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String getTestMethod() {
		return "Love Coding! Go Ahead To Create Something New..ATB";
	}

	@RequestMapping(value = "/createNewEmpSignup", method = RequestMethod.POST, consumes = {
			"application/json" }, produces = { "application/json" })
	@ResponseBody
	public EmployeeSignupEntity createNewEmployeeSignUp(@Valid @RequestBody EmployeeSignupEntity employee) {
		return EmployeeSignupRepository.save(employee);
	}

	@RequestMapping(value = "/listOfEmp", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<EmployeeDetailEntity> getAllEmployees() {
		return employeeDetailRepository.findAll();
	}

	@RequestMapping(value = "/createEmpDetails", method = RequestMethod.POST, consumes = {
			"application/json" }, produces = { "application/json" })
	@ResponseBody
	public EmployeeDetailEntity createEmployee(@Valid @RequestBody EmployeeDetailEntity employee) {
		employee.setJoinAt(new Date());
		return employeeDetailRepository.save(employee);
	}

	@RequestMapping(value = "/empData/{id}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<EmployeeDetailEntity> getEmployeeById(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		EmployeeDetailEntity employee = employeeDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return ResponseEntity.ok().body(employee);
	}

	@RequestMapping(value = "/empUpdateData/{id}", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public ResponseEntity<EmployeeDetailEntity> updateEmployee(@PathVariable(value = "id") Integer id,
			@Valid @RequestBody EmployeeDetailEntity employeeDetails) throws ResourceNotFoundException {
		EmployeeDetailEntity employee = employeeDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setContactNumber(employeeDetails.getContactNumber());
		employee.setAddress(employeeDetails.getAddress());
		final EmployeeDetailEntity updatedEmployee = employeeDetailRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@RequestMapping(value = "/empDelete/{id}", method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id)
			throws ResourceNotFoundException {
		EmployeeDetailEntity employee = employeeDetailRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

		employeeDetailRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}

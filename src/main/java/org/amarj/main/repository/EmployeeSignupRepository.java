package org.amarj.main.repository;


import org.amarj.main.entity.EmployeeSignupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeSignupRepository  extends JpaRepository<EmployeeSignupEntity, Integer> {

}

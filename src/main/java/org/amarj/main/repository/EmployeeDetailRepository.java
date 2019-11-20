package org.amarj.main.repository;

import org.amarj.main.entity.EmployeeDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetailEntity, Integer> {

}

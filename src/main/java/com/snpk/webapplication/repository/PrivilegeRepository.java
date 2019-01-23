package com.snpk.webapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.snpk.webapplication.model.Privilege;

@Repository("privilegeRepository")
public interface PrivilegeRepository extends JpaRepository<Privilege,Long>{
    public Privilege findByName(String name);
}

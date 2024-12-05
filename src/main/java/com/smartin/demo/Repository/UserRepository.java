package com.smartin.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartin.demo.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}

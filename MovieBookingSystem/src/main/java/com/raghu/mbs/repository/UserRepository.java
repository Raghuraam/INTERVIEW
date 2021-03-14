package com.raghu.mbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raghu.mbs.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}

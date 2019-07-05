package com.st.websiteProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.st.websiteProject.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	public List<User> findAll();
	public User findUserById(Long id);
	public User findByfName(String fName);
	public User findBylName(String lName);
}

package com.machine.test.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.machine.test.crud.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	@Query("SELECT catg FROM Category catg WHERE catg.catgName = :ctname")
	public Category findByCatgName(@Param("ctname") String name);
	
}

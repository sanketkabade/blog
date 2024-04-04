package com.blogg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloggRepo extends JpaRepository<Blogging, Integer> {	

}

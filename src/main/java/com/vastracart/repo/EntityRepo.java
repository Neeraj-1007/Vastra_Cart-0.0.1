package com.vastracart.repo;

import com.vastracart.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepo extends JpaRepository<Test,Long> {
}

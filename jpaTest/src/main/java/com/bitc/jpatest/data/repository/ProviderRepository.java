package com.bitc.jpatest.data.repository;

import com.bitc.jpatest.data.entity.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<ProviderEntity, Long> {
}

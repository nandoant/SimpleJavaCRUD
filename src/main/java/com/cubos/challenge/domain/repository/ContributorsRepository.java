package com.cubos.challenge.domain.repository;

import com.cubos.challenge.domain.model.Contributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorsRepository extends JpaRepository<Contributors, Long> {
}

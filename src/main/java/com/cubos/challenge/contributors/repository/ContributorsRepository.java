package com.cubos.challenge.contributors.repository;

import com.cubos.challenge.contributors.domain.Contributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributorsRepository extends JpaRepository<Contributors, Long> {
}

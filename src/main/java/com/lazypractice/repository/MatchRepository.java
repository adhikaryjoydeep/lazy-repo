package com.lazypractice.repository;

import com.lazypractice.beans.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MatchRepository extends JpaRepository<Match,Long> {
    public Match findMatchById(Long id);
    public List<Match> findByCity(String city);
}

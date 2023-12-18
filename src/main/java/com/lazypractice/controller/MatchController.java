package com.lazypractice.controller;

import com.lazypractice.beans.Match;
import com.lazypractice.repository.MatchRepository;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import java.util.List;
import java.util.Set;

@RestController
public class MatchController {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private EntityManager entityManager;

    public MatchController(){}

    public MatchController(EntityManager entityManager,MatchRepository matchRepository){
        this.entityManager = entityManager;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/matches/{id}")
    public Match getMatchDetail(@PathVariable Long id){
        return this.matchRepository.findMatchById(id);
    }

    @GetMapping("/matches/all")
    public Iterable<Match> getAllMatches(){
        return this.matchRepository.findAll();
    }

    @GetMapping("/matches/city/{cityName}")
    public List<Match> getMatchByCity(@PathVariable String cityName){
        return this.matchRepository.findByCity(cityName);
    }

    @GetMapping("/matches/city/{cityName}/{id}")
    public Match getMatchByCityAndId(@PathVariable String cityName,@PathVariable Long id){
        CriteriaQuery<Match> cq = entityManager.getCriteriaBuilder().createQuery(Match.class);
        Root<Match> root = cq.from(Match.class);
        Predicate cityPredicate = entityManager.getCriteriaBuilder().equal(root.get("city"),cityName);
        Predicate idPredicate = entityManager.getCriteriaBuilder().equal(root.get("id"),id);
        cq.where(cityPredicate,idPredicate);
        return entityManager.createQuery(cq).getSingleResult();
    }

    @PatchMapping("/matches/city/{cityName}/{id}")
    public ResponseEntity<Match> patchMatchData(@PathVariable Long id, @RequestBody Match matchInput){
        Match match = matchRepository.findMatchById(matchInput.getId());
        match.setCity(matchInput.getCity());
        match.setDate(matchInput.getDate());
        matchRepository.save(match);
        return ResponseEntity.ok(match);
    }

}

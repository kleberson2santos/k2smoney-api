package com.example.k2smoney.api.repository;

import com.example.k2smoney.api.model.LancamentoCielo;
import com.example.k2smoney.api.repository.lancamentocielo.LancamentoCieloRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoCieloRepository extends JpaRepository<LancamentoCielo, Long>, LancamentoCieloRepositoryQuery {


}

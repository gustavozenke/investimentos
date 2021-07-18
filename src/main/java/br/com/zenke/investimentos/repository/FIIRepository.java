package br.com.zenke.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zenke.investimentos.models.Fii;

@Repository
public interface FIIRepository  extends JpaRepository<Fii, String>{ }

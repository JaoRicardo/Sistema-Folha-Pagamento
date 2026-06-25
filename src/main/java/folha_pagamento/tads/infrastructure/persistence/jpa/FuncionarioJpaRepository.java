package folha_pagamento.tads.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioJpaRepository extends JpaRepository<FuncionarioJpaEntity, Long> {
    Optional<FuncionarioJpaEntity> findByNome(String nome);
}

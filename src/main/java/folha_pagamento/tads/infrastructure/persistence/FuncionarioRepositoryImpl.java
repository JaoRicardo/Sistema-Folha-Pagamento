package folha_pagamento.tads.infrastructure.persistence;

import folha_pagamento.tads.domain.entity.Funcionario;
import folha_pagamento.tads.domain.repository.FuncionarioRepository;
import folha_pagamento.tads.domain.valueobject.Dinheiro;
import folha_pagamento.tads.domain.valueobject.Nome;
import folha_pagamento.tads.infrastructure.contrato.ContratoPJ;
import folha_pagamento.tads.infrastructure.persistence.jpa.FuncionarioJpaEntity;
import folha_pagamento.tads.infrastructure.persistence.jpa.FuncionarioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final FuncionarioJpaRepository jpaRepository;

    public FuncionarioRepositoryImpl(FuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Funcionario salvar(Funcionario funcionario) {
        String tipoContrato = "PJ"; // Mock
        if (funcionario.getContrato() != null) {
            tipoContrato = funcionario.getContrato().getClass().getSimpleName();
        }

        FuncionarioJpaEntity entity = new FuncionarioJpaEntity(
                funcionario.getId(),
                funcionario.getNome().getValor(),
                tipoContrato
        );

        FuncionarioJpaEntity salvo = jpaRepository.save(entity);
        return toDomain(salvo);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Funcionario> buscarPorNome(String nome) {
        return jpaRepository.findByNome(nome).map(this::toDomain);
    }

    private Funcionario toDomain(FuncionarioJpaEntity entity) {
        // Mock
        ContratoPJ contratoMock = new ContratoPJ(new Nome("Consultor " + entity.getTipoContrato()), new Dinheiro(100));
        return new Funcionario(entity.getId(), new Nome(entity.getNome()), contratoMock);
    }
}

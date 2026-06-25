package folha_pagamento.tads.domain.repository;

import folha_pagamento.tads.domain.entity.Funcionario;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {
    Funcionario salvar(Funcionario funcionario);
    List<Funcionario> listarTodos();
    Optional<Funcionario> buscarPorNome(String nome);
}

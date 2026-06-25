package folha_pagamento.tads.interfaces.web;

import folha_pagamento.tads.domain.entity.Funcionario;
import folha_pagamento.tads.domain.repository.FuncionarioRepository;
import folha_pagamento.tads.domain.valueobject.Dinheiro;
import folha_pagamento.tads.domain.valueobject.Nome;
import folha_pagamento.tads.infrastructure.contrato.ContratoPJ;
import folha_pagamento.tads.interfaces.web.dto.FuncionarioRequest;
import folha_pagamento.tads.interfaces.web.dto.FuncionarioResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> criar(@RequestBody FuncionarioRequest request) {
        // Mock
        ContratoPJ contrato = new ContratoPJ(new Nome("Especialista"), new Dinheiro(150));
        Funcionario funcionario = new Funcionario(new Nome(request.nome()), contrato);
        
        Funcionario salvo = funcionarioRepository.salvar(funcionario);
        return ResponseEntity.ok(FuncionarioResponse.de(salvo));
    }

    @GetMapping
    public List<FuncionarioResponse> listar() {
        return funcionarioRepository.listarTodos().stream()
                .map(FuncionarioResponse::de)
                .collect(Collectors.toList());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<FuncionarioResponse> buscarPorNome(@PathVariable String nome) {
        return funcionarioRepository.buscarPorNome(nome)
                .map(FuncionarioResponse::de)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

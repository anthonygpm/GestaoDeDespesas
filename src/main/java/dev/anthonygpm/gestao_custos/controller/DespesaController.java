package dev.anthonygpm.gestao_custos.controller;

import dev.anthonygpm.gestao_custos.custom_messages.ErrorMessage;
import dev.anthonygpm.gestao_custos.model.Despesa;
import dev.anthonygpm.gestao_custos.service.DespesaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaService;

    @GetMapping
    public List<Despesa> listar() {
        return despesaService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Despesa despesa) {

        try {
            var result = despesaService.create(despesa);
            return ResponseEntity.ok(result);
        }
        catch (IllegalArgumentException e) {
            var errorMessage = new ErrorMessage(e.getMessage(), "INVALID_INPUT");
            return ResponseEntity.badRequest().body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        despesaService.deleteById(java.util.UUID.fromString(id));
    }

    @GetMapping("/{email}")
    public List<Despesa> findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate data) {
        return despesaService.findByEmailAndDate(email, data);
    }

}

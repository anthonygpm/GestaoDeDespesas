package dev.anthonygpm.gestao_custos.service;

import dev.anthonygpm.gestao_custos.model.Despesa;
import dev.anthonygpm.gestao_custos.repository.DespesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DespesaService {

    private final DespesaRepository despesaRepository;

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public Despesa create(Despesa despesa) {

        if (despesa.getData() == null || despesa.getCategoria() == null || despesa.getDescricao() == null || despesa.getEmail() == null) {
            throw new IllegalArgumentException("Preencha todos os campos.");
        }

        return despesaRepository.save(despesa);
    }

    public void deleteById(UUID id) {
        despesaRepository.deleteById(id);
    }

    public List<Despesa> findByEmailAndDate(String email, LocalDate data) {

        List<Despesa> despesas;

        if (data != null) {
            despesas = despesaRepository.findByEmailAndData(email, data);
        } else {
            despesas = despesaRepository.findByEmail(email);
        }
        return despesas;
    }
}

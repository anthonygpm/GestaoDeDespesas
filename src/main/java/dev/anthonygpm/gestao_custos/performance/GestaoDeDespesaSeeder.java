package dev.anthonygpm.gestao_custos.performance;

import dev.anthonygpm.gestao_custos.model.Despesa;
import dev.anthonygpm.gestao_custos.repository.DespesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Component
@AllArgsConstructor
public class GestaoDeDespesaSeeder implements CommandLineRunner {

    private final DespesaRepository despesaRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Despesa> despesas = new ArrayList<>();
        System.out.println("Iniciando o seeding de despesas para teste de performance...");

        for (int i = 0; i < 150000; i++) {
            Despesa despesa = new Despesa();
            despesa.setDescricao("Despesa " + i);
            despesa.setValor(BigDecimal.valueOf(10 + (i % 50)));
            despesa.setData(LocalDate.now().minusDays(i % 30));
            despesa.setCategoria("TESTE");
            despesa.setEmail("performance@gmail.com");

            despesas.add(despesa);
        }

        despesaRepository.saveAll(despesas);
        System.out.println("Finalizando o seeding de despesas para teste de performance...");
    }
}

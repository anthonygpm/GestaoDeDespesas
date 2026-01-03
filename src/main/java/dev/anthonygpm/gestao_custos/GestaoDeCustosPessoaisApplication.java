package dev.anthonygpm.gestao_custos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching
public class GestaoDeCustosPessoaisApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeCustosPessoaisApplication.class, args);
	}

}

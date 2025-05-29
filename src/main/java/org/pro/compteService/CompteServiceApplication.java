package org.pro.compteService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.pro.compteService.enums.TypeCompte;
import org.pro.compteService.repositories.CompteRepository;
import org.pro.compteService.entities.Compte;
import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);

	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			compteRepository.save(new Compte(null, 23000, new Date(), TypeCompte.CURRENT));
			compteRepository.save(new Compte(null, 45900, new Date(), TypeCompte.SAVING));
			compteRepository.save(new Compte(null, 23900, new Date(), TypeCompte.CURRENT));

			compteRepository.findAll().forEach(cp -> {
				System.out.println(cp.getType());
				System.out.println(cp.getSaldo());
			});
		};
	}

}

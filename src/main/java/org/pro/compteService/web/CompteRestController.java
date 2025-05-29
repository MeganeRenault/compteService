package org.pro.compteService.web;

import org.pro.compteService.repositories.CompteRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.pro.compteService.entities.Compte;

@RestController
public class CompteRestController {

    private CompteRepository compteRepository;

    public CompteRestController(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @GetMapping(path = "/comptes")
    public List<Compte> listComptes() {
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte getCompte(@PathVariable(name = "id") Long code) {
        return compteRepository.findById(code).get();
    }

    @PostMapping(path = "/comptes")
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping(path = "/comptes/{code}")
    public Compte updateCompte(@PathVariable Long code, @RequestBody Compte compte) {
        compte.setCode(code);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{code}")
    public void deleteCompte(@PathVariable Long code) {
        compteRepository.deleteById(code);
    }
}
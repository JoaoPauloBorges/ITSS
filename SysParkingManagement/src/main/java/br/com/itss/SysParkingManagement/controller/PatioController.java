package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.exception.ResourceNotFoundException;
import br.com.itss.SysParkingManagement.model.Patio;
import br.com.itss.SysParkingManagement.repository.PatioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PatioController {

    private PatioRepository patioRepository;

    public PatioController(PatioRepository patioRepository) {
        this.patioRepository = patioRepository;
    }

    @GetMapping("/patios")
    public Page<Patio> getPatios(Pageable pageable) {
        return patioRepository.findAll(pageable);
    }

    @PostMapping("/patios")
    public Patio createPatio(@Valid @RequestBody Patio patio) {
        return patioRepository.save(patio);
    }

    @GetMapping("/patios/{id}")
    public Patio getPatio(@PathVariable Long id) {
        return patioRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Patio with id " + id + "not found")
                );
    }

    @PutMapping("/patios/{id}")
    public Patio updatePatio(@PathVariable Long id,
                                   @Valid @RequestBody Patio patioRequest) throws ResourceNotFoundException {
        return patioRepository.findById(id)
                .map(patio -> {
                    patio.setDescription(patioRequest.getDescription());
                    patio.setVacanciesNumber(patioRequest.getVacanciesNumber());
                    patio.setRateHour(patioRequest.getRateHour());
                    return patioRepository.save(patio);
                }).orElseThrow(() -> new ResourceNotFoundException("Patio with id " + id + "not found"));
    }

    @DeleteMapping("/patios/{id}")
    public ResponseEntity<?> deletePatio(@PathVariable Long id) throws ResourceNotFoundException {
        return patioRepository.findById(id)
                .map(question -> {
                    patioRepository.delete(question);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Patio with id " + id + "not found"));
    }


}

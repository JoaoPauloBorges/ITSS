package br.com.itss.SysParkingManagement.repository;

import br.com.itss.SysParkingManagement.model.Patio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatioRepository extends JpaRepository<Patio, Long> {
}

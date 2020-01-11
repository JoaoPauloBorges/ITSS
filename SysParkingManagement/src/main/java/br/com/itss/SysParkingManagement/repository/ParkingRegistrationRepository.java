package br.com.itss.SysParkingManagement.repository;

import br.com.itss.SysParkingManagement.model.ParkingRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRegistrationRepository extends JpaRepository<ParkingRegistration, Long> {

    List<ParkingRegistration> findByPatioId(Long patioId);
    Optional<List<ParkingRegistration>> findByVehicleIdAndPatioId(Long vehicleId, Long patioId);
    Optional<ParkingRegistration> findByVehicleIdAndPatioIdAndId(Long vehicleId, Long patioId, Long parkingId);
}

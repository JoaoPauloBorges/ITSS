package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.exception.ResourceNotFoundException;
import br.com.itss.SysParkingManagement.model.ParkingRegistration;
import br.com.itss.SysParkingManagement.repository.ParkingRegistrationRepository;
import br.com.itss.SysParkingManagement.repository.PatioRepository;
import br.com.itss.SysParkingManagement.repository.VehicleRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ParkingRegistrationController {

    private ParkingRegistrationRepository parkingRepository;
    private PatioRepository patioRepository;
    private VehicleRepository vehicleRepository;

    public ParkingRegistrationController(
            ParkingRegistrationRepository parkingRepository,
            PatioRepository patioRepository,
            VehicleRepository vehicleRepository) throws ResourceNotFoundException {

        this.parkingRepository = parkingRepository;
        this.patioRepository = patioRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/patios/{patioId}/vehicles/{vehicleId}")
    public List<ParkingRegistration> getParkingRegistrations(
            @PathVariable Long patioId,
            @PathVariable Long vehicleId
    ) {
        return parkingRepository.findByVehicleIdAndPatioId(patioId, vehicleId)
                .orElseThrow(() -> new ResourceNotFoundException("Registrations not found with patio_id and vehicle_id " + patioId + ", " + vehicleId));
    }

    @PostMapping("/patios/{patioId}/vehicles/{vehicleId}")
    public ParkingRegistration registerParking(
            @PathVariable Long patioId,
            @PathVariable Long vehicleId,
            @Valid @RequestBody ParkingRegistration parkingRegistration) throws ResourceNotFoundException {

        return patioRepository.findById(patioId)
                .map(patio -> vehicleRepository.findById(vehicleId)
                        .map(vehicle -> {
                            parkingRegistration.setVehicle(vehicle);
                            parkingRegistration.setPatio(patio);
                            return parkingRepository.save(parkingRegistration);
                        })
                        .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + vehicleId)))
                .orElseThrow(() -> new ResourceNotFoundException("Patio not found with id " + patioId));
    }

    @PutMapping("/patios/{patioId}/vehicles/{vehicleId}/parking/{parkingId}")
    public ParkingRegistration registerParkingExit(
            @PathVariable Long patioId,
            @PathVariable Long vehicleId,
            @PathVariable Long parkingId,
            @Valid @RequestBody ParkingRegistration parkingRegistration) throws ResourceNotFoundException {

        return parkingRepository.findByVehicleIdAndPatioIdAndId(vehicleId, patioId, parkingId)
                .map(parking -> {
                            parking.setExitTime(parkingRegistration.getExitTime());
                            parking.setAmountToBePaid(parkingRegistration.getAmountToBePaid());
                            return parkingRepository.save(parking);
                        }
                )
                .orElseThrow(() -> new ResourceNotFoundException("Parking Registration not found with id " + parkingId));
    }

    @GetMapping("/patios/{patioId}/vehicles/{vehicleId}/parking/{parkingId}")
    public ParkingRegistration getParkingRegistration(
            @PathVariable Long patioId,
            @PathVariable Long vehicleId,
            @PathVariable Long parkingId
    ) {
        return parkingRepository.findByVehicleIdAndPatioIdAndId(vehicleId, patioId, parkingId)
                .orElseThrow(() -> new ResourceNotFoundException("Parking Registration not found with id " + parkingId));
    }

    @GetMapping("/patios/{patioId}/parking")
    public List<ParkingRegistration> getParkingRegistrationsByPatioId(@PathVariable Long patioId) {
        return patioRepository.findById(patioId)
                .map(patio -> parkingRepository.findByPatioId(patioId))
                .orElseThrow(() -> new ResourceNotFoundException("Patio not found with id " + patioId));
    }
}

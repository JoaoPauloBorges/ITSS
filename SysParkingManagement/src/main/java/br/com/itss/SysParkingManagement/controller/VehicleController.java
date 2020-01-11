package br.com.itss.SysParkingManagement.controller;

import br.com.itss.SysParkingManagement.exception.ResourceNotFoundException;
import br.com.itss.SysParkingManagement.model.Vehicle;
import br.com.itss.SysParkingManagement.repository.CustomerRepository;
import br.com.itss.SysParkingManagement.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class VehicleController {

    private VehicleRepository vehicleRepository;
    private CustomerRepository customerRepository;

    public VehicleController(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/{customerId}/vehicles")
    public List<Vehicle> getVehiclesByCustomerId(@PathVariable Long customerId) {
        return vehicleRepository.findByCustomerId(customerId);
    }

    @PostMapping("/customers/{customerId}/vehicles")
    public Vehicle addVehicle(@PathVariable Long customerId,
                              @Valid @RequestBody Vehicle vehicle) throws ResourceNotFoundException {
        return customerRepository.findById(customerId)
                .map(customer -> {
                    vehicle.setCustomer(customer);
                    return vehicleRepository.save(vehicle);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));
    }

    @PutMapping("/customers/{customerId}/vehicles/{vehicleId}")
    public Vehicle updateVehicle(@PathVariable Long customerId,
                                 @PathVariable Long vehicleId,
                                 @Valid @RequestBody Vehicle vehicleRequest) throws ResourceNotFoundException {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer not found with id " + customerId);
        }

        return vehicleRepository.findById(vehicleId)
                .map(vehicle -> {
                    vehicle.setLicensePlate(vehicleRequest.getLicensePlate());
                    vehicle.setModel(vehicleRequest.getModel());
                    vehicle.setColor(vehicleRequest.getColor());
                    return vehicleRepository.save(vehicle);
                }).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + vehicleId));
    }

    @DeleteMapping("/customers/{customerId}/vehicles/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long customerId,
                                           @PathVariable Long vehicleId) throws ResourceNotFoundException {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer not found with id " + customerId);
        }

        return vehicleRepository.findById(vehicleId)
                .map(vehicle -> {
                    vehicleRepository.delete(vehicle);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id " + vehicleId));

    }


}

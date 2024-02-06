package examen.examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import examen.examen.Model.Vehicle;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAll();
}

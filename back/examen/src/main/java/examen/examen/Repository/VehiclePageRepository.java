package examen.examen.Repository;

import examen.examen.Model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VehiclePageRepository extends PagingAndSortingRepository<Vehicle, Long> {
}

package examen.examen.Service;

import examen.examen.Repository.VehiclePageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import examen.examen.Model.Vehicle;
import examen.examen.Repository.VehicleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository repo;

    private final VehiclePageRepository repository;

    public List<Vehicle> getListVehiculos(){
        return repo.findAll();
    }

    public Page<Vehicle> PageOfVehicle(Pageable page){
        return repository.findAll(page);
    }

    public Vehicle saveVehicle(Vehicle bean){
        return repo.save(bean);
    }

}

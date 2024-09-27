package pe.edu.cibertec.evaluacionT1.service;

import pe.edu.cibertec.evaluacionT1.clases.Vehiculo;
import pe.edu.cibertec.evaluacionT1.dto.SearchVehiculoRequestDTO;

import java.io.IOException;

public interface vehiculoService {
    Vehiculo BuscarVehiculo(SearchVehiculoRequestDTO request) throws IOException;
}

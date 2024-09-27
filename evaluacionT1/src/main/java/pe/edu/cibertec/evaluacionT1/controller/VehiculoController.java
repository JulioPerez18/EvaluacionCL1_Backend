package pe.edu.cibertec.evaluacionT1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.evaluacionT1.clases.Vehiculo;
import pe.edu.cibertec.evaluacionT1.dto.SearchVehiculoRequestDTO;
import pe.edu.cibertec.evaluacionT1.dto.SearchVehiculoResponseDTO;
import pe.edu.cibertec.evaluacionT1.service.vehiculoService;

@RestController
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    vehiculoService vehiculoService;

    @PostMapping("/searchVehiculo")
    public SearchVehiculoResponseDTO searchVehiculo(@RequestBody SearchVehiculoRequestDTO placa){
        try {
            Vehiculo obj = vehiculoService.BuscarVehiculo(placa);
            if (obj == null){
                return new SearchVehiculoResponseDTO("99","Vehiculo no encontrado",null);
            }
            return new SearchVehiculoResponseDTO("00","Success",obj);
        }catch (Exception ex){
            return new SearchVehiculoResponseDTO("99","Ocurrió un problema",null);
        }
    }
}

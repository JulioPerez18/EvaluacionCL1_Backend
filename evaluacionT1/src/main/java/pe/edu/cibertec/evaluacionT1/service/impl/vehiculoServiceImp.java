package pe.edu.cibertec.evaluacionT1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.evaluacionT1.clases.Vehiculo;
import pe.edu.cibertec.evaluacionT1.dto.SearchVehiculoRequestDTO;
import pe.edu.cibertec.evaluacionT1.service.vehiculoService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class vehiculoServiceImp implements vehiculoService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public Vehiculo BuscarVehiculo(SearchVehiculoRequestDTO request) throws IOException {
        Vehiculo objV = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                if (request.placa().equals(datos[1])){
                    objV = new Vehiculo(datos[2],datos[3],Integer.parseInt(datos[4]),Double.parseDouble(datos[5]),datos[6]);
                    break;
                }
            }
        }catch (IOException e){
            objV = null;
            throw new IOException();
        }
        return objV;
    }
}

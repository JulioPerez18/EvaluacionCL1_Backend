package pe.edu.cibertec.evaluacionT1.dto;

import pe.edu.cibertec.evaluacionT1.clases.Vehiculo;

public record SearchVehiculoResponseDTO(String codigo, String mensaje, Vehiculo vehiculo) {
}
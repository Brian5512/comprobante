package microservice.comprobante.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
  
@Data
@NoArgsConstructor
@AllArgsConstructor
public class comprobanteDTO {

   //Datos del comprobante guardado 
    private Long idComprobante;
    private String estado;
    private LocalDate fechaEmision;
 
    //Datos del Usuario 
    private String nombreUsuario;
    private String correoUsuario;
 
    //Datos de la Venta
    private Long idVenta;
    private Double totalVenta;
    private Double descuentoVenta;
    private String estadoVenta;
 
    //Datos del Perfume
    private Long idPerfume;
    private String nombrePerfume;
    private String marcaPerfume;
    private Double precioPerfume;
 
    //Datos de la Sucursal
    private Long idSucursal;
    private String nombreSucursal;
    private String ciudadSucursal;
    private String direccionSucursal;
}
 


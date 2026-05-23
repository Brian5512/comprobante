package microservice.comprobante.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
  
@Data
@NoArgsConstructor
@AllArgsConstructor
public class comprobanteDTO {

    private Long idComprobante;

    private Long idVenta;

    private String nombreCliente;

    private String nombreUsuario;

    private String tipoComprobante;

    private Double subtotal;

    private Double iva;

    private Double total;

    private LocalDate fechaEmision;

    private String estado;
}


package microservice.comprobante.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comprobante")
public class comprobante {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_comprobante")
private Long idComprobante;

@Column(nullable = false)
private Long idVenta;

@Column(nullable = false)
private Long idCliente;

@Column(nullable = false)
private Long idUsuario;

@Column(nullable = false, length = 50)
private String correoCliente;

@Column(nullable = false)
private Double subtotal;

@Column(nullable = false)
private Double iva;

@Column(nullable = false)
private Double total;

@Column(nullable = false)
private LocalDate fechaEmision;

@Column(nullable = false, length = 30)
private String estado;
}
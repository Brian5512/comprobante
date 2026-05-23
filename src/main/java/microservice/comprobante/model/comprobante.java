
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComprobante;
    
    @Column(nullable = false)
    private int idPago;

    @Column(nullable = false)
    private int idVenta;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Date fechaEmision;
    }
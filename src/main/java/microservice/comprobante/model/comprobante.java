
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.Identity)
    private Long idComprobante;
    
    @Column(nullable = false)
    private int idPago;

    @Column(nullable = false)
    private int idVenta;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Date fechaEmision;
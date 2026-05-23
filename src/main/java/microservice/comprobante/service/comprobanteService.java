package microservice.comprobante.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.transaction.Transactional;
import microservice.comprobante.model.comprobante;
import microservice.comprobante.model.comprobanteDTO;
import microservice.comprobante.repository.comprobanteRepository;

@Service
@Transactional
public class comprobanteService {

    @Autowired
    private comprobanteRepository comprobanteRepository;

    @Autowired
    private RestTemplate restTemplate;

    public comprobanteDTO Crearcomprobante(comprobante comprobante) {

        try {
            //
            // MICROSERVICIO USUARIOS
            String urlusuario =
                    "http://localhost:8080/api/v1/usuarios/" + comprobante.getIdUsuario();

            comprobanteDTO usuario =
                    restTemplate.getForObject(urlusuario, comprobanteDTO.class);

            // MICROSERVICIO VENTAS
            String urlventa =
                    "http://localhost:8081/api/v1/ventas/" + comprobante.getIdVenta();

            comprobanteDTO venta =
                    restTemplate.getForObject(urlventa, comprobanteDTO.class);

            if (venta == null) {
                throw new RuntimeException("Venta no encontrada");
            }

            // MICROSERVICIO PERFUMES
            String urlperfume =
                    "http://localhost:8082/api/v1/perfumes/" + venta.getIdPerfume();
            comprobanteDTO perfume =
                    restTemplate.getForObject(urlperfume, comprobanteDTO.class);

            // MICROSERVICIO SUCURSALES
            String urlsucursal =
                    "http://localhost:8083/api/v1/sucursales/" + venta.getIdSucursal();
            comprobanteDTO sucursal =
                    restTemplate.getForObject(urlsucursal, comprobanteDTO.class);

            // DATOS DEL COMPROBANTE
            if (usuario != null) {
                comprobante.setCorreoCliente(usuario.getCorreoCliente());
            }

            comprobante.setTotal(venta.getTotalVenta());
            comprobante.setFechaEmision(LocalDate.now());
            comprobante.setEstado("EMITIDO");

            comprobante guardado = comprobanteRepository.save(comprobante);

            System.out.println("Comprobante guardado: " + guardado);

            comprobanteDTO dto = new comprobanteDTO();

            //DATOS COMPROBANTE
            dto.setIdComprobante(guardado.getIdComprobante());
            dto.setEstado(guardado.getEstado());
            dto.setFechaEmision(guardado.getFechaEmision());

            //DATOS USUARIO
            if (usuario != null) {
                dto.setNombreUsuario(usuario.getNombreUsuario());
                dto.setCorreoCliente(usuario.getCorreoCliente());
            }

            // DATOS VENTA
            dto.setIdVenta(venta.getIdVenta());
            dto.setTotalVenta(venta.getTotalVenta());
            dto.setDescuentoVenta(venta.getDescuentoVenta());
            dto.setEstadoVenta(venta.getEstadoVenta());

            // DATOS PERFUME
            if (perfume != null) {
                dto.setNombrePerfume(perfume.getNombrePerfume());
                dto.setMarcaPerfume(perfume.getMarcaPerfume());
                dto.setPrecioPerfume(perfume.getPrecioPerfume());
            }

            // DATOS SUCURSAL
            if (sucursal != null) {
                dto.setNombreSucursal(sucursal.getNombreSucursal());
                dto.setCiudadSucursal(sucursal.getCiudadSucursal());
                dto.setDireccionSucursal(sucursal.getDireccionSucursal());
            }


            return dto;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Error al crear comprobante: " + e.getMessage()
            );
        }
    }

    public List<comprobante> getComprobante() {
        return comprobanteRepository.findAll();
    }
}
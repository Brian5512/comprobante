package microservice.comprobante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.comprobante.service.comprobanteService;
import microservice.comprobante.model.comprobante;

@RestController
@RequestMapping("api/v1/comprobantes")
public class comprobanteController {

    @Autowired
    private comprobanteService comprobanteService;

    @PostMapping()
    public ResponseEntity crear(@RequestBody comprobante comprobante) {
        return new ResponseEntity<>(comprobanteService.Crearcomprobante(comprobante),HttpStatus.CREATED
    );
}
    @GetMapping()
    public List<comprobante> getComprobante(){
        return comprobanteService.getComprobante();
    }
    }
package microservice.comprobante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import microservice.comprobante.service.comprobanteService;

import microservice.comprobante.model.comprobante;

@RestController
@RequestMapping("api/v1/comprobantes")
public class comprobanteController {

    @Autowired
    private comprobanteService comprobanteService;

    @PostMapping()
    public comprobante postComprobante(
            @RequestBody comprobante comprobante) {

        return comprobanteService.postComprobante(comprobante);
    }

    @GetMapping()
    public List<comprobante> getComprobante() {

        return comprobanteService.getComprobante();
    }

    @PutMapping("{id}")
    public comprobante updateComprobante(
            @PathVariable long id,
            @RequestBody comprobante comprobante) {

        return comprobanteService.updateComprobante(id, comprobante);
    }

    @DeleteMapping("{id}")
    public void deleteComprobante(@PathVariable long id) {

        comprobanteService.deleteComprobante(id);
    }
}

package microservice.comprobante.service;

import java.util.List;

import microservice.comprobante.model.comprobante;

public class comprobanteService {

    public comprobante postComprobante(comprobante comprobante) {
        return comprobante.save(comprobante);
    }

    public List<comprobante> getComprobante() {
        return comprobante.findAll();
    }
    public comprobante updateComprobante(long id, comprobante comprobante) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateComprobante'");
    }
    
}

package candyligth.dao;

import candyligth.model.Factura;
import candyligth.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaDaoImpl implements FacturaDao {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    public void eliminarFactura(Integer id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Factura obtenerFacturaPorId(Integer id) {
        return facturaRepository.findById(id).orElse(null);
    }
}
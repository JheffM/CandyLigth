package candyligth.dao;

import candyligth.model.Factura;
import java.util.List;

public interface FacturaDao {

    List<Factura> listarFacturas();

    Factura guardarFactura(Factura factura);

    void eliminarFactura(Integer id);

    Factura obtenerFacturaPorId(Integer id);
}
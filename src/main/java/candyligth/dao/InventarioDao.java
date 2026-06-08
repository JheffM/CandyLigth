package candyligth.dao;

import candyligth.model.Inventario;
import java.util.List;

public interface InventarioDao {

    List<Inventario> listarInventarios();

    Inventario guardarInventario(Inventario inventario);

    void eliminarInventario(Integer id);

    Inventario obtenerInventarioPorId(Integer id);
}
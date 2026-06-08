package candyligth.dao;

import candyligth.model.Inventario;
import candyligth.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioDaoImpl implements InventarioDao {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> listarInventarios() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario guardarInventario(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public void eliminarInventario(Integer id) {
        inventarioRepository.deleteById(id);
    }

    @Override
    public Inventario obtenerInventarioPorId(Integer id) {
        return inventarioRepository.findById(id).orElse(null);
    }
}
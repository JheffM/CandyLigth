package candyligth.dao;

import candyligth.model.Producto;
import candyligth.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoDaoImpl implements ProductoDao {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProductos() {

        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {

        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Integer id) {

        productoRepository.deleteById(id);
    }

    @Override
    public Producto obtenerProductoPorId(Integer id) {

        return productoRepository.findById(id).orElse(null);
    }
}

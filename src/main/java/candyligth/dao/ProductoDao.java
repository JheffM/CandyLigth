package candyligth.dao;

import candyligth.model.Producto;

import java.util.List;



public interface ProductoDao {

    List<Producto> listarProductos();

    Producto guardarProducto(Producto producto);

    void eliminarProducto(Integer id);

    Producto obtenerProductoPorId(Integer id);
}
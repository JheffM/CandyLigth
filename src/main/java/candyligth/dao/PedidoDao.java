package candyligth.dao;

import candyligth.model.Pedido;

import java.util.List;

public interface PedidoDao {

    List<Pedido> listarPedidos();

    Pedido guardarPedido(Pedido pedido);

    void eliminarPedido(Integer id);

    Pedido obtenerPedidoPorId(Integer id);
}
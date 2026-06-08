package candyligth.dao;

import candyligth.model.Pedido;
import candyligth.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoDaoImpl implements PedidoDao {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> listarPedidos() {

        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {

        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminarPedido(Integer id) {

        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido obtenerPedidoPorId(Integer id) {

        return pedidoRepository.findById(id).orElse(null);
    }
}
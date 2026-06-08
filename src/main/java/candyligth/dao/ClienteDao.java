package candyligth.dao;

import candyligth.model.Cliente;

import java.util.List;

public interface ClienteDao {

    List<Cliente> listarClientes();

    Cliente guardarCliente(Cliente cliente);

    void eliminarCliente(Integer id);

    Cliente obtenerClientePorId(Integer id);
}
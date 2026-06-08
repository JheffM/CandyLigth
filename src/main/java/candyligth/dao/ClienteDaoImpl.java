package candyligth.dao;

import candyligth.model.Cliente;
import candyligth.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteDaoImpl implements ClienteDao {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {

        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer id) {

        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {

        return clienteRepository.findById(id).orElse(null);
    }
}
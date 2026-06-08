package candyligth.controller;

import candyligth.dao.ClienteDao;
import candyligth.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;

    @GetMapping("/clientes")
    public String listarClientes(Model model) {

        model.addAttribute("clientes",
                clienteDao.listarClientes());

        return "clientes";
    }

    @GetMapping("/nuevo-cliente")
    public String mostrarFormulario(Model model) {

        model.addAttribute("cliente", new Cliente());

        return "nuevo-cliente";
    }

    @PostMapping("/guardar-cliente")
    public String guardarCliente(Cliente cliente) {

        clienteDao.guardarCliente(cliente);

        return "redirect:/clientes";
    }

    @GetMapping("/eliminar-cliente/{id}")
    public String eliminarCliente(@PathVariable Integer id) {

        clienteDao.eliminarCliente(id);

        return "redirect:/clientes";
    }

    @GetMapping("/editar-cliente/{id}")
    public String editarCliente(@PathVariable Integer id,
                                Model model) {

        Cliente cliente =
                clienteDao.obtenerClientePorId(id);

        model.addAttribute("cliente", cliente);

        return "editar-cliente";
    }
}
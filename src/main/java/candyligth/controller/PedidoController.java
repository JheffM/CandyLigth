package candyligth.controller;

import candyligth.dao.PedidoDao;
import candyligth.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PedidoController {

    @Autowired
    private PedidoDao pedidoDao;

    @GetMapping("/pedidos")
    public String listarPedidos(Model model) {

        model.addAttribute("pedidos",
                pedidoDao.listarPedidos());

        return "pedidos";
    }

    @GetMapping("/nuevo-pedido")
    public String mostrarFormulario(Model model) {

        model.addAttribute("pedido", new Pedido());

        return "nuevo-pedido";
    }

    @PostMapping("/guardar-pedido")
    public String guardarPedido(Pedido pedido) {

        pedidoDao.guardarPedido(pedido);

        return "redirect:/pedidos";
    }

    @GetMapping("/eliminar-pedido/{id}")
    public String eliminarPedido(@PathVariable Integer id) {

        pedidoDao.eliminarPedido(id);

        return "redirect:/pedidos";
    }

    @GetMapping("/editar-pedido/{id}")
    public String editarPedido(@PathVariable Integer id,
                               Model model) {

        Pedido pedido =
                pedidoDao.obtenerPedidoPorId(id);

        model.addAttribute("pedido", pedido);

        return "editar-pedido";
    }
}
package candyligth.controller;

import candyligth.dao.InventarioDao;
import candyligth.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class InventarioController {

    @Autowired
    private InventarioDao inventarioDao;

    @GetMapping("/inventarios")
    public String listarInventarios(Model model) {

        model.addAttribute("inventarios",
                inventarioDao.listarInventarios());

        return "inventarios";
    }

    @GetMapping("/nuevo-inventario")
    public String mostrarFormulario(Model model) {

        model.addAttribute("inventario",
                new Inventario());

        return "nuevo-inventario";
    }

    @PostMapping("/guardar-inventario")
    public String guardarInventario(Inventario inventario) {

        inventarioDao.guardarInventario(inventario);

        return "redirect:/inventarios";
    }

    @GetMapping("/eliminar-inventario/{id}")
    public String eliminarInventario(@PathVariable Integer id) {

        inventarioDao.eliminarInventario(id);

        return "redirect:/inventarios";
    }

    @GetMapping("/editar-inventario/{id}")
    public String editarInventario(@PathVariable Integer id,
                                   Model model) {

        Inventario inventario =
                inventarioDao.obtenerInventarioPorId(id);

        model.addAttribute("inventario", inventario);

        return "editar-inventario";
    }
}
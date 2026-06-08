package candyligth.controller;

import candyligth.dao.FacturaDao;
import candyligth.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FacturaController {

    @Autowired
    private FacturaDao facturaDao;

    @GetMapping("/facturas")
    public String listarFacturas(Model model) {

        model.addAttribute("facturas",
                facturaDao.listarFacturas());

        return "facturas";
    }

    @GetMapping("/nueva-factura")
    public String mostrarFormulario(Model model) {

        model.addAttribute("factura",
                new Factura());

        return "nueva-factura";
    }

    @PostMapping("/guardar-factura")
    public String guardarFactura(Factura factura) {

        facturaDao.guardarFactura(factura);

        return "redirect:/facturas";
    }

    @GetMapping("/eliminar-factura/{id}")
    public String eliminarFactura(@PathVariable Integer id) {

        facturaDao.eliminarFactura(id);

        return "redirect:/facturas";
    }
    @GetMapping("/editar-factura/{id}")
    public String editarFactura(@PathVariable Integer id,
                                Model model) {

        Factura factura =
                facturaDao.obtenerFacturaPorId(id);

        model.addAttribute("factura", factura);

        return "editar-factura";
    }
}

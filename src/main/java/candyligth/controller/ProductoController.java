package candyligth.controller;

import candyligth.dao.ProductoDao;
import candyligth.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import candyligth.service.CarritoService;

@Controller
public class ProductoController {

    @Autowired
    private ProductoDao productoDAO;

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/productos")
    public String listarProductos(Model model) {

        model.addAttribute("productos",
                productoDAO.listarProductos());

        return "productos";
    }

    @GetMapping("/nuevo-producto")
    public String mostrarFormulario(Model model) {

        model.addAttribute("producto", new Producto());

        return "nuevo-producto";
    }

    @PostMapping("/guardar-producto")
    public String guardarProducto(Producto producto) {

        productoDAO.guardarProducto(producto);

        return "redirect:/productos";
    }

    @GetMapping("/eliminar-producto/{id}")
    public String eliminarProducto(@PathVariable Integer id) {

        productoDAO.eliminarProducto(id);

        return "redirect:/productos";
    }

    @GetMapping("/editar-producto/{id}")
    public String editarProducto(@PathVariable Integer id,
                                 Model model) {

        Producto producto =
                productoDAO.obtenerProductoPorId(id);

        model.addAttribute("producto", producto);

        return "editar-producto";
    }

    @GetMapping("/catalogo")
    public String catalogo(Model model){

        model.addAttribute(
                "productos",
                productoDAO.listarProductos()
        );

        model.addAttribute(
                "cantidadCarrito",
                carritoService.cantidadProductos()
        );

        return "catalogo";
    }
}
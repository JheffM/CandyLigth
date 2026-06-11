package candyligth.controller;

import candyligth.dao.ProductoDao;
import candyligth.model.CarritoItem;
import candyligth.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarritoController {

    @Autowired
    private ProductoDao productoDAO;

    private List<CarritoItem> carrito = new ArrayList<>();

    @GetMapping("/carrito")
    public String verCarrito(Model model) {

        double total = 0;

        for (CarritoItem item : carrito) {
            total += item.getSubtotal();
        }

        model.addAttribute("items", carrito);
        model.addAttribute("total", total);

        return "carrito";
    }

    @GetMapping("/agregar-carrito/{id}")
    public String agregarCarrito(@PathVariable Integer id) {

        Producto producto =
                productoDAO.obtenerProductoPorId(id);

        if (producto != null) {

            boolean encontrado = false;

            for (CarritoItem item : carrito) {

                if (item.getProducto().getId() == id) {

                    item.setCantidad(
                            item.getCantidad() + 1
                    );

                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {

                carrito.add(
                        new CarritoItem(producto, 1)
                );
            }
        }

        return "redirect:/catalogo";
    }
}
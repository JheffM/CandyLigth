package candyligth.controller;

import candyligth.model.CarritoItem;
import candyligth.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinalizarPedidoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/finalizar-pedido")
    public String finalizarPedido(Model model) {

        double total = 0;

        for (CarritoItem item :
                carritoService.getCarrito()) {

            total += item.getSubtotal();
        }

        model.addAttribute(
                "items",
                carritoService.getCarrito()
        );

        model.addAttribute(
                "total",
                total
        );

        return "finalizar-pedido";
    }
}
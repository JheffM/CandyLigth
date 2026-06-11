package candyligth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PedidoPublicoController {

    @GetMapping("/finalizar-pedido")
    public String finalizarPedido() {

        return "finalizar-pedido";
    }
}
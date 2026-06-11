package candyligth.service;

import candyligth.model.CarritoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarritoService {

    private List<CarritoItem> carrito =
            new ArrayList<>();

    public List<CarritoItem> getCarrito() {
        return carrito;
    }

    public int cantidadProductos() {

        int total = 0;

        for (CarritoItem item : carrito) {
            total += item.getCantidad();
        }

        return total;
    }

}
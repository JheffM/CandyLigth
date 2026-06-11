package candyligth;

import candyligth.service.CarritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoServiceTest {

    private CarritoService carritoService;

    @BeforeEach
    void setUp() {

        carritoService = new CarritoService();
    }

    @Test
    void carritoVacioDebeRetornarCero() {

        int resultado =
                carritoService.cantidadProductos();

        assertEquals(0, resultado);
    }
}
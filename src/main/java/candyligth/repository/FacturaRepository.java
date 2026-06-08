package candyligth.repository;

import candyligth.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository
        extends JpaRepository<Factura, Integer> {
}
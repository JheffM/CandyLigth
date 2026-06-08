package candyligth.repository;

import candyligth.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository
        extends JpaRepository<Inventario, Integer> {
}
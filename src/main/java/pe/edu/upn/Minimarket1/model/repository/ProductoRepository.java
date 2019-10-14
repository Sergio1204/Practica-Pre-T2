package pe.edu.upn.Minimarket1.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.Minimarket1.model.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {

}

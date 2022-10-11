package com.gestionventa.demo.repository;

import com.gestionventa.demo.models.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito,Integer> {

   List<ItemCarrito> findByIdComprador();
}

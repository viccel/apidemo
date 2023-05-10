package com.apidemo1.apidemo1.repository;

import com.apidemo1.apidemo1.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}

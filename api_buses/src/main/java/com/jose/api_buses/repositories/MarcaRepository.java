package com.jose.api_buses.repositories;

import com.jose.api_buses.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}

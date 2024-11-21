package com.jose.api_buses.services;

import com.jose.api_buses.models.entities.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BusService {

    List<Bus> findAll();
    Optional<Bus> findById(long id);
    Bus save(Bus bus);
    Optional <Bus> update(Bus bus, long id);
    void remove(Long id);
    Page<Bus> findAll(Pageable pageable);

}

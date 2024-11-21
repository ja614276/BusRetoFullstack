package com.jose.api_buses.services;

import com.jose.api_buses.models.entities.Bus;
import com.jose.api_buses.repositories.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BusServiceImplement implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Bus> findAll() {
        return StreamSupport.stream(busRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Bus> findById(long id) {
        return busRepository.findById(id);
    }

    @Override
    @Transactional
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public Optional<Bus> update(Bus bus, long id) {
        Optional<Bus> o = this.findById(id);
        if (o.isPresent()) {
            Bus busDb = o.get();
            busDb.setNumeroDeBus(bus.getNumeroDeBus());
            busDb.setPlaca(bus.getPlaca());
            busDb.setCaracteristicas(bus.getCaracteristicas());
            busDb.setMarcaDeBus(bus.getMarcaDeBus());
            busDb.setActivo(bus.isActivo());
            return Optional.of(this.save(busDb));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void remove(Long id) {
        busRepository.deleteById(id);
    }

    @Override
    public Page<Bus> findAll(Pageable pageable) {
        return busRepository.findAll(pageable);
    }

}

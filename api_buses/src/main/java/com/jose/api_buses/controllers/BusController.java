package com.jose.api_buses.controllers;

import com.jose.api_buses.models.entities.Bus;
import com.jose.api_buses.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jose.api_buses.repositories.BusRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
//@CrossOrigin(origins="*")
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping
    public List<Bus> List(){ return busService.findAll(); }

    @GetMapping("/page")
    public ResponseEntity<Page<Bus>> getAllBuses(Pageable pageable) {
        Page<Bus> busesPage = busService.findAll(pageable);
        return ResponseEntity.ok(busesPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        Optional<Bus> productOptional = busService.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}

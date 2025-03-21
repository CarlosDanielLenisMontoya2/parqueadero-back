package com.example.demo.controller;

import com.example.demo.dto.ZonaDto;
import com.example.demo.models.Zona;
import com.example.demo.service.ZonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/zona")
public class ZonaController {

    private final ZonaService service;

    @PostMapping("/create-zona")
    public ZonaDto create(@RequestBody ZonaDto zonaDto){
        return service.create(zonaDto);
    }
    @PutMapping("/update-zona")
    public ZonaDto update(@RequestBody ZonaDto zonaDto){
        return service.update(zonaDto);
    }
    @DeleteMapping("/delete-zona/{id}")
    void delete(@PathVariable Long id){
        service.delete(id);
    }
    @GetMapping("/read-zona")
    Page<Zona> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return service.read(pageSize, pageNumber);
    }
}

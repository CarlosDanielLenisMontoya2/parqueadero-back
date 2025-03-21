package com.example.demo.controller;

import com.example.demo.dto.PagoDto;
import com.example.demo.models.Pago;
import com.example.demo.service.PagoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RestController
@RequestMapping("/pago")
public class PagoController {
    private final PagoService pagoService;
    @PostMapping("/create-pago")
    public PagoDto create(@RequestBody PagoDto pagoDto){
        return pagoService.create(pagoDto);
    }
    @PutMapping("/update-pago")
    public PagoDto update(@RequestBody PagoDto pagoDto){
        return pagoService.update(pagoDto);
    }
    @DeleteMapping("/delete-pago/{id}")
    void delete(@PathVariable Long id){
        pagoService.delete(id);
    }
    @GetMapping("/read-pago")
    Page<Pago> read(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "pageNumber") Integer pageNumber) {
        return pagoService.read(pageSize, pageNumber);
    }
}

package net.bakhishoff.parking.controller;

import lombok.RequiredArgsConstructor;
import net.bakhishoff.parking.service.CrudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
public abstract class CrudController<Dto, Entity> {
    private final CrudService<Dto, Entity> service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dto create(@RequestBody @Valid Dto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Dto> page() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Dto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Dto updateById(@PathVariable Long id,
                          @RequestBody @Valid Dto dto) {
        return service.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

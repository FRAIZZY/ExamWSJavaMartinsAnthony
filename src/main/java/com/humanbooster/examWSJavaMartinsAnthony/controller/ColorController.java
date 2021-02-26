/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.humanbooster.examWSJavaMartinsAnthony.controller;

import com.humanbooster.examWSJavaMartinsAnthony.model.Color;
import com.humanbooster.examWSJavaMartinsAnthony.repository.ColorRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author HB
 */
@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("")
    public List<Color> allColor() {

        return this.colorRepository.findAll();

    }

    @GetMapping(value = "/{color}", produces = {"application/json"})
    public Color getColor(@PathVariable(name = "color", required = false) Color color) {

        if (color == null) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Couleur introuvable"
            );

        } else {
            return color;
        }

    }

    @PostMapping(value = "", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Color> saveColor(@Valid @RequestBody Color color) {

        this.colorRepository.save(color);
        return new ResponseEntity<Color>(color, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{color}", produces = {"application/json"})
    public ResponseEntity<Color> updateColor(@PathVariable(name = "color", required = false) Color color, @Valid @RequestBody Color colorUpdate) {

        if (color == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Couleur introuvable"
            );
        }

        colorUpdate.setId(color.getId());
        this.colorRepository.save(colorUpdate);
        return new ResponseEntity<Color>(color, HttpStatus.OK);

    }

    @DeleteMapping(value = "/{color}", produces = {"application/json"})
    void deleteColor(@PathVariable(name = "color", required = false) Color color) {

        if (color == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Couleur introuvable"
            );
        } else {
            this.colorRepository.delete(color);
        }

    }

}

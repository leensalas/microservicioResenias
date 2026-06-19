package com.resenas.resenas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resenas.resenas.model.Resenas;
import com.resenas.resenas.service.ResenasService;

@RestController
@RequestMapping("/resenas")
public class ResenasController {

    @Autowired
    private ResenasService resenasService;

    @GetMapping
    public List<Resenas> listarResenas() {
        return resenasService.listarResenas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resenas> buscarPorId(@PathVariable Long id) {
        Resenas resena = resenasService.buscarPorId(id);

        if (resena == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resena);
    }

    @PostMapping
    public Resenas crearResena(@RequestBody Resenas resena) {
        return resenasService.crearResena(resena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resenas> actualizarResena(@PathVariable Long id, @RequestBody Resenas resena) {
        Resenas resenaActualizada = resenasService.actualizarResena(id, resena);

        if (resenaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resenaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarResena(@PathVariable Long id) {
        boolean eliminado = resenasService.eliminarResena(id);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Reseña eliminada correctamente");
    }
}

package com.app.aulavirtual.controladores;

import com.app.aulavirtual.dto.ForoRequestDTO;
import com.app.aulavirtual.dto.ForoResponseDTO;
import com.app.aulavirtual.entidades.Foro;
import com.app.aulavirtual.mapper.ForoMapper;
import com.app.aulavirtual.servicios.ForoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
public class ForoController {

    private final ForoService foroService;
    private final ForoMapper foroMapper;

    public ForoController(ForoService foroService, ForoMapper foroMapper) {
        this.foroService = foroService;
        this.foroMapper = foroMapper;
    }

    @PostMapping
    public ResponseEntity<ForoResponseDTO> crear(
            @RequestBody ForoRequestDTO request,
            Authentication authentication) {

        Foro foro = foroMapper.toEntity(request);

        // El autor no se recibe del cliente.
        // Se completará usando el usuario autenticado.


        Foro guardado = foroService.crear(foro, authentication.getName());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(foroMapper.toResponseDTO(guardado));
    }

    @GetMapping
    public ResponseEntity<List<ForoResponseDTO>> listar() {
        List<ForoResponseDTO> respuesta = foroService.listar()
                .stream()
                .map(foroMapper::toResponseDTO)
                .toList();

        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForoResponseDTO> buscarPorId(@PathVariable Long id) {
        return foroService.buscarPorId(id)
                .map(foroMapper::toResponseDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

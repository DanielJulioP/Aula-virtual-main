
package com.app.aulavirtual.mapper;

import com.app.aulavirtual.dto.ForoRequestDTO;
import com.app.aulavirtual.dto.ForoResponseDTO;
import com.app.aulavirtual.entidades.Foro;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ForoMapper {

    public Foro toEntity(ForoRequestDTO dto) {
        Foro foro = new Foro();
        foro.setCursoId(dto.getCursoId());
        foro.setTexto(dto.getTexto());
        foro.setFecha(LocalDateTime.now());
        return foro;
    }

    public ForoResponseDTO toResponseDTO(Foro foro) {
        ForoResponseDTO dto = new ForoResponseDTO();
        dto.setId(foro.getId());
        dto.setCursoId(foro.getCursoId());
        dto.setTexto(foro.getTexto());
        dto.setFecha(foro.getFecha());
        dto.setNombreAutor(foro.getNombreAutor());
        return dto;
    }
}

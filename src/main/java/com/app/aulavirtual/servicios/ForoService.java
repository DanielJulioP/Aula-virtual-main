
package com.app.aulavirtual.servicios;

import com.app.aulavirtual.entidades.Foro;

import java.util.List;
import java.util.Optional;

public interface ForoService {

Foro crear(Foro foro, String username);

    List<Foro> listar();

    Optional<Foro> buscarPorId(Long id);
}

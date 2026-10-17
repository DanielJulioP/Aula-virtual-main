
package com.app.aulavirtual.repositorios;

import com.app.aulavirtual.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<Persona> findByUsuarioId(Long usuarioId);
}

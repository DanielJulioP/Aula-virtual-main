
package com.app.aulavirtual.servicios.impl;

import com.app.aulavirtual.entidades.Foro;
import com.app.aulavirtual.entidades.Persona;
import com.app.aulavirtual.entidades.User;
import com.app.aulavirtual.repositorios.ForoRepository;
import com.app.aulavirtual.repositorios.PersonaRepository;
import com.app.aulavirtual.repositorios.UserRepository;
import com.app.aulavirtual.servicios.ForoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForoServiceImpl implements ForoService {

    private final ForoRepository foroRepository;
    private final UserRepository userRepository;
    private final PersonaRepository personaRepository;

    public ForoServiceImpl(
            ForoRepository foroRepository,
            UserRepository userRepository,
            PersonaRepository personaRepository) {

        this.foroRepository = foroRepository;
        this.userRepository = userRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public Foro crear(Foro foro, String username) {


        User usuario = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "No se encontró el usuario autenticado"));


        Persona persona = personaRepository.findByUsuarioId(usuario.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException(
                                "El usuario no tiene una persona asociada"));


        foro.setAutorId(usuario.getId());
        foro.setNombreAutor(
                persona.getNombres() + " " + persona.getApellidos()
        );


        return foroRepository.save(foro);
    }

    @Override
    public List<Foro> listar() {
        return foroRepository.findAll();
    }

    @Override
    public Optional<Foro> buscarPorId(Long id) {
        return foroRepository.findById(id);
    }
}

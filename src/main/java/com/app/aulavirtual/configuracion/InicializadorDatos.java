package com.app.aulavirtual.configuracion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.app.aulavirtual.entidades.User;
import com.app.aulavirtual.repositorios.UserRepository;
import com.app.aulavirtual.entidades.Persona;
import com.app.aulavirtual.repositorios.PersonaRepository;

@Configuration
public class InicializadorDatos {

    @Bean
    CommandLineRunner inicializarBaseDatos(
            UserRepository usuRepository,
            PersonaRepository personaRepository,
            PasswordEncoder passwordEncoder) {

        return arg -> {
            if (usuRepository.findByUsername("admin").isEmpty()) {
                User user = new User(null, "admin", passwordEncoder.encode("12345"), "ADMIN");
                usuRepository.save(user);
            }
            User user = usuRepository.findByUsername("admin")
                    .orElseThrow(() -> new IllegalStateException("No se encontró el usuario admin"));

            if (personaRepository.findByUsuarioId(user.getId()).isEmpty()) {
                Persona persona = new Persona();

                persona.setNombres("Administrador");
                persona.setApellidos("Aula Virtual");
                persona.setIdentificacion("ADMIN-001");
                persona.setUsuario(user);

                personaRepository.save(persona);
            }
        };
    }
}

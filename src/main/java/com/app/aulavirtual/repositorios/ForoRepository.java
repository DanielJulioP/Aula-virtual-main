
package com.app.aulavirtual.repositorios;

import com.app.aulavirtual.entidades.Foro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForoRepository extends JpaRepository<Foro, Long> {

}

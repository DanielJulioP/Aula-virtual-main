
package com.app.aulavirtual.dto;

public class ForoRequestDTO {

    private Long cursoId;
    private String texto;

    public ForoRequestDTO() {
    }

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

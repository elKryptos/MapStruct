package it.objectmethod.school.responses;

import it.objectmethod.school.models.dtos.InscriptionDto;
import lombok.Data;

@Data
public class InscriptionResponse {
    private String msg;
    private InscriptionDto inscriptionDto;

    public InscriptionResponse(String msg) {
        this.msg = msg;
    }

    public InscriptionResponse(String msg, InscriptionDto inscriptionDto) {
        this.msg = msg;
        this.inscriptionDto = inscriptionDto;
    }
}

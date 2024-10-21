package it.objectmethod.school.mappers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.models.Course;
import it.objectmethod.school.models.Inscription;
import it.objectmethod.school.models.Student;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InscriptionMapper  {

    public Inscription toEntity(InscriptionDto inscriptionDto) {
        if (inscriptionDto == null) return null;
        Inscription inscription = new Inscription();
        inscription.setInscriptionId(inscriptionDto.getInscriptionId());
        inscription.setRegistrationDate(inscriptionDto.getRegistrationDate());
        return inscription;
    }

    public Inscription toEntity(InscriptionDto inscriptionDto, Student student, Course course) {
        if (inscriptionDto == null) return null;
        Inscription inscription = new Inscription();
        inscription.setInscriptionId(inscriptionDto.getInscriptionId());
        inscription.setRegistrationDate(inscriptionDto.getRegistrationDate());
        inscription.setStudent(student);
        inscription.setCourse(course);
        return inscription;
    }

    public InscriptionDto toDto(Inscription inscription) {
        if (inscription == null) return null;
        InscriptionDto inscriptionDto = new InscriptionDto();
        inscriptionDto.setInscriptionId(inscription.getInscriptionId());
        inscriptionDto.setRegistrationDate(inscription.getRegistrationDate());
        return inscriptionDto;
    }
}

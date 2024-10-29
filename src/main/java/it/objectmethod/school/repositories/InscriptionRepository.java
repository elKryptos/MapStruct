package it.objectmethod.school.repositories;

import it.objectmethod.school.models.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
}

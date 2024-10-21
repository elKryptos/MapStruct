package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.responses.InscriptionResponse;
import it.objectmethod.school.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscription")
@RequiredArgsConstructor
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping("/enroll")
    public ResponseEntity<InscriptionResponse> enrollStudent(@RequestBody InscriptionDto inscriptionDto) {
        InscriptionResponse response = inscriptionService.enrollStudent(inscriptionDto);
        if (response != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @GetMapping("all")
    public List<InscriptionDto> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }
}
package it.objectmethod.school.controllers;

import it.objectmethod.school.dtos.InscriptionDto;
import it.objectmethod.school.responses.ResponseWrapper;
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

    @GetMapping("all")
    public List<InscriptionDto> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }

    @PostMapping("/enroll")
    public ResponseEntity<ResponseWrapper<InscriptionDto>> enrollStudent(@RequestBody InscriptionDto inscriptionDto) {
        ResponseWrapper<InscriptionDto> response = inscriptionService.enrollStudent(inscriptionDto);
        if (response != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/withdraw")
    public ResponseEntity<ResponseWrapper<InscriptionDto>> withdrawStudent(@RequestBody InscriptionDto inscriptionDto) {
        ResponseWrapper<InscriptionDto> response = inscriptionService.deleteEnrollment(inscriptionDto);
        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

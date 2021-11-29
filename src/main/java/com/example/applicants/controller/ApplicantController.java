package com.example.applicants.controller;
// IMPORTS
import com.example.applicants.model.Applicant;
import com.example.applicants.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ApplicantController {

    private final ApplicantService service;
    public static final String ID_NOT_FOUND_ERROR_MSG = "Driver Not Found for ID: ";

    public ApplicantController(ApplicantService service) {
        this.service = service;
    }

    // GET ALL APPLICANTS
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/applicants")
    List<Applicant> getAllApplicants() {
        return service.getAllApplicants();
    }

    // SAVE NEW APPLICANT
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/applicants")
    Applicant save(@RequestBody Applicant applicant) {
        return service.save(applicant);
    }

    // GET SINGLE APPLICANT
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/applicants/id")
    Applicant getSingleApplicant(@RequestParam Long id) {
        try{
            return service.getSingleApplicant(id);
        } catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    // DELETE SINGLE APPLICANT
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/applicants")
    void deleteSingleApplicant(@RequestParam Long id) {
        try{
             service.deleteSingleApplicant(id);
        } catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }

    // UPDATE TELEPHONE NUMBER
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/applicants")
    void updateAPhoneNumber(@RequestParam Long id, @RequestParam String telephoneNumber) {
        try{
            service.updateNumber(id, telephoneNumber);
        } catch (NoSuchElementException noSuchElementException){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND_ERROR_MSG + id, noSuchElementException);
        }
    }
}

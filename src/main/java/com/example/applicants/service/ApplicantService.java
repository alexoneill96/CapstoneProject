package com.example.applicants.service;

// IMPORTS
import com.example.applicants.model.Applicant;
import com.example.applicants.repository.ApplicantRepository;
import com.example.applicants.service.businessLogic.QuoteAmountCalculator;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ApplicantService {
    private final ApplicantRepository repository;
    private final QuoteAmountCalculator quoteAmountCalculator;
    List<Applicant> applicantList = new ArrayList<>();

    public ApplicantService(ApplicantRepository repository, QuoteAmountCalculator quoteAmountCalculator) {
        this.repository = repository;
        this.quoteAmountCalculator = quoteAmountCalculator;
    }

    public List<Applicant> getAllApplicants() {
        return repository.findAll();
    }

    // SAVE NEW RECORD
    public Applicant save(Applicant applicant) {
        quoteAmountCalculator.calculateQuote(applicant);
        applicantList.add(applicant);
        return repository.save(applicant);
    }


    // GET A SINGLE APPLICANT
    public Applicant getSingleApplicant(Long id) {
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Driver with ID "+id+" not found."));
    }


    // DELETE SINGLE APPLICANT
    public void deleteSingleApplicant(Long id) {
        if(repository.findById(id)!=null){
            repository.deleteById(id);
        } else throw new NoSuchElementException("Driver with ID"+id+" not found.");
    }

    // UPDATE APPLICANT TELEPHONE NUMBER
    public Applicant updateNumber(Long id, String telephoneNumber) {
        return repository.findById(id)
                .map(recordForUpdating -> {
                    recordForUpdating.setTelephoneNumber(telephoneNumber);
                    return repository.save(recordForUpdating);
                }).orElseThrow(()-> new NoSuchElementException("Driver with ID "+id+" not found."));
    }
}

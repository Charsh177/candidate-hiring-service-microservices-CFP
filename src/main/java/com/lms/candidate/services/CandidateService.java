package com.lms.candidate.services;

import com.lms.candidate.dto.CandidateDTO;
import com.lms.candidate.email.EmailService;
import com.lms.candidate.entity.Candidate;
import com.lms.candidate.exceptions.CandidateException;
import com.lms.candidate.repository.CandidateRepository;
import com.lms.candidate.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CandidateService implements ICandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private TokenUtility tokenUtility;

    @Autowired
    private EmailService emailService;

    @Override
    public Candidate addCandidate(CandidateDTO candidateDTO) {
        Candidate newCandidate = new Candidate(candidateDTO);
        candidateRepository.save(newCandidate);
        String token = tokenUtility.createToken(newCandidate.getCandidateId());
        emailService.sendEmail(newCandidate.getEmail(), "New Candidate Created Successfully", "Your Candidature Created Successfully...\n"
                        + "Click here to get your data by token :- " + "http://localhost:8087/candidate/getCandidateByToken/" + token);
        return newCandidate;
    }

    @Override
    public Object getCandidateByToken(String token) {
        int id = tokenUtility.decodeToken(token);
        Optional<Candidate> getCandidate = candidateRepository.findById(id);
        if (getCandidate.isPresent()) {
            emailService.sendEmail(getCandidate.get().getEmail(), "Get Candidate By Token ", "Click here to Get Candidate details -> " + "http://localhost:8087/candidate/getCandidateByToken/" + token);
            return getCandidate;
        } else {
            throw new CandidateException("Record for given token doesn't found..!!!");
        }
    }


//    @Override
//    public List<Candidate> getCandidateByToken(String token) {
//        Optional<Candidate> getCandidate = candidateRepository.findById(tokenUtility.decode(token));
//        System.out.println(getCandidate);
//        if (getCandidate.isPresent()) {
//            List<Candidate> candidate = candidateRepository.findAll();
//            System.out.println(candidate);
//            emailService.sendEmail(getCandidate.get().getEmail(), "Get Candidate Data By Token", "Get Data By Token :- " + "http://localhost:8087/candidate/getByToken/" + token);
//            return candidate;
//        } else {
//            System.out.println("Token not found..!!!");
//            return null;
//        }
//
//    }
}
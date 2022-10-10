package com.lms.candidate.services;

import com.lms.candidate.dto.CandidateDTO;
import com.lms.candidate.entity.Candidate;

public interface ICandidateService {

    public Candidate addCandidate(CandidateDTO candidateDTO);

    public Object getCandidateByToken(String token);


//    public Object getCandidateByToken(String token);
}

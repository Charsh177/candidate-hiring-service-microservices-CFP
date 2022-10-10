package com.lms.candidate.controller;

import com.lms.candidate.dto.CandidateDTO;
import com.lms.candidate.dto.ResponseDTO;
import com.lms.candidate.entity.Candidate;
import com.lms.candidate.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addCandidate(@Valid @RequestBody CandidateDTO candidateDTO) {
        Candidate candidate = candidateService.addCandidate(candidateDTO);
        ResponseDTO newResponse = new ResponseDTO("New Candidate Registered Successfully...", candidate);
        return new ResponseEntity<ResponseDTO>(newResponse, HttpStatus.CREATED);
    }

    // Get candidate details by token
    @GetMapping("/getCandidateByToken/{token}")
    public ResponseEntity<ResponseDTO> getCandidateByToken(@PathVariable String token) {
        Object candidate = candidateService.getCandidateByToken(token);
        ResponseDTO responseDTO = new ResponseDTO("Get Candidate Id / Data By Token :::", candidate);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


//    @GetMapping("/getByToken/{token}")
//    public ResponseEntity<ResponseDTO> getCandidateByToken(@PathVariable String token) {
//        List<Candidate> candidate = candidateService.getCandidateByToken(token);
//        ResponseDTO responseDTO = new ResponseDTO("Candidate info retrieved successfully...", candidate);
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
}
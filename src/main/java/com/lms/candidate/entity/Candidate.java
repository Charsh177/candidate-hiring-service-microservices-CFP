package com.lms.candidate.entity;

import com.lms.candidate.dto.CandidateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;


@Entity
@Table(name = "candidate")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public @Data class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "candidate_id")
    private int candidateId;

    private String candidateFirstName;

    private String candidateLastName;

    private String education;

    private String percentage;

    private Date dateOfBirth;

    private float experienceYears;

    private String experienceDetails;

    private String permanentAddress;

    @Email(message = "Please enter valid email..!!!")
    private String email;

    private long phoneNumber;

    private int noticePeriod;

    private long expectedSalary;

    private Date joiningDate;

    public Candidate(CandidateDTO candidateDTO) {
        this.candidateFirstName = candidateDTO.getCandidateFirstName();
        this.candidateLastName = candidateDTO.getCandidateLastName();
        this.education = candidateDTO.getEducation();
        this.percentage = candidateDTO.getPercentage();
        this.dateOfBirth = candidateDTO.getDateOfBirth();
        this.experienceYears = candidateDTO.getExperienceYears();
        this.experienceDetails = candidateDTO.getExperienceDetails();
        this.permanentAddress = candidateDTO.getPermanentAddress();
        this.email = candidateDTO.getEmail();
        this.phoneNumber = candidateDTO.getPhoneNumber();
        this.noticePeriod = candidateDTO.getNoticePeriod();
        this.expectedSalary = candidateDTO.getExpectedSalary();
        this.joiningDate = candidateDTO.getJoiningDate();
    }
}
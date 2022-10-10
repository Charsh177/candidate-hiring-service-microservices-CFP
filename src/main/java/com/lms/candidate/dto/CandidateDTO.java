package com.lms.candidate.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import java.util.Date;

public @Data class CandidateDTO {

    private String candidateFirstName;

    private String candidateLastName;

    private String education;

    private String percentage;

    private Date dateOfBirth;

    private float experienceYears;

    private String experienceDetails;

    private String permanentAddress;

    @Email
    private String email;

    private long phoneNumber;
    private int noticePeriod;

    private long expectedSalary;

    private Date joiningDate;

    public CandidateDTO() {
    }

    public CandidateDTO(String candidateFirstName, String candidateLastName, String education, String percentage, Date dateOfBirth,
                        float experienceYears, String experienceDetails, String permanentAddress, int noticePeriod, Date joiningDate) {
        this.candidateFirstName = candidateFirstName;
        this.candidateLastName = candidateLastName;
        this.education = education;
        this.percentage = percentage;
        this.dateOfBirth = dateOfBirth;
        this.experienceYears = experienceYears;
        this.experienceDetails = experienceDetails;
        this.permanentAddress = permanentAddress;
        this.noticePeriod = noticePeriod;
        this.joiningDate = joiningDate;
    }
}
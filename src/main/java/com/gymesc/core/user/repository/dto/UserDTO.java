package com.gymesc.core.user.repository.dto;

import com.gymesc.core.user.repository.User;
import com.gymesc.core.user.enumeration.TrainingLevelEnum;

public class UserDTO {

    private Long id;
    private Boolean active;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String federalIdentification;
    private Double weight;
    private Integer height;
    private TrainingLevelEnum trainingLevelEnum;

    public UserDTO parse(User user) {
        this.id = user.getId();
        this.active = user.isActive();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.federalIdentification = user.getFederalIdentification();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.trainingLevelEnum = user.getTrainingLevelEnum();

        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public void setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public TrainingLevelEnum getTrainingLevelEnum() {
        return trainingLevelEnum;
    }

    public void setTrainingLevelEnum(TrainingLevelEnum trainingLevelEnum) {
        this.trainingLevelEnum = trainingLevelEnum;
    }
}

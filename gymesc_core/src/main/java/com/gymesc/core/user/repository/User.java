package com.gymesc.core.user.repository;

import com.gymesc.core.user.repository.dto.UserDTO;
import com.gymesc.core.user.enumeration.TrainingLevelEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "ID")
    private long id;

    @Column(nullable = false, name = "ACTIVE")
    private boolean active;

    @Column(nullable = false, length = 40, name = "EMAIL")
    private String email;

    @Column(nullable = false, name = "PASSWORD")
    private String password;

    @Column(nullable = false, length = 20, name = "FIRST_NAME")
    private String firstName;

    @Column(length = 40, name = "LAST_NAME")
    private String lastName;

    @Column(length = 20, name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(length = 15, name = "FEDERAL_IDENTIFICATION")
    private String federalIdentification;

    @Column(nullable = false, name = "WEIGHT")
    private double weight;

    @Column(nullable = false, name = "HEIGHT")
    private int height;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TRAINING_LEVEL")
    private TrainingLevelEnum trainingLevelEnum;

    @Column(name = "CREATE_DATE", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "LAST_EDIT")
    private LocalDateTime lastEdit;

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastEdit = LocalDateTime.now();
    }

    public User parse(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.active = userDTO.getActive();
        this.email = userDTO.getEmail();
        this.firstName = userDTO.getFirstName();
        this.lastName = userDTO.getLastName();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.federalIdentification = userDTO.getFederalIdentification();
        this.weight = userDTO.getWeight();
        this.height = userDTO.getHeight();
        this.trainingLevelEnum = userDTO.getTrainingLevelEnum();

        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TrainingLevelEnum getTrainingLevelEnum() {
        return trainingLevelEnum;
    }

    public void setTrainingLevelEnum(TrainingLevelEnum trainingLevelEnum) {
        this.trainingLevelEnum = trainingLevelEnum;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }
}

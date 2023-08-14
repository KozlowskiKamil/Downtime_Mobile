package com.downtime.mobile.model;

import java.time.LocalDateTime;

public class Breakedown {

    private Long id;
    private String failureName;
    private String computerName;
    private String description;
    private Long waitingTime;
    private String failureStartTime;
    private Technician technician;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFailureName() {
        return failureName;
    }

    public void setFailureName(String failureName) {
        this.failureName = failureName;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(Long waitingTime) {
        this.waitingTime = waitingTime;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public String getFailureStartTime() {
        return failureStartTime;
    }

    public void setFailureStartTime(String failureStartTime) {
        this.failureStartTime = failureStartTime;
    }

    @Override
    public String toString() {
        return "Breakedown{" +
                "id=" + id +
                ", failureName='" + failureName + '\'' +
                ", computerName='" + computerName + '\'' +
                ", description='" + description + '\'' +
                ", waitingTime=" + waitingTime +
//                ", failureStartTime=" + failureStartTime +
                ", technician=" + technician +
                '}';
    }

}

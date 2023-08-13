package com.downtime.mobile.model;

public class Breakedown {

    private Long id;
    private String failureName;
    private String computerName;
    private String description;
    private Long waitingTime;

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

    @Override
    public String toString() {
        return "Breakedown{" +
                "id=" + id +
                ", failureName='" + failureName + '\'' +
                ", computerName='" + computerName + '\'' +
                ", description='" + description + '\'' +
                ", waitingTime=" + waitingTime +
                '}';
    }
}

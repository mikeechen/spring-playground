package com.example;


public class Tasks {
    private String sortBy;
    private Boolean done;

    public String getSortBy() {
        return this.sortBy;
    }

    public Boolean getDone() {
        return this.done;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public void setDone(String done) {
        if (done == "true") {
            this.done = true;
        } else {
            this.done = false;
        }
    }
}

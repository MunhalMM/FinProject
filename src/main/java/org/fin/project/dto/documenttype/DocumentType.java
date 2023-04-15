package org.fin.project.dto.documenttype;

public enum DocumentType {
    OUTPUT("output"),
    INPUT("input");

    private String status;

    DocumentType(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

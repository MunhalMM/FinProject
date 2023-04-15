package org.fin.project.entity;

import org.fin.project.dto.documenttype.DocumentType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "document")
public class Document {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private Date date;
    private long number;
    private long sum;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private String commentary;
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    private String originalFileName;

    public Document() {
        //
    }

    public Document(long id, Date date, long number, long sum, User user, String commentary, DocumentType documentType, String originalFileName) {
        this.id = id;
        this.date = date;
        this.number = number;
        this.sum = sum;
        this.user = user;
        this.commentary = commentary;
        this.documentType = documentType;
        this.originalFileName = originalFileName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User downloader) {
        this.user = downloader;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", date=" + date +
                ", number=" + number +
                ", sum=" + sum +
                ", user=" + user +
                ", commentary='" + commentary + '\'' +
                ", documentType=" + documentType +
                ", originalFileName='" + originalFileName + '\'' +
                '}';
    }
}

package org.fin.project.entity;

import javax.persistence.*;


@Entity
@Table
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}

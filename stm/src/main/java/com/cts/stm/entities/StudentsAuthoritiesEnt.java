package com.cts.stm.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "studentsauthorities")
public class StudentsAuthoritiesEnt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @Column(name = "authority")
    private String authority;

    @JoinColumn(name = "studentId" , referencedColumnName = "id")
    @OneToOne
    private StudentEnt studentid;

    public StudentsAuthoritiesEnt() {
    }

    public StudentsAuthoritiesEnt(String authority, StudentEnt studentid) {
        this.authority = authority;
        this.studentid = studentid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuthoritiesEnt{" +
                "authority='" + authority + '\'' +
                '}';
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public StudentEnt getStudentid() {
        return studentid;
    }

    public void setStudentid(StudentEnt studentid) {
        this.studentid = studentid;
    }
}

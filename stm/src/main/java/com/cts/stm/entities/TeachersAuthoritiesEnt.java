package com.cts.stm.entities;



import javax.persistence.*;

@Entity
@Table(name = "teachersauthorities")
public class TeachersAuthoritiesEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "authority")
    private String authority;

    @JoinColumn(name = "teacherId" , referencedColumnName = "id")
    @OneToOne
    private TeacherEnt teacherId;

    public TeachersAuthoritiesEnt() {
    }

    public TeachersAuthoritiesEnt(String authority, TeacherEnt teacherId) {
        this.authority = authority;
        this.teacherId = teacherId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public TeacherEnt getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherEnt teacherId) {
        this.teacherId = teacherId;
    }
}

package com.cts.stm.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "student")
@XmlRootElement
public class StudentEnt implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "age")
    private Integer age;
    @Basic(optional = false)
    @Column(name = "score")
    private Integer score;
  
	@Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "teacher_id" , referencedColumnName = "id")
    @ManyToOne
    private TeacherEnt teacher_id;

    public StudentEnt() {
    }

    public StudentEnt(String name, String surname, Integer age,Integer score, String username, String password, TeacherEnt teacher_id ) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.score=score;
        this.teacher_id = teacher_id;
        this.username = username;
        this.password = password;
    }

    public StudentEnt(Integer id, String name, String surname, Integer age,Integer score, String username, String password, TeacherEnt teacher_id) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.score=score;
        this.username = username;
        this.password = password;
        this.teacher_id = teacher_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}


    public TeacherEnt getTeacherId() {
        return teacher_id;
    }

    public void setTeacherId(TeacherEnt teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, age, score, teacher_id);
    }
}

package com.cts.stm.dto;

public class TeacherDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private Integer studentscount;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public TeacherDTO(Integer id, String name, String surname, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public TeacherDTO(Integer id, String name, String surname, Integer age, String email, Integer studentscount) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.studentscount = studentscount;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStudentscount() {
        return studentscount;
    }

    public void setStudentscount(Integer studentscount) {
        this.studentscount = studentscount;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", studentscount=" + studentscount +
                '}';
    }
}

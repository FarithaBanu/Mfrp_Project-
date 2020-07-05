package com.cts.stm.dto;

public class StudentDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Integer score;
    private String t_name;
    private String t_surname;

    public StudentDTO() {
    }

    public StudentDTO(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public StudentDTO(Integer id, String name, String surname, Integer age,Integer score, String t_name, String t_surname ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.score=score;
        this.t_name = t_name;
        this.t_surname = t_surname;
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

	public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_surname() {
        return t_surname;
    }

    public void setT_surname(String t_surname) {
        this.t_surname = t_surname;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", t_name='" + t_name + '\'' +
                '}';
    }
}

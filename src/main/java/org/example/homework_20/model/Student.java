package org.example.homework_20.model;

import javax.xml.bind.annotation.*;


@XmlRootElement(name = "student")
@XmlAccessorType
public class Student {
    private String rollNo;
    private String firstName;
    private String lastName;
    private String nickName;
    private int marks;

    public Student() {
    }

    public Student(String rollNo, String firstName, String lastName, String nickName, int marks) {
        this.rollNo = rollNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.marks = marks;
    }

    @XmlAttribute(name = "rollNo")
    public String getRollNo() {
        return rollNo;
    }


    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @XmlElement(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "nickname")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @XmlElement(name = "marks")
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", marks=" + marks +
                '}';
    }
}

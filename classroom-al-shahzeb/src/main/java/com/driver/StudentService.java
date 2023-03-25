package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public String addStudent(Student student){
        return studentRepository.addStudent(student);
    }
    public String addTeacher(Teacher teacher){
        return studentRepository.addTeacher(teacher);
    }
    public String addStudentTeacherPair(String techerName, String studentName){
        return studentRepository.addStudentTeacherPair(techerName,studentName);
    }

    public Student getStudentByName(String name){
        return studentRepository.getStudentByName(name);
    }

    public Teacher getTeacherByName(String name){
        return studentRepository.getTeacherByName(name);
    }

    public List<String> getStudentsByTeacherName(String name){
        return studentRepository.getStudentsByTeacherName(name);
    }

    public List<String> getAllStudents(){
        return studentRepository.getAllStudents();
    }

    public String deleteTeacherByName(String name) {
        return studentRepository.deleteTeacherByName(name);
    }

    public String deleteAllTeachers(){
        return studentRepository.deleteAllTeachers();
    }
}

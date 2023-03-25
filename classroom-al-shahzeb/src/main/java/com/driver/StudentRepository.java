package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, Teacher> teacherHashMap = new HashMap<>();
    HashMap<String, List<String>> pairHashMap = new HashMap<>();

    public String addStudent(Student student){
        studentHashMap.put(student.getName(),student);
        return "Success";
    }

    public String addTeacher(Teacher teacher){
        teacherHashMap.put(teacher.getName(),teacher);
        return "Success";
    }

    public String addStudentTeacherPair(String techerName, String studentName){
        List<String> res=new ArrayList<>();
        if(pairHashMap.containsKey(techerName)){
            res = pairHashMap.get(techerName);
        }
        res.add(studentName);
        pairHashMap.put(techerName,res);
        return "Success";
    }

    public Student getStudentByName(String name){
        return studentHashMap.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teacherHashMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String name){
        return pairHashMap.get(name);
    }

    public List<String> getAllStudents(){
        List<String> students=new ArrayList<>();
        for(String s: studentHashMap.keySet())
            students.add(s);
        return students;
    }

    public String deleteTeacherByName(String name){
        List<String> list = pairHashMap.get(name);
        pairHashMap.remove(name);
        teacherHashMap.remove(name);
        for(String s: list)
            studentHashMap.remove(s);

        return "Success";
    }

    public String deleteAllTeachers(){

        for(List<String> str:pairHashMap.values()){
            for(String s: str){
                studentHashMap.remove(s);
            }
        }
        teacherHashMap.clear();
        pairHashMap.clear();
        return "Success";
    }
}

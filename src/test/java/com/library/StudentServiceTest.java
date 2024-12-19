package com.library;

import com.library.dao.StudentDAO;
import com.library.model.Student;
import com.library.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {
    private StudentService studentService;
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentService = new StudentService();
        studentDAO = new StudentDAO();
    }

    @Test
    void testAddStudent() {
        Student student = new Student(1,"Alice");
        studentService.addStudent(student);
        assertEquals(4, studentDAO.getAllStudents().size());
        assertEquals("Alice", studentDAO.getStudentById(1).getName());
    }


    @Test
    void testUpdateStudent() {
        Student student = new Student(2,"Alice");
        studentService.addStudent(student);
        student = studentService.findStudentById(2);
        student.setName("Alice Smith");
        studentService.updateStudent(student);
        assertEquals("Alice Smith", studentDAO.getStudentById(2).getName());
    }

    @Test
    void testGetAllStudents() {
        studentService.addStudent(new Student(3,"tarik"));
        studentService.addStudent(new Student(4,"bob"));
        assertEquals(3, studentDAO.getAllStudents().size());
    }

    @Test
    void testDeleteStudent() {
        studentService.deleteStudent(1);
        assertTrue(studentDAO.getStudentById(1) ==null);
    }

}

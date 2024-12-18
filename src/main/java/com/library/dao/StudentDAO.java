package com.library.dao;

import com.library.model.Student;
import com.library.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO {
    private  Connection connection;
    private static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());

    // constructeur par defaut
    public StudentDAO() {

    }

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStudent(Student student) {
        String query = "INSERT INTO students ( name) VALUES (?)";
        try  {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, student.getName());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de l'ajout de l'étudiant", e);
        }
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM students WHERE id = ?";
        try  {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(resultSet.getInt("id"), resultSet.getString("name"));
                } else {
                    LOGGER.log(Level.WARNING, "Aucun étudiant trouvé avec l'ID : " + id);
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de la récupération de l'étudiant", e);
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de la récupération des étudiants", e);
        }
        return students;
    }

    public void updateStudent(Student student) {
        String query = "UPDATE students SET name = ? WHERE id = ?";
        try {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de la mise à jour de l'étudiant", e);
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try  {
            connection = DbConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Erreur lors de la suppression de l'étudiant", e);
        }
    }
}

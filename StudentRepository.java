package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    private final JdbcTemplate jdbc;

    public StudentRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAll() {
        return jdbc.query(
            "SELECT id, name, age FROM students ORDER BY id",
            (rs, rowNum) -> new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age")
            )
        );
    }

    public Student findById(int id) {
        List<Student> result = jdbc.query(
            "SELECT id, name, age FROM students WHERE id = ?",
            (rs, rowNum) -> new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age")
            ),
            id
        );

        return result.isEmpty() ? null : result.get(0);
    }

    public int insert(Student student) {
        return jdbc.update(
            "INSERT INTO students(name, age) VALUES (?, ?)",
            student.getName(),
            student.getAge()
        );
    }

    public int update(int id, Student student) {
        return jdbc.update(
            "UPDATE students SET name = ?, age = ? WHERE id = ?",
            student.getName(),
            student.getAge(),
            id
        );
    }

    public int delete(int id) {
        return jdbc.update(
            "DELETE FROM students WHERE id = ?",
            id
        );
    }
}

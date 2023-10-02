package org.example.exam.repository;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.common.repository.BaseRepository;
import org.example.exam.entity.Exam;
import org.example.user.entity.User;
import org.example.user.entity.UserType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExamRepository extends BaseRepository<UUID, Exam> {
    public static String jdbcUrl = "jdbc:postgresql://localhost:5432/questions";
    public static String username = "postgres";
    public static String password = "2211";

    private static final ExamRepository examRepository = new ExamRepository();

    @SneakyThrows
    public static Connection connection() {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    @Override
    @SneakyThrows
    public Exam findById(UUID uuid) {
        String getByExamNameQuery = """
                select * from exam where id = ?;
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(getByExamNameQuery);
        preparedStatement.setObject(1, uuid);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            Exam exam = new Exam();

            exam.setId(UUID.fromString(id));
            exam.setName(name);

            connection().close();

            return exam;
        }
        return null;
    }

    @Override
    @SneakyThrows
    public List<Exam> getAll() {
        String getAllExamQuery = """
                select * from exam;
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(getAllExamQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            Exam exam = new Exam();

            exam.setId(UUID.fromString(id));
            exam.setName(name);

            entities.put(exam.getId(), exam);
        }
        return entities.values().stream().toList();
    }

    @Override
    @SneakyThrows
    public void delete(UUID uuid) {
        String deleteExamQuery = """
                delete from exam
                where id = ?
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(deleteExamQuery);
        preparedStatement.setObject(1, uuid);

        preparedStatement.executeUpdate();
    }
    @SneakyThrows
    public void updateExamByExamId(UUID id, String name){

        String updateExamQuery = """
                update exam 
                set name = ?
                where id = ?; 
                """;
        PreparedStatement preparedStatement = connection().prepareStatement(updateExamQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setObject(2, id);

        preparedStatement.executeUpdate();
        connection().close();
    }

    @Override
    @SneakyThrows
    public Exam add(Exam entity) {
        // create yozish kerak
        return super.add(entity);
    }

    public static ExamRepository getInstance() {
        return examRepository;
    }

}

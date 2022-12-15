package ru.levelup.lesson7.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.lesson7.dao.DepartmentDao;
import ru.levelup.lesson7.model.Department;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class DepartmentDaoImpl implements DepartmentDao {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<Department> departmentRowMapper =
            (rs, row) -> new Department(rs.getInt("id"), rs.getString("name"));

    @Override
    public List<Department> findAll() {
        //language=SQL
        final String sql = "SELECT d.id, d.name FROM department d";
        return jdbcOperations.query(sql, departmentRowMapper);
    }

    @Override
    public Optional<Department> getById(int departmentId) {
        //language=SQL
        String sql = "SELECT d.id, d.name FROM department d " +
                "where d.id = :departmentId";
        try {
            return Optional.of(jdbcOperations.queryForObject(sql, Map.of("departmentId", departmentId), departmentRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(Department department) {
        //language=SQL
        final String sqlQuery = "insert into department (id, name) values (:id, :name)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = department.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", department.getName(), Types.VARCHAR);
        jdbcOperations.update(sqlQuery, namedParameters);
        return id;
    }

    @Override
    public void update(Department department) {
        //language=SQL
        final String sqlQuery = "update department set name = :name " +
                "where id = :departmentId";
        jdbcOperations.update(sqlQuery, Map.of(
                "departmentId", department.getId(),
                "name", department.getName()));
    }

    @Override
    public void deleteById(int departmentId) {
        //language=SQL
        String sqlQuery = "delete from department d where d.id = :departmentId";
        jdbcOperations.update(sqlQuery, Map.of("departmentId", departmentId));
    }
}

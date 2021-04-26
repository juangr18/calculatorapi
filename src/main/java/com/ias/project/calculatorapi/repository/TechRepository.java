package com.ias.project.calculatorapi.repository;

import com.ias.project.calculatorapi.domain.Tech;
import com.ias.project.calculatorapi.domain.TechHour;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class TechRepository{
    private final DataSource dataSource;

    public TechRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void storeTech(Tech tech){
        String sql = "INSERT INTO TECH(id, idTech, idService, horaInicio, horaFinal) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,tech.getId().toString());
            ps.setString(2,tech.getIdTech());
            ps.setString(3,tech.getIdService());
            ps.setNString(4,tech.getHoraInicial().toString());
            ps.setNString(5,tech.getHoraFinal().toString());
            ps.execute();
        }catch (SQLException sqlException){
            throw new RuntimeException("Create tech get error.");
        }
    }


    public List<Tech> listTech(){
        String sql = "SELECT * FROM TECH;";
        try(Connection connection = dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<Tech> teches = new ArrayList<>();
            while (resultSet.next()){
                Tech tech = getTechFromResultset(resultSet);
                teches.add(tech);
            }
            return teches;
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
            return List.of();
        }
    }

    private Tech getTechFromResultset(ResultSet resultSet) throws SQLException {
        String idString = resultSet.getString("id");
        String idTech = resultSet.getString("idTech");
        String idService = resultSet.getString("idService");
        LocalDateTime horaInicio = resultSet.getTimestamp("horaInicio").toLocalDateTime();
        LocalDateTime horaFinal = resultSet.getTimestamp("horaFinal").toLocalDateTime();
        UUID id = UUID.fromString(idString);
        return new Tech(id, idTech, idService, horaInicio, horaFinal);
    }

    private TechHour getTechFromResultsetComplete(ResultSet resultSet) throws SQLException {
        String idString = resultSet.getString("id");
        String idTech = resultSet.getString("idTech");
        String idService = resultSet.getString("idService");
        LocalDateTime horaInicio = resultSet.getTimestamp("horaInicio").toLocalDateTime();
        LocalDateTime horaFinal = resultSet.getTimestamp("horaFinal").toLocalDateTime();
        UUID id = UUID.fromString(idString);
        int horas=resultSet.getInt("horas");
//        int nocturnas=resultSet.getInt("nocturnas");
//        int dominicales=resultSet.getInt("dominicales");
//        return new TechHour(id, idTech, idService, horaInicio, horaFinal,horas,nocturnas,dominicales);
        return new TechHour(id, idTech, idService, horaInicio, horaFinal,horas);
    }

    public List<TechHour> findTechByIdTechAndWeek(String id, String week){
        String sql="SELECT *,DATEDIFF(hour,horaInicio,horaFinal) AS horas FROM tech WHERE idTech=? AND WEEK(horaInicio)=? AND WEEK(horaFinal)=?";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id);
            preparedStatement.setString(2, week);
            preparedStatement.setString(3, week);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TechHour> teches = new ArrayList<>();
            while(resultSet.next()){
                TechHour techFilter = getTechFromResultsetComplete(resultSet);
                teches.add(techFilter);
            }
            return teches;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            throw new RuntimeException("Query no result by id = "+id);
        }
    }
    public Optional<Tech> findTechById(UUID id){
        String sql = "SELECT * FROM TECH WHERE id = ?";
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,id.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Tech techResult = getTechFromResultset(resultSet);
                return Optional.of(techResult);
            }
            else {
                return Optional.empty();
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
            throw new RuntimeException("Query no result by id = " + id);
        }
    }

    public void deleteTech(UUID id){
        String sql = "DELETE FROM TECH WHERE id= ?;";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id.toString());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Option delete error: " + id, throwables);
        }
    }
}

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class FootballTeams extends Employees {
    private Integer id;
    private String name;
    private Integer placeInTheRanking;

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

    public Integer getPlaceInTheRanking() {
        return placeInTheRanking;
    }

    public void setPlaceInTheRanking(Integer placeInTheRanking) {
        this.placeInTheRanking = placeInTheRanking;
    }

    public void updateTeamsPlayerOrCoaches(Employees employees) {
        System.out.println("Выберите действие");
        System.out.println("Игрок меняет команду");
        System.out.println("Тренер меняет команду");
        String choice = sc.nextLine();
        switch (choice) {
            case "Игрок меняет команду":
                String sqlUpdatePlayer = "update \"football\".employees set football_team_id = ? where id = ? and employees.job_title like ('Игрок')";
                try {
                    PreparedStatement preparedStatement = connection().prepareStatement(sqlUpdatePlayer);
                    preparedStatement.setInt(2, employees.getId());
                    preparedStatement.setInt(1, employees.getFootballTeamId());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "Тренер меняет команду":
                String sqlUpdateCoach = "update \"football\".employees set football_team_id = ? where id = ? and employees.job_title like ('Тренер')";
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection().prepareStatement(sqlUpdateCoach);
                    preparedStatement.setInt(2, employees.getId());
                    preparedStatement.setInt(1, employees.getFootballTeamId());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                System.err.println("Введите действие из меню");
        }
    }

    public void deleteFootballTeam() {

    }
}

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
        System.out.println("�������� ��������");
        System.out.println("����� ������ �������");
        System.out.println("������ ������ �������");
        String choice = sc.nextLine();
        switch (choice) {
            case "����� ������ �������":
                String sqlUpdatePlayer = "update \"football\".employees set football_team_id = ? where id = ? and employees.job_title like ('�����')";
                try {
                    PreparedStatement preparedStatement = connection().prepareStatement(sqlUpdatePlayer);
                    preparedStatement.setInt(2, employees.getId());
                    preparedStatement.setInt(1, employees.getFootballTeamId());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "������ ������ �������":
                String sqlUpdateCoach = "update \"football\".employees set football_team_id = ? where id = ? and employees.job_title like ('������')";
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
                System.err.println("������� �������� �� ����");
        }
    }

    public void deleteFootballTeam() {
        String sqlDeleteFootballTeam = "delete " +
                "from \"football\".football_teams ft2 " +
                "where ft2.id in (select ft.id " +
                "                 from \"football\".football_teams ft " +
                "                          left outer join \"football\".employees e on ft.id = e.football_team_id " +
                "                 group by ft.name, ft.id " +
                "    having count(e.job_title) = 0)";
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(sqlDeleteFootballTeam);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

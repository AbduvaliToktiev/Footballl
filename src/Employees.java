import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employees extends Connect {
    private Integer id;
    private String FIO;
    private Integer footballTeamId;
    private Integer Salary;

    public Integer getId() {
        System.out.println("Введите id игрока/тренера");
        return sc.nextInt();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public Integer getFootballTeamId() {
        System.out.println("Введите id команды для перехода");
        return sc.nextInt();
    }

    public void setFootballTeamId(Integer footballTeamId) {
        this.footballTeamId = footballTeamId;
    }

    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public void CountPlayerTeams() {
        String sql = "select ft.name, count(e.fio) " +
                "from \"football\".employees e " +
                "inner join \"football\".football_teams ft on ft.id = e.football_team_id " +
                "where job_title = 'Игрок' " +
                "group by ft.name ";
        try {
            Statement statement = connection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name") + " " + resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void coachesTeams() {
        String sqlCoaches = "select " +
                "e.id, e.fio, e.job_title, ft.name, e.salary " +
                "from \"football\".employees e " +
                "inner join football.football_teams ft on e.football_team_id = ft.id " +
                "where job_title like 'Тренер'";
        try {
            Statement statement = connection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCoaches);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("fio") + " " +
                        resultSet.getString("job_title") + " " + resultSet.getString("name") + " " +
                        resultSet.getInt("salary"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void countEmployeesExceptForPlayersAndCoaches() {
        String sqlCountEmployees = "select e.job_title, count(e.job_title)from \"football\".employees e " +
                "where job_title != 'Игрок' and  job_title != 'Тренер' " +
                "group by e.job_title";
        Statement statement = null;
        try {
            statement = connection().createStatement();
            ResultSet resultSet = statement.executeQuery(sqlCountEmployees);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("job_title") + " " + resultSet.getInt("count"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

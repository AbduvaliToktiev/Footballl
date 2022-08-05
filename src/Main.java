public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.connection();
        Employees employees = new Employees();
        FootballTeams footballTeams = new FootballTeams();
      //  employees.CountPlayerTeams(); // Метод для количества игроков в командах
       // employees.coachesTeams(); // Метод для информации о всех тренирах
        footballTeams.updateTeamsPlayerOrCoaches(employees); // Метод для изменения команды у тренеров и футболистов
       // employees.countEmployeesExceptForPlayersAndCoaches(); // Метод для вывода всех сотрудников кроме футболистов и тренеров
        // footballTeams.deleteFootballTeam(); // Метод для удаления команды если нет сотрудников
        employees.deletePlayerSalaryBig();
    }
}

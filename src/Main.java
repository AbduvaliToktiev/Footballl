public class Main {
    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.connection();
        Employees employees = new Employees();
        FootballTeams footballTeams = new FootballTeams();
      //  employees.CountPlayerTeams(); // ����� ��� ���������� ������� � ��������
       // employees.coachesTeams(); // ����� ��� ���������� � ���� ��������
        footballTeams.updateTeamsPlayerOrCoaches(employees); // ����� ��� ��������� ������� � �������� � �����������
       // employees.countEmployeesExceptForPlayersAndCoaches(); // ����� ��� ������ ���� ����������� ����� ����������� � ��������
        // footballTeams.deleteFootballTeam(); // ����� ��� �������� ������� ���� ��� �����������
        employees.deletePlayerSalaryBig();
    }
}

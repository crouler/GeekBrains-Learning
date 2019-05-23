import java.util.Arrays;

public class Team {

    public String teamName;
    Player [] teamArray;
    final public static  Player player1 = new Player("Dima", 800, 2, 25, false);
    final public static  Player player2 = new Player("Vova", 300, 5, 15, false);
    final public static  Player player3 = new Player("Pasha", 150, 2, 50, false);
    final public static  Player player4 = new Player("Sergey", 5000, 7, 1000, false);



    public Team(String teamName, Player[] teamArray) {
        this.teamName = teamName;
        this.teamArray = teamArray;

    }
    public Player[] teamPlayerArray(){
        return this.teamArray;

    }

    public StringBuilder teamPlayersNames(Player[] teamArray){
        StringBuilder players = new StringBuilder();
        for (int i = 0; i < teamArray.length; i++) {
            players.append(teamArray[i].name).append(" ,");
        }
        return players;
    }

    @Override
    public String toString() {
        return "Team{" +
                teamPlayersNames(teamArray)+
                '}';
    }




}

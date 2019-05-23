public class Main {

    public static void main(String[] args) {
        Player [] argo = new Player[4];
        argo[0] = Team.player1;
        argo[1] = Team.player2;
        argo[2] = Team.player3;
        argo[3] = Team.player4;
        Team newTeam = new Team("Commando", argo);
        Course course = new Course(1,300,1);

//        Player tmp = new Player("Tolya",500, 2, 400,false);
        System.out.println(newTeam.toString());
        course.showCourse();
        //argo[0].playerInfo(argo[0]);



//        System.out.println("argo 1 jump = "+argo[0].jump());
        course.teamDoIt(newTeam);





        //System.out.println(team.toString());
    }
}


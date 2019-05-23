public class Course {

    public int courseRunDistance;
    public double courseJumpDistance;
    public int courseSwimDistance;


    public Course(int courseRunDistance, double courseJumpDistance, int courseSwimDistance) {
        this.courseRunDistance = courseRunDistance;
        this.courseJumpDistance = courseJumpDistance;
        this.courseSwimDistance = courseSwimDistance;
    }

    public void teamDoIt(Team team) {
        boolean result = false;
        Player [] playerArr =  team.teamPlayerArray();

        for (int i = 0; i < playerArr.length; i++) {            // проверка преодоления дистанции бега

                if (playerArr[i].run() >= courseRunDistance) {
                    result = true;
                }

        }

            if (result){System.out.println("Все игроки пробежали дистанцию " + courseRunDistance + " метров");}
            result = false;

        for (int i = 0; i < playerArr.length; i++) {

            if (playerArr[i].jump() >= courseJumpDistance) {
                result = true;
            }

        }

        if (result){System.out.println("Все игроки преодолели ров шириной " + courseJumpDistance + " метра(ов)");}
        result = false;

        for (int i = 0; i < playerArr.length; i++) {

            if (playerArr[i].swim() >= courseSwimDistance) {
                result = true;
            }

        }

        if (result){System.out.println("Все игроки проплыли дистанцию " + courseSwimDistance + " метров");}


        if (result) {
            System.out.println("Команда прошла полосу препятствий УСПЕШНО !!!");

        } else {
            System.out.println("Команда не  прошла полосу препятствий");
        }
    }

    public void showCourse(){

        System.out.println("Дистанция забега - " + courseRunDistance + " м.; Ширина рва " + courseJumpDistance +" м.;  Дистанция заплыва " + courseSwimDistance + " м.;");
    }

}

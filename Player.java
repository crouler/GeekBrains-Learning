    public class Player implements Actions{
        public String name;
        public int runDistance;
        public double jumpDistance;
        public int swimDistance;
        public boolean successDistancePassing;

        public Player(String name, int runDistance, int jumpDistance, int swimDistance, boolean successDistancePassing) {
            this.name = name;
            this.runDistance = runDistance;
            this.jumpDistance = jumpDistance;
            this.swimDistance = swimDistance;
            this.successDistancePassing = successDistancePassing;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "Имя = " + name  +
                    ", длина бега = " + runDistance +
                    ", длина прыжка = " + jumpDistance +
                    ", длина заплыва = " + swimDistance +
                    '}';
        }

        public void playerInfo(Player player){
            System.out.println("Имя: " + player.name + "; Дистанция бега: " + player.runDistance + "; Дистанция прыжка: " + player.jumpDistance +"; Дистанция плавания: " + player.swimDistance);
        }

        @Override
        public int run() {
            return this.runDistance;
        }

        @Override
        public double jump(){
            return this.jumpDistance;

        }

        @Override
        public int swim() {
            return this.swimDistance;

        }
    }


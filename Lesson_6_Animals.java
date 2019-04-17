
public class Lesson_6_Animals {
    public abstract class Animal {      // создание общего абстртрактного класса
        protected String name;
        protected int maxJump;
        protected int maxRun;

        public abstract void voice();

        public Animal(String name, int maxJump, int maxRun) {
            this.name = name;
            this.maxJump = maxJump;
            this.maxRun = maxRun;
        }


    }

    class Cat extends Animal {        // создание расширения абстртрактного класса до Cat
        int milk;

        public Cat(String name, int maxJump, int maxRun, int milk) {
            super(name, maxJump, maxRun);
            this.milk = milk;
        }

        public void voice() {                   // определение абстрактного метода из родительского класса
            System.out.println("Meow!!!");
        }
    }


    public void main(String[] args) {
        int run = 30;
        Cat cat01 = new Cat("Kitty", 10, 30, 15);
        System.out.println( " Побеждает "+ cat01.name + " вылакав "+ cat01.milk+ "мл. молока");


    }

}



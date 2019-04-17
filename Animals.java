package Lesson6Animals;
import java.util.Scanner;



abstract class Animals {      // создание общего абстртрактного класса
    protected String name;
    protected double maxJump;
    protected int maxRun;

    abstract void voice();                       // задание абстрактных методов
    abstract boolean swim(int swimLn);

    protected Animals(String name, double maxJump, int maxRun) {       // конструктор абстрактного класса
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }
    boolean run(int runLn){                                             // параметр метода - длина дистанции
        return this.maxRun > runLn;                                     // вывод - boolean
    }
    boolean jump(double jumpLn){                                        // параметр метода - длина дистанции
        return this.maxJump > jumpLn;                                   // вывод - boolean
    }
}

    class Cat extends Animals {                     // создание расширения абстртрактного класса до Cat
    int milk;

    public Cat(String name, double maxJump, int maxRun, int milk) {     // конструктор класса
        super(name, maxJump, maxRun);
        this.milk = milk;
    }

        @Override                                   // переопределение  метода из родительского класса (есть отличия в методе у Cat и Dog)
        void voice() {
            System.out.println("  Meow!!!");
        }

        @Override                                   // переопределение  метода из родительского класса (есть отличия в методе у Cat и Dog)
        boolean swim(int swimLn) {
            return false;
        }
}

    class Dog extends Animals{
        int swim;
        public Dog(String name, double maxJump, int maxRun, int swim) {     // конструктор класса
        super(name, maxJump, maxRun);
        this.swim = swim;
    }

        @Override                                       // переопределение  метода из родительского класса (есть отличия в методе у Cat и Dog)
        void voice() {
            System.out.println("   Pow!!! Pow!!! ");
        }

        @Override                                       // переопределение  метода из родительского класса (есть отличия в методе у Cat и Dog)
        boolean swim(int swimLn) {
            return this.swim > swimLn;
        }

}


class MainAnimals{

//    public static void animalJump(Cat cat, Dog dog01, Dog dog02){       // определение  метода проверки прыжков
//        System.out.println("Выставите длину прыжка 0 - 200 cм ");
//        Scanner sc = new Scanner(System.in);
//        double length = sc.nextDouble();
//
//        System.out.println("Рез-ты прожождения - "+ cat.name + " -> " + cat.jump(length) ); if (cat.jump(length)) cat.voice();
//        System.out.println("Рез-ты прожождения - "+ dog01.name + " -> " + dog01.jump(length) ); if(dog01.jump(length)) dog01.voice();
//        System.out.println("Рез-ты прожождения - "+ dog02.name + " -> " + dog02.jump(length) ); if(dog02.jump(length)) dog02.voice();
//        System.out.println();
//    }
        public static void animalJump(Animals[]array){
            System.out.println("Выставите длину прыжка 0 - 2 м (разделитель - запятая)");
            Scanner sc = new Scanner(System.in);
            double length = sc.nextDouble();
            for (int i = 0; i <array.length; i++) {
                System.out.println("Рез-ты прожождения - "+ array[i].name + " -> " + array[i].jump(length)); if (array[i].jump(length)) array[i].voice();
            }
        }



    public static void animalRun(Animals[]array){             // определение  метода проверки бега
        int ln = 0;
        System.out.println("Выставите длину дистанции бега  0 - 600 м ");
        Scanner scInt = new Scanner(System.in);
        ln = scInt.nextInt();
        for (int i = 0; i <array.length; i++) {                 // цикл по массиву животных

            System.out.println("Рез-ты прожождения - " + array[i].name + " -> " + array[i].run(ln));
            if (array[i].run(ln)) array[i].voice();
            }
    }

    public static void animalSwim(Animals[]array){            // определение  метода проверки прыжков
        int swimDistance;
        System.out.println("Выставите длину дистанции заплыва  0 - 15 м ");
        System.out.println("Кто-то ведь должен доплыть?! ");
        Scanner scInt = new Scanner(System.in);
        swimDistance = scInt.nextInt();

        for (int i = 0; i <array.length; i++) {

            System.out.println("Рез-ты прожождения - " + array[i].name + " -> " + array[i].swim(swimDistance));
            if (array[i].swim(swimDistance)) array[i].voice();
        }

    }


    public static void main(String[] args) {                                    // точка входа

        Cat cat = new Cat("Kitty", 2, 200, 15);
        Dog dog01 = new Dog("Scotland Setter",0.5,400, 10);
        Dog dog02 = new Dog("Scotland Getter",0.7,600, 15);

        Animals [] homeAnimals = {cat, dog01, dog02};                           // полиморфизм ёООПта помещение в массив


        animalJump(homeAnimals);
        animalRun(homeAnimals);
        animalSwim(homeAnimals);
    }
}

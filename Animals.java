package Lesson6Animals;
import java.util.Scanner;



public abstract class Animals {      // создание общего абстртрактного класса
    protected String name;
    protected double maxJump;
    protected int maxRun;

    public abstract void voice();                       // задание абстрактных методов
    public abstract boolean run(int runLn);
    public abstract boolean jump(double jumpLn);
    public abstract boolean swim(int swimLn);

    public Animals(String name, double maxJump, int maxRun) {       // конструктор класса
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }
}

    class Cat extends Animals {        // создание расширения абстртрактного класса до Cat
    int milk;

    public Cat(String name, double maxJump, int maxRun, int milk) {
        super(name, maxJump, maxRun);
        this.milk = milk;
    }

    public void voice() {                   // определение  метода из родительского класса
        System.out.println("  Meow!!!");
    }
    public boolean run(int runLn){          // определение  метода из родительского класса
       return this.maxRun > runLn;
    }
    public boolean jump(double jumpLn){     // определение  метода из родительского класса
       return this.maxJump > jumpLn;
    }
    public boolean swim(int swimLn){        // определение  метода из родительского класса
        return false;                       // кот всегда не умеет плавать
    }


}

class Dog extends Animals{
    int swim;
    public Dog(String name, double maxJump, int maxRun, int swim) {     // конструктор класса
        super(name, maxJump, maxRun);
        this.swim = swim;
    }

        public void voice (){                           // определение  метода из родительского класса
        System.out.println("   Pow!!! Pow!!! ");
    }

    public boolean run(int runLn){                      // определение  метода из родительского класса
        return this.maxRun > runLn;
    }
    public boolean jump(double jumpLn){                 // определение  метода из родительского класса
        return this.maxJump > jumpLn;
    }
    public boolean swim(int swimLn){                    // определение  метода из родительского класса
        return this.swim > swimLn;
    }
}


class MainAnimals{

    public static void animalJump(Cat cat, Dog dog01, Dog dog02){       // определение  метода проверки прыжков
        System.out.println("Выставите длину прыжка 0 - 200 cм ");
        Scanner sc = new Scanner(System.in);
        double length = sc.nextDouble();

        System.out.println("Рез-ты прожождения - "+ cat.name + " -> " + cat.jump(length) ); if (cat.jump(length)) cat.voice();
        System.out.println("Рез-ты прожождения - "+ dog01.name + " -> " + dog01.jump(length) ); if(dog01.jump(length)) dog01.voice();
        System.out.println("Рез-ты прожождения - "+ dog02.name + " -> " + dog02.jump(length) ); if(dog02.jump(length)) dog02.voice();
        System.out.println();
    }

    public static void animalRun(Cat cat,Dog dog01, Dog dog02){             // определение  метода проверки бега
        int ln = 0;
        System.out.println("Выставите длину дистанции бега  0 - 600 м ");
        Scanner scInt = new Scanner(System.in);
        ln = scInt.nextInt();

        System.out.println("Рез-ты прожождения - "+ cat.name + " -> " + cat.run(ln)); if (cat.run(ln)) cat.voice();
        System.out.println("Рез-ты прожождения - "+ dog01.name + " -> " + dog01.run(ln)); if(dog01.run(ln)) dog01.voice();
        System.out.println("Рез-ты прожождения - "+ dog02.name + " -> " + dog02.run(ln)); if(dog02.run(ln)) dog02.voice();
        System.out.println();
    }

    public static void animalSwim(Cat cat,Dog dog01, Dog dog02){            // определение  метода проверки прыжков
        int swimDistance = 0;
        System.out.println("Выставите длину дистанции заплыва  0 - 15 м ");
        System.out.println("Кто-то ведь должен доплыть?! ");
        Scanner scInt = new Scanner(System.in);
        swimDistance = scInt.nextInt();

        System.out.println("Рез-ты прожождения - "+ cat.name + " -> " + cat.swim(swimDistance)); if (cat.swim(swimDistance)) cat.voice();
        System.out.println("Рез-ты прожождения - "+ dog01.name + " -> " + dog01.swim(swimDistance)); if(dog01.swim(swimDistance)) dog01.voice();
        System.out.println("Рез-ты прожождения - "+ dog02.name + " -> " + dog02.swim(swimDistance)); if(dog02.swim(swimDistance)) dog02.voice();
        System.out.println();
    }


    public static void main(String[] args) {                                    // точка входа
        Cat cat = new Cat("Kitty", 200, 200, 15);
        Dog dog01 = new Dog("Setter",50,400, 10);
        Dog dog02 = new Dog("Getter",70,600, 15);

        animalJump(cat, dog01, dog02);
        animalRun(cat, dog01, dog02);
        animalSwim(cat, dog01, dog02);
    }
}

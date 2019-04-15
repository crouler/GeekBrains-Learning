package Lesson_5;

public class main_5 {

    public void main(String[] args) {

        Employee[] emplArray = new Employee[4];
        emplArray[0] = new Employee("IvanIvanov", "worker", "ivanov@e-mail.com", "78981231111", 50000, 45);
        emplArray[1] = new Employee("MariaIvanova", "accountant", "ivanova@e-mail.com", "78981232222", 50000, 42);
        emplArray[2] = new Employee("AntonGianti", "manager", "gianti@e-mail.com", "78981233333", 55000, 32);
        emplArray[3] = new Employee("SergeyPapanin", "director", "papanin@e-mail.com", "78981234444", 75000, 54);
        emplArray[4] = new Employee("SashaPetrov", "courier", "petrov@e-mail.com", "78981237777", 25000, 19);


        for (int i = 0; i < 4; i++) {
            if (emplArray[i].age > 40) {
                emplArray[i].info();
            }

        }
    }
}
    class Employee {

        String fio;
        String position;
        String email;
        String phoneNumber;
        int wage;
        int age;

        public Employee(String fio, String position, String email, String phoneNumber, int wage, int age) {
            this.fio = fio;
            this.position = position;
            this.email = email;
            this.phoneNumber = phoneNumber;
            this.wage = wage;
            this.age = age;
        }


        public void info() {
            System.out.println(fio + " | " + position + " | " + age + " | ");


        }
//    class empleArray{
//        Employee description;
//
//        public empleArray(Employee description) {
//            this.description = description;
//        }
    }






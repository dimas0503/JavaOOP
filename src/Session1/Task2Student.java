package Session1;

import session2.Student;

/**
 * Created by dchernetskyi on 26.09.2015.
 */
public class Task2Student {
    private String name;
    private int age;
    private String gender;
    private int motivation;

    Task2Student(){
        boolean label = true;
        http://www.jon.com.ua
        while (true){
            if (label){
                break http;
            }
        }
    }
    Task2Student(String name, int age, String gender, int motivation){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.motivation = motivation;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getMotivation() {
        return motivation;
    }
    public void setMotivation(int motivation) {
        this.motivation = motivation;
    }

    @Override
    public String toString(){
        System.out.println(
                "Student name: " + this.name + '\n'
                + "age: " + this.age + '\n'
                + "gender: " + this.gender + '\n'
                + "motivation" + this.motivation);
        return null;
    }



    @Override
    public boolean equals(Object student){
        Task2Student student1 = (Task2Student) student;
        if ((this.age == student1.getAge()) &&
                (this.gender == student1.getGender()) &&
                (this.motivation == student1.getMotivation()) &&
                (this.name.compareTo(student1.getName()) == 0)) return true;
        else return false;
    }
}

package session2;

/**
 * Created by dchernetskyi on 27.09.2015.
 */
public class Student {
    private String name;
    private int age;
    private String gender;
    private int motivation;

    Student(){
        //http://www.jon.com.ua
        //TODO make compilable
    }

    Student(String name, int age, String gender, int motivation){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.motivation = motivation;
    }

    Student(String name, int age){
        this.name = name;
        this.age = age;
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

    public int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object student){
        Student student1 = (Student) student;
        if (hashCode() == student.hashCode()){
            return true;
        }else {
            return false;
        }
/*
        if (this.age == student1.getAge()){
            return true;
        }else{
            return false;
        }
*/
    }

    @Override
    public int hashCode(){
        return name.hashCode()+age+gender.hashCode()+motivation;
    }
}

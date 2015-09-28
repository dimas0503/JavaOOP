package Session1;

/**
 * Created by dchernetskyi on 26.09.2015.
 */
public class Task2Student {
    private String name;
    private int age;
    private String gender;
    private int motivation;

    Task2Student(){
        //http://www.jon.com.ua
        //TODO make compilable

    }

    Task2Student(String name, int age, String gender, int motivation){
        this.name = name;
        this.age = age;
        this.gender = gender;
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


    public int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object student){
        Task2Student student1 = (Task2Student) student;
        if (this.age == student1.getAge()){
            return true;
        }else{
            return false;
        }
    }
}

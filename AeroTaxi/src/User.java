


import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Objects;

public class User implements Serializable {

    private String password;
    private transient String passwordValidation;
    private transient int dniValidation;

    private String name;
    private String surname;
    private int dni;
    private int age;


    public User(){}

    public User(String password, String passwordValidation, int dniValidation, String name, String surname, int dni, int age) {
        this.password = password;
        this.passwordValidation = passwordValidation;
        this.dniValidation = dniValidation;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.age = age;
    }

    public void setName(String name) {this.name = name;}
    public String getName(){return this.name;}
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getSurname(){return this.surname;}


    public void setDni(int dni){this.dni = dni;}
    public int getDni(){return this.dni;}


    public void setAge(int age){this.age = age;}
    public int getAge(){return this.age;}

    // --------
    public void setPassword(String password){this.password = password;}
    public String getPassword(){return this.password;}


    public void setPasswordValidation(String passwordValidation){this.passwordValidation = passwordValidation;}
    public String getPasswordValidation(){return this.passwordValidation;}


    public void setDniValidation(int dniValidation){this.dniValidation = dniValidation;}
    public int getDniValidation(){return this.dniValidation;}
    // --------





    @Override
    public String toString() {
        return "User{" +
                "name='" + name +
                ", surname='" + surname +
                ", dni=" + dni +
                ", age=" + age +
                '}';
    }
}

package User;

import User.Exceptions.AgeNotValidException;
import User.Exceptions.DniNotValidException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;

public class User{

    private String userName;
    private String password = ""; // para poder comparar


    private String name;
    private String surname;
    private int dni;
    private int age;


    public User(){}


    public void setName(String name) {this.name = name;}

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public void setDni(int dni) throws DniNotValidException {
        if(dni == 0){
            throw new DniNotValidException("Only numbers");
        }
        else{
            this.dni = dni;
        }
    }


    public void setAge(int age) throws AgeNotValidException {
        if(age == 0){
            throw new AgeNotValidException("Only numbers");
        }
        else{
            this.age = age;
        }
    }


    public int getAge(){return this.age;}

    //
    public void setUserName(String userName){this.userName = userName;}

    public void setPassword(String password){this.password = password;}


    public String getPassword(){return this.password;}
    //





    @Override
    public String toString() {
        return "User{" +
                "name='" + name +
                ", surname='" + surname +
                ", dni=" + dni +
                ", age=" + age +
                ", [userName]=" + userName +
                '}';
    }
}

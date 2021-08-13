public class Person {

    //ATTRIBUTES
    protected String name;
    protected String surname;


    //NO-ARGUMENT CONSTRUCTOR
    public Person() {
    }


    //ARGUMENT CONSTRUCTOR
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }



    //TOSTRING METHOD
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

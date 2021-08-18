import java.util.ArrayList;

public class Hero extends Person {

    //Attributes/Properties
    private int heroID;
    private String heroName;
    private double heroSalary;
    private int deedTime;


    //no-argument constructor
    public Hero() {
    }


    //argument constructor
    public Hero(String name, String surname, int heroId, String heroName, double heroSalary, int deedTime) {
        this.name = name;
        this.surname = surname;
        this.heroID = heroId;
        this.heroName = heroName;
        this.heroSalary = heroSalary;
        this.deedTime = deedTime;

    }

    //custom methods


    //toString() is the method where information about the object values are returned as String value.
    @Override
    public String toString() {
        return "HERO: " +
                "Name - '" + name + '\'' +
                " | Surname - '" + surname + '\'' +
                " | HeroID - '" + heroID + '\'' +
                " | HeroName - '" + heroName + '\'' +
                " | HeroSalary (Eur) - '" + heroSalary + '\'' +
                " | DeedTime (h/week) - '" + deedTime + '\'' +
                '|';
    }

    //calculatedLevel() is the method where hero level is calculated:
    public int calculatedLevel() {
        if (deedTime < 20) {
            return 1;
        } else if ((deedTime >= 20) && (deedTime < 40)) {
            return 2;
        } else if (deedTime >= 40){
            return 3;
        } else {
            return 0;
        }
    }


    //calculated salary based on deedTime (currently only for userHero)
    public double calculatedSalary() {
        int hourlyRate = 35;
        return deedTime*hourlyRate;
    }


    //add get and set methods to the class
    public int getHeroID() {
        return heroID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public double getHeroSalary() {
        return heroSalary;
    }

    public void setHeroSalary(double heroSalary) {
        this.heroSalary = heroSalary;
    }

    public int getDeedTime() {
        return deedTime;
    }

    public void setDeedTime(int deedTime) {
        this.deedTime = deedTime;
    }

}
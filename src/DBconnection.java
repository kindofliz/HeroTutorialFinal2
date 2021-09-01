import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DBconnection {


    Scanner scanner = new Scanner(System.in);

    private Connection conn;

    public DBconnection() {

        try {
            String dbUrl = "jdbc:sqlite:hero.db";
            conn = DriverManager.getConnection(dbUrl);

            // CREATING A TABLE for HEROES
            Statement statement = conn.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS heroes"+
                            " (heroID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "name TEXT NOT NULL, " +
                            "surname TEXT NOT NULL, " +
                            "heroName TEXT NOT NULL, " +
                            "heroSalary INTEGER NOT NULL, " +
                            "deedTime INTEGER NOT NULL)";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }


        try {

            // CREATING A TABLE for DISTRICTS
            Statement statement = conn.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS districts"+
                            " (districtID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "title TEXT NOT NULL, " +
                            "city TEXT NOT NULL, " +
                            "person_in_the_district TEXT NOT NULL)";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }


        try {

            // CREATING A TABLE for VILLAINS
            Statement statement = conn.createStatement();
            String sqlStatement =
                    "CREATE TABLE IF NOT EXISTS villains"+
                            " (villainsID INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "name TEXT NOT NULL, " +
                            "surname TEXT NOT NULL, " +
                            "villainName TEXT NOT NULL, " +
                            "villainSalary INTEGER NOT NULL, " +
                            "crimeTime INTEGER NOT NULL)";
            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Database issues" + exception);
        }

    }



    //Method to print all districts and their info
    public ArrayList<District> getDistricts() {

        //Creating arraylist to hold all districts
        ArrayList<District> districtList= new ArrayList<District>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM districts";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new District object
                District district = new District();
                district.setDistrictID(rs.getInt("districtID"));
                district.setTitle(rs.getString("title"));
                district.setCity(rs.getString("city"));
//                district.setPersonInTheDistrict(rs.getString("person_in_the_district"));


                System.out.println(district.toString());
            }



        } catch (SQLException exception) {
            System.out.println("Error getting District list: " + exception);
        }

        return districtList;
    }

    //Method to show only district names
    public ArrayList<District> getDistrictNames() {

        ArrayList<District> districtList = new ArrayList<District>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT title FROM districts";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new District object
                District district = new District();
                district.setTitle(rs.getString("title"));

                System.out.println(district.getTitle());
            }


        } catch (SQLException exception) {
            System.out.println("Error getting District list: " + exception);
        }
        return districtList;
    }

    //Method to create a new District in DB
    public void createDistrict (District district) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO districts (" +
                    "tile, city, person_int_the_district) " +
                    "VALUES (" +
                    "'" + district.getTitle() + "'," +
                    "'" + district.getCity() + "'," +
                    "'" + district.getPersonInTheDistrict() +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting District list: " + exception);
        }

    }



    //Method to print all villains and their info
    public ArrayList<Villain> getVillains() {

        //Creating arraylist to hold all villains
        ArrayList<Villain> villainList= new ArrayList<Villain>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM villains";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Villain object
                Villain villain = new Villain();
                villain.setVillainID(rs.getInt("villainID"));
                villain.setName(rs.getString("name"));
                villain.setSurname(rs.getString("surname"));
                villain.setVillainName(rs.getString("villainName"));
                villain.setVillainSalary(rs.getInt("villainSalary"));
                villain.setCrimeTime(rs.getInt("crimeTime"));


                System.out.println(villain.toString());
            }



        } catch (SQLException exception) {
            System.out.println("Error getting Villains list: " + exception);
        }

        return villainList;
    }

    //Method to show only villain names
    public ArrayList<Villain> getVillainNames() {

        ArrayList<Villain> villainList = new ArrayList<Villain>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT villainName FROM villains";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Villain object
                Villain villain = new Villain();
                villain.setVillainName(rs.getString("villainName"));

                System.out.println(villain.getVillainName());
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Villains list: " + exception);
        }
        return villainList;
    }

    //Method to create a new Villain in DB
    public void createVillain (Villain villain) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO villains (" +
                    "name, surname, villainName, villainSalary, crimeTime) " +
                    "VALUES (" +
                    "'" + villain.getName() + "'," +
                    "'" + villain.getSurname() + "'," +
                    "'" + villain.getVillainName() + "'," +
                    "'" + villain.getVillainSalary() + "'," +
                    villain.getCrimeTime() +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Villain list: " + exception);
        }

    }


    //Method to get a list of all heroes ad their info
    public ArrayList<Hero> getHeroes() {

        ArrayList<Hero> heroList= new ArrayList<Hero>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM heroes";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Hero object
                Hero hero = new Hero();
                hero.setHeroID(rs.getInt("heroID"));
                hero.setName(rs.getString("name"));
                hero.setSurname(rs.getString("surname"));
                hero.setHeroName(rs.getString("heroName"));
                hero.setHeroSalary(rs.getDouble("heroSalary"));
                hero.setDeedTime(rs.getInt("deedTime"));


                System.out.println(hero.toString());
            }



        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }

        return heroList;
    }


    //Method to show all hero names
    public ArrayList<Hero> getHeroesNames() {

        ArrayList<Hero> heroList = new ArrayList<Hero>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT heroName FROM heroes";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Hero object
                Hero hero = new Hero();
                hero.setHeroName(rs.getString("heroName"));

                System.out.println(hero.getHeroName());
            }


        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }
        return heroList;
    }


    public ArrayList<Hero> getOneHero() {

        ArrayList<Hero> heroListOne= new ArrayList<Hero>();

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "SELECT * FROM heroes WHERE heroName = " + "\'" + scanner.next() + "\'";

            ResultSet rs = statement.executeQuery(sqlStatement);

            while (rs.next()) {
                //Create a new Hero object
                Hero hero = new Hero();
                hero.setHeroID(rs.getInt("heroID"));
                hero.setName(rs.getString("name"));
                hero.setSurname(rs.getString("surname"));
                hero.setHeroName(rs.getString("heroName"));
                hero.setHeroSalary(rs.getInt("heroSalary"));
                hero.setDeedTime(rs.getInt("deedTime"));


                System.out.println(hero.toString());
            }



        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }

        return heroListOne;
    }




    //Method to delete a hero
    public void deleteHero () {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "DELETE FROM heroes WHERE heroName = " + "'" + scanner.next() + "'";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }

    }


    //Method to create a new hero in DB
    public void createHero (Hero hero) {

        try {

            Statement statement = conn.createStatement();
            String sqlStatement = "INSERT INTO heroes (" +
                    "name, surname, heroName, heroSalary, deedTime) " +
                    "VALUES (" +
                    "'" + hero.getName() + "'," +
                    "'" + hero.getSurname() + "'," +
                    "'" + hero.getHeroName() + "'," +
                    "'" + hero.getHeroSalary() + "'," +
                    hero.getDeedTime() +
                    ")";

            statement.execute(sqlStatement);

        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }


    }


}

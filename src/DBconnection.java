import java.sql.*;
import java.util.ArrayList;

public class DBconnection {


    private Connection conn;

    public DBconnection() {

        try {
            String dbUrl = "jdbc:sqlite:hero.db";
            conn = DriverManager.getConnection(dbUrl);

            // CREATING A TABLE
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


    }

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
                hero.setHeroSalary(rs.getInt("heroSalary"));
                hero.setDeedTime(rs.getInt("deedTime"));


                System.out.println(hero.toString());
            }



        } catch (SQLException exception) {
            System.out.println("Error getting Heroes list: " + exception);
        }

        return heroList;
    }

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

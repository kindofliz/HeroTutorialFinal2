import java.util.*;

public class HeroApp2 {
    public static void main(String[] args) {

        DBconnection heroDb = new DBconnection();
//
//        //Adding Districts and Persons (heroes and villains)
//        Hero dogoMom = new Hero("Liza", "Simanovica", 101, "DogoMom", 5327, 115);
//        Hero superCat = new Hero("Aiva", "Ciekurs", 202, "SuperCat", 2335, 55);
//        Hero peopleWhisperer = new Hero("Laura", "Vadone", 303, "PeopleWhisperer", 6000, 120);
//        Hero toolMan = new Hero("Cooper", "Orion", 404, "ToolMan", 599, 25);
//        Hero mrForest = new Hero("Leonard", "Pine", 505, "MrForest", 755.99, 36);
//        Hero rain = new Hero("Ezra", "Terrier", 606, "RAIN", 785.36, 12);
//        Hero thunderWoman = new Hero("Karina", "Baiga", 707, "ThunderWoman", 4002.15, 19);
//        Hero userHero = new Hero();
//
//        //ADDING AN ARRAYLIST TO STORE ALL SUPERHEROS (superHeroes)
//        ArrayList<Hero> superHeroes = new ArrayList<>();
//        superHeroes.add(dogoMom);
//        superHeroes.add(superCat);
//        superHeroes.add(peopleWhisperer);
//        superHeroes.add(toolMan);
//        superHeroes.add(mrForest);
//        superHeroes.add(rain);
//        superHeroes.add(thunderWoman);
//
//        //Alphabetically sorting the arraylist of objects via comparator class method
//        superHeroes.sort(new HeroNameSorter());
//
//
//        Villain drBad = new Villain("David", "Winters", 999, "DrBad", 3512.99, 39);
//        Villain ladyWrath = new Villain("Karen", "Typical", 888, "LadyWrath", 4987, 90);
//        Villain landShark = new Villain("Staffie", "English", 777, "LandShark", 233, 11);
//        Villain drBat = new Villain("Bob", "Butters", 666, "DrBat", 575.39, 18);
//        Villain mrMeow = new Villain("Smelly", "Cat", 555, "MrMeow", 1999, 41);
//
//        //ADDING AN ARRAYLIST TO STORE ALL VILLAINS (allVillains)
//        ArrayList<Villain> allVillains = new ArrayList<>();
//        allVillains.add(drBad);
//        allVillains.add(ladyWrath);
//        allVillains.add(landShark);
//        allVillains.add(drBat);
//        allVillains.add(mrMeow);
//
//        //Alphabetically sorting the arraylist of objects via comparator class method
//        allVillains.sort(new VillainNameSorter());
//
//
//        District district12 = new District("District 12", "DellCity", 12);
//        District district1 = new District("District 1", "Capitol", 1);
//        District district16 = new District("District 16", "AshCity", 16);
//
//        //Adding persons to districts
//        district12.addNewPerson(dogoMom);
//        district12.addNewPerson(superCat);
//        district12.addNewPerson(drBad);
//        district12.addNewPerson(drBat);
//
//        district1.addNewPerson(peopleWhisperer);
//        district1.addNewPerson(toolMan);
//        district1.addNewPerson(ladyWrath);
//
//        district16.addNewPerson(mrForest);
//        district16.addNewPerson(rain);
//        district16.addNewPerson(thunderWoman);
//        district16.addNewPerson(landShark);
//        district16.addNewPerson(mrMeow);
//
//        //Creating an arraylist of all districts
//        ArrayList<District> allDistricts = new ArrayList<>();
//        allDistricts.add(district1);
//        allDistricts.add(district12);
//        allDistricts.add(district16);


        // MENU
        // -- I would like to see a MENU to select different parts of superhero information card
        // 1. A list of superheroes
        // 3. show specific superhero information
        // a list of villains
        // info on villains
        // a list of districts
        // info on districts
        // 2. Add new superhero //OR VILLAIN
        // 4. Delete the superhero // OR VILLAIN from the list
        // 0. Exit


        int menuEntry;
        Scanner scannerTwo = new Scanner(System.in);

        do {
            //EXIT == 0
            System.out.println("Welcome!");
            System.out.println("Please select what to do: ");
            System.out.println("1 - Show a list of superheroes");
            System.out.println("2 - Add a new superhero");
            System.out.println("3 - Show specific superhero information");
            System.out.println("4 - Delete the superhero!");
            System.out.println("0 - Exit");
            menuEntry = scannerTwo.nextInt();

            switch (menuEntry) {
                case 1:
                    System.out.println("================= SUPERHERO LIST ================");

                    heroDb.getHeroesNames();

                    System.out.println("================= SUPERHERO LIST ================");
                    System.out.println();
                    break;
                case 2:
                    //Asking user to input hero's info and adding this into a new Hero
                    Hero hero = new Hero();

                    //Asking user to input hero's real name and validating it's alphabetical
                    String name;
                    int checkName = 0;

                    do {
                        System.out.println("What's your hero's real name?");
                        name = scannerTwo.next();
                        if (name.matches("[A-Z][a-zA-Z]*")) {
                            hero.setName(name);
                            checkName = 1;
                        } else {
                            System.out.println("Invalid name.. try again.");
                        }
                    } while (checkName == 0);


                    //Asking user to input hero's surname and validating it's alphabetical
                    String surname;
                    int checkSurname = 0;

                    do {
                        System.out.println("What's your hero's surname?");
                        surname = scannerTwo.next();
                        if (surname.matches("[A-Z][a-zA-Z]*")) {
                            hero.setSurname(surname);
                            checkSurname = 1;
                        } else {
                            System.out.println("Invalid surname.. try again.");
                        }
                    } while (checkSurname == 0);


                    //Asking user to input heroName
                    System.out.println("Enter the HERONAME of the Hero: ");
                    hero.setHeroName(scannerTwo.next());


                    //Asking user to input hero's deedTime
                    System.out.println("How many hours a week does your superhero spend on good deeds?");
                    int deedTime = scannerTwo.nextInt();
                    if (deedTime >= 0 && deedTime <= 168) {
                        hero.setDeedTime(deedTime);
                    } else {
                        System.out.println("Make sure you've input a number between 0 and 168");
                    }

                    //Calculating and setting Hero salary using a custom method
                    hero.setHeroSalary(hero.calculatedSalary());


                    heroDb.createHero(hero);


                    System.out.println("Hero successfully added!");
                    System.out.println();
                    break;

                case 3:
                    //Using another switch-case to show specific hero information
                    System.out.println("Enter a hero name from the superhero list: ");
                    heroDb.getOneHero();
                    System.out.println();

                    break;
                case 4:

                    System.out.println("Please enter the HERONAME of hero you want to delete (Case Sensitive): ");
                    heroDb.deleteHero();
                    System.out.println();

                    System.out.println("Hero deleted successfully!");


                    break;
                default:
                    if (menuEntry != 0)
                        System.out.println("Menu item does not exist!");
                    System.out.println();

            }
        }
        while (menuEntry != 0);


    }


    //SEPARATED METHODS

    //HeroNameSorter comparator class (HowToDoInJava.com)
    public static class HeroNameSorter implements Comparator<Hero> {
        @Override
        public int compare(Hero o1, Hero o2) {
            return o1.getHeroName().compareToIgnoreCase(o2.getHeroName());
        }
    }


    //VillainNameSorter comparator class (HowToDoInJava.com)
    public static class VillainNameSorter implements Comparator<Villain> {
        @Override
        public int compare(Villain o1, Villain o2) {
            return o1.getVillainName().compareToIgnoreCase(o2.getVillainName());
        }
    }


}


public class Main {
    public static void main(String[] args) {
        Animal<String> dog = new Animal<>();
        dog.setParam1("Labrador");
        dog.setParam2("Large");
        dog.setParam3("Canidae");
        dog.setParam4("Golden");
        dog.setParam5("3 years old");

        Animal<String> cat = new Animal<>();
        cat.setParam1("Siamese");
        cat.setParam2("Medium");
        cat.setParam3("Felidae");
        cat.setParam4("Seal Point");
        cat.setParam5("5 years old");

        Animal<String> dogTwin = new Animal<>();
        dogTwin.setParam1("Labrador");
        dogTwin.setParam2("Large");
        dogTwin.setParam3("Canidae");
        dogTwin.setParam4("Golden");
        dogTwin.setParam5("3 years old");

        System.out.println((dog.compareTo(cat) == 0)? "Dog is equal to cat" : "Dog is not equal to cat");
        System.out.println((dog.compareTo(dogTwin) == 0) ? "Dog is equal to twin of this dog" : "Dog is not equal to twin of this dog");
    }
}

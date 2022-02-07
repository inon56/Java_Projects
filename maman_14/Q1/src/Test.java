import com.sun.tools.javac.util.Assert;

public class Test {
    public static void main(String[] args) throws IllegalArgumentException {
        // creating Student objects
        Student zack = new Student("Zack", "Efron", 1111, 1990);
        Student jhon = new Student("Jhon", "Downey", 2222, 1995);
        Student robert = new Student("Robert", "Dadon", 3333, 1986);

        Student[] students = {zack, jhon, robert};
        String[] phoneNumbers = {"053-5163215", "054-6563444", "055-2516372"};


        AssociationTable table1 = new AssociationTable<Student, String>(students, phoneNumbers);

        System.out.println("table size: " + table1.size());
        System.out.println(table1);

        Student dan = new Student("Dan", "Levi", 1, 1988);
        table1.add(dan, "052-1387631");
        Assert.check(table1.contains(dan));
        System.out.println("\nTest adding,Dan should appear as" +
                " first new student in the table");
        System.out.println(table1);

        //change last phone number (last digit for 1 to 2)
        table1.updateKeyValue(dan, "052-1387632");
        Assert.check(table1.get(dan) == "052-1387632");
        System.out.println("\nTest Update Value" +
                ",Change of Dan (first student) phone number, now ends with 9");
        System.out.println(table1);

        //remove dan from table
        Assert.check(table1.remove(dan));

        System.out.println(table1);
        //testing IllegalArgumentException

        System.out.println("\nTest IllegalArgumentException Exception" +
                "\nCreating a table with 2 students and 3 phone numbers");
        Student[] students2 = {zack, jhon};
        try {
            AssociationTable table2 = new AssociationTable<Student, String>(students2, phoneNumbers);
            Assert.error();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}


public class Test {
    public static void main(String[] args) {
        Pesel pesel = new Pesel("99999999994");

        System.out.println(pesel.validatePesel());
    }
}

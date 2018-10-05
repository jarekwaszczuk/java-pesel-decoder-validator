public class Test {
    public static void main(String[] args) {
        Pesel pesel1 = new Pesel("65071209862");
        Pesel pesel2 = new Pesel("02271409867");
        Pesel pesel3 = new Pesel("02271409862");

        System.out.println("PESEL 1: "+pesel1.getPesel());
        System.out.println(pesel1.isPeselValid());
        System.out.println(pesel1.gender());
        pesel1.decodePesel();

        System.out.println("PESEL 2: "+pesel2.getPesel());
        System.out.println(pesel2.isPeselValid());
        System.out.println(pesel2.gender());
        pesel2.decodePesel();

        System.out.println("PESEL 3: " + pesel3.getPesel());
        System.out.println(pesel3.isPeselValid());
        System.out.println(pesel3.gender());
        pesel3.decodePesel();
    }
}

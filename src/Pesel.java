public class Pesel {

    private String pesel;

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean validatePesel() {
        String pesel = this.pesel;

        int ostatniaCyfra = Integer.parseInt(pesel.substring(10, 11));
        int a = Integer.parseInt(pesel.substring(0, 1));
        int b = Integer.parseInt(pesel.substring(1, 2));
        int c = Integer.parseInt(pesel.substring(2, 3));
        int d = Integer.parseInt(pesel.substring(3, 4));
        int e = Integer.parseInt(pesel.substring(4, 5));
        int f = Integer.parseInt(pesel.substring(5, 6));
        int g = Integer.parseInt(pesel.substring(6, 7));
        int h = Integer.parseInt(pesel.substring(7, 8));
        int i = Integer.parseInt(pesel.substring(8, 9));
        int j = Integer.parseInt(pesel.substring(9, 10));

        int suma = 9 * a + 7 * b + 3 * c + 1 * d + 9 * e + 7 * f + 3 * g + 1 * h + 9 * i + 7 * j;

        if (suma % 10 == ostatniaCyfra) {
            return true;
        } else {
            return false;
        }
    }

    public void decodePesel() {

        if (validatePesel()) {
            System.out.println("Suma kontrolna niepoprawna, dekodowanie niemożliwe!");
        } else {
            Integer miesiacUrodzeniaZPesel = Integer.parseInt(pesel.substring(2, 4));
            Integer stulecieRokuUrodzenia = miesiacUrodzeniaZPesel / 20;
            Integer miesiacUrodzenia = miesiacUrodzeniaZPesel - (stulecieRokuUrodzenia * 20);
            String stulecie = null;
            switch (stulecieRokuUrodzenia) {
                case 0:
                    stulecie = "19";
                    break;
                case 1:
                    stulecie = "20";
                    break;
                case 2:
                    stulecie = "21";
                    break;
                case 3:
                    stulecie = "22";
                    break;
                case 4:
                    stulecie = "18";
                    break;
            }

            String rokUrodzenia = stulecie + pesel.substring(0, 2);

            String dzienUrodzenia = pesel.substring(4, 6);

            System.out.printf("Rok urodzenia: %s\n", rokUrodzenia);
            System.out.printf("Miesiąc urodzenia: %02d\n", miesiacUrodzenia);
            System.out.printf("Dzień urodzenia: %s\n", dzienUrodzenia);
            System.out.printf("Płeć: %s\n", plec());
        }
    }

    public String plec() {
        if (validatePesel() != true) {
            return "Suma kontrolna niepoprawna, dekodowanie niemożliwe!";
        } else {
            int plec = Integer.parseInt(pesel.substring(9, 10));
            if (plec % 2 == 0 || plec == 0) {
                return "kobieta";
            } else {
                return "mężczyzna";
            }
        }
    }

    public String getPesel() {
        return pesel;
    }
}

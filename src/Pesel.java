public class Pesel {

    private String pesel;

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean isPeselValid() {
        String pesel = this.pesel;

        int lastDigit = Integer.parseInt(pesel.substring(10, 11));
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

        int sum = 9 * a + 7 * b + 3 * c + 1 * d + 9 * e + 7 * f + 3 * g + 1 * h + 9 * i + 7 * j;

        if (sum % 10 == lastDigit) {
            return true;
        } else {
            return false;
        }
    }

    public void decodePesel() {

        if (isPeselValid()) {
            Integer monthOfBirthFromPesel = Integer.parseInt(pesel.substring(2, 4));
            Integer centuryOfBirthYear = monthOfBirthFromPesel / 20;
            Integer monthOfBirth = monthOfBirthFromPesel - (centuryOfBirthYear * 20);
            String century = null;
            switch (centuryOfBirthYear) {
                case 0:
                    century = "19";
                    break;
                case 1:
                    century = "20";
                    break;
                case 2:
                    century = "21";
                    break;
                case 3:
                    century = "22";
                    break;
                case 4:
                    century = "18";
                    break;
            }

            String yearOfBirth = century + pesel.substring(0, 2);

            String dayOfBirth = pesel.substring(4, 6);

            System.out.printf("Rok urodzenia: %s\n", yearOfBirth);
            System.out.printf("Miesiąc urodzenia: %02d\n", monthOfBirth);
            System.out.printf("Dzień urodzenia: %s\n", dayOfBirth);
            System.out.printf("Płeć: %s\n", gender());
        } else {
            System.out.println("Suma kontrolna niepoprawna, dekodowanie niemożliwe!");
        }
    }

    public String gender() {
        if (isPeselValid()) {
            int plec = Integer.parseInt(pesel.substring(9, 10));
            if (plec % 2 == 0 || plec == 0) {
                return "kobieta";
            } else {
                return "mężczyzna";
            }
        } else {
            return "Suma kontrolna niepoprawna, dekodowanie niemożliwe!";
        }
    }

    public String getPesel() {
        return pesel;
    }
}

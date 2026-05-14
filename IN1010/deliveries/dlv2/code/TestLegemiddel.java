class TestLegemiddel {

    private static void sjekk(String hva, boolean test) {
        if (!test) {
            System.out.println("Sjekken '" + hva + "' feilet!");
            System.exit(1);
        }
    }

    private static boolean testLegemiddelId(Legemiddel legemiddel, int foreventetId) {
        return legemiddel.id == foreventetId;
    }

    private static boolean testNyPris(Legemiddel legemiddel, int nyPris) {
        legemiddel.settNyPris(nyPris);
        return legemiddel.hentPris() == nyPris;
    }

    public static void main(String[] arg) {
        System.out.println("**Test Legemiddel**");


    }

}
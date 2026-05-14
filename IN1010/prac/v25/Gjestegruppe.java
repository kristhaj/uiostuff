// 3

class Gjestegruppe {
    private Samling<Gjest> gjestesamling;

    public Gjestegruppe() {
        gjestesamling = new Samling<>(20);

    }

    // 5
    public boolean noenØnskerVin() {
        for(Gjest g:gjestesamling) {
            if(g.ønskerVin()) {
                return true;
            }
        }
        return false;
    }

    // 6
    public int antallGjester() {
        /*int antall = 0;
        for (Gjest g:gjestesamling) {
            antall++;
        }
        return antall;*/
        
        //8
        return gjestesamling.antallNoder();
    }
}
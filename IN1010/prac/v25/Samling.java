// Exam practice v25 set

import java.util.Iterator;

// 1, 2

class Samling<E> implements Iterable<E>{
    private Node start;


    Samling(int n) {
        for (int i=0; i < n; i++) {
            Node ny = new Node();
            ny.neste = start;
            start = ny;
            
        }
    }

    private class Node {
        public Node neste;
        public E data;

        public int antallFraOgMedDenne() {
            int antall = 0;
            if(data != null) {antall++;}
            if(neste != null) {antall += neste.antallFraOgMedDenne();}
            return antall;
        }
    }

    public void settInn(E ny) {
        Node innsettingsNode = start;
        while (innsettingsNode.data != null) { 
            innsettingsNode = innsettingsNode.neste;
        }
        innsettingsNode.data = ny;
    }
    public void fjern(E ref) {
        // Ikke implementer
    }

    // 2
    @Override 
    public Iterator<E> iterator() {
        return new SamlingsIterator();
    }

    private class SamlingsIterator implements Iterator<E> {
        private Node denne;

        SamlingsIterator() {
            denne = start;
            finnNesteIkkeNull();
        }

        public void finnNesteIkkeNull() {
            while (denne != null && denne.data == null) {
                denne = denne.neste;
            }
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public E next() {
            E res = denne.data;
            denne = denne.neste;
            finnNesteIkkeNull();
            return res;
        }


    }

    // 7
    public int antallNoder() {
        if(start == null) {
            return 0;
        }
        return start.antallFraOgMedDenne();
    }
}
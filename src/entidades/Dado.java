package entidades;

import java.util.Random;

public class Dado {
    private int face;

    public Dado() {
    }

    public int getFace() {
        return face;
    }

    public void setFace(int face) {
        this.face = face;
    }

    public void rolar() {
        Random face = new Random();
        setFace(face.nextInt(6) + 1);
    }

    @Override
    public String toString() {
        return "Dado{" +
                "face=" + face +
                '}';
    }
}

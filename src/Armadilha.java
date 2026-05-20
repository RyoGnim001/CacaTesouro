public class Armadilha extends ElementoTabuleiro {

    @Override
    public int interagir() {
        return -2;
    }

    @Override
    public String simbolo() {
        return "\uD83D\uDCA3";
    }

    @Override
    public ElementoTabuleiro criar() {
        return new Armadilha();
    }
}
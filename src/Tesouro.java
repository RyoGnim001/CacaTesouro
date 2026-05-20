public class Tesouro extends ElementoTabuleiro {

    @Override
    public int interagir() {
        return 3;
    }

    @Override
    public String simbolo() {
        return "💰" ;
    }

    @Override
    public ElementoTabuleiro criar() {
        return new Tesouro();
    }
}
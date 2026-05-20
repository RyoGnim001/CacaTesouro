public abstract class ElementoTabuleiro {
    public abstract int interagir();
    public abstract String simbolo();
    public abstract ElementoTabuleiro criar();

    public boolean podeSerSubstituido() {
        return false;
    }
}
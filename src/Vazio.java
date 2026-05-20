class Vazio extends ElementoTabuleiro {

    @Override
    public int interagir() {
        return 0;
    }

    @Override
    public String simbolo() {
        return "⬜";
    }

    @Override
    public boolean podeSerSubstituido() {
        return true;
    }

    @Override
    public ElementoTabuleiro criar() {
        return new Vazio();
    }
}
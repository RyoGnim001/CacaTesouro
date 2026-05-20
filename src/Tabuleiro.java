public class Tabuleiro {
    private ElementoTabuleiro[][] grid;

    public Tabuleiro(int tamanho) {
        grid = new ElementoTabuleiro[tamanho][tamanho];
    }

    public void inicializar() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Vazio();
            }
        }
    }

    public ElementoTabuleiro get(int x, int y) {
        return grid[x][y];
    }

    public void set(int x, int y, ElementoTabuleiro e) {
        grid[x][y] = e;
    }

    public int tamanho() {
        return grid.length;
    }
}
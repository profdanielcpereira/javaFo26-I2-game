import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Jogador extends Actor {

    //ATRIBUTOS
    int vidas;
    int velocidade;
    int estamina;

    private int contadorFrames = 0;
    private int frameAtual = 1;

    private String ultimaDirecao = "baixo";

    //CONSTRUTOR
    public Jogador(){
    }
    public Jogador(int vidas, int velocidade, int estamina) {
        this.vidas = vidas;
        this.velocidade = velocidade;
        this.estamina = estamina;
        this.imagemBaixo = "imagens/jogadores/Jogador1/Jogador_baixo_1.png";
        this.imagemCima = "imagens/jogadores/Jogador1/Jogador_cima_1.png";
        this.imagemEsquerda = "imagens/jogadores/Jogador1/Jogador_esquerda_1.png";
        this.imagemDireita = "imagens/jogadores/Jogador1/Jogador_direita_1.png";

        setImage(imagemBaixo);
    }

    //METODOS
    public void act() {
        movimentar();
    }

        public void movimentar(){
        boolean isAndando = false;
        String direcao = "";


        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - velocidade);
            isAndando = true;
            direcao = "cima";
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - velocidade, getY());
            isAndando = true;
            direcao = "esquerda";
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + velocidade);
            isAndando = true;
            direcao = "baixo";
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + velocidade, getY());
            isAndando = true;
            direcao = "direita";
        }
        if (isAndando) {
            ultimaDirecao = direcao; // Salva a direção atual
            animar(direcao);
        } else {
            setImage("imagens/jogadores/Jogador1/Jogador_" + ultimaDirecao + "_1.png");
        }
    }

    public  void animar(String direcao){
    contadorFrames++;

        int dalayAnimacao = 5;
        if (contadorFrames >= dalayAnimacao){
        contadorFrames = 0;

        frameAtual = (frameAtual %4) + 1;

        String nomeImagem = "imagens/jogadores/Jogador1/Jogador_" + direcao + "_" + frameAtual + ".png";

        setImage(nomeImagem);
    }

    }

    public void coletarMoedas(){

    }


}

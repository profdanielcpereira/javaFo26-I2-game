import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Jogador extends Actor {

    //ATRIBUTOS
    int vidas;
    int velocidade;
    String imagemBaixo;
    String imagemCima;
    String imagemDireita;
    String imagemEsquerda;
    int estamina;
    int pontos;
    boolean sofrendoDano = false;
    int tempoDano = 10000;

    //CONSTRUTOR
    public Jogador(){
    }
    public Jogador(int vidas, int velocidade, int estamina) {
        this.vidas = vidas;
        this.velocidade = velocidade;
        this.estamina = estamina;
        this.pontos = 0;

        this.imagemBaixo = "imagens/jogadores/Jogador2/Jogador_baixo_1.png";
        this.imagemCima = "imagens/jogadores/Jogador2/Jogador_cima_1.png";
        this.imagemEsquerda = "imagens/jogadores/Jogador2/Jogador_esquerda_1.png";
        this.imagemDireita = "imagens/jogadores/Jogador2/Jogador_direita_1.png";

        setImage(imagemBaixo);
    }

    //METODOS
    public void act() {
        movimentar();
        coletarMoedas();

        if (sofrendoDano == true){
            tempoDano--;
            if (tempoDano == 0){
                sofrendoDano = false;
            }
        }
    }

    public void movimentar(){
        if(Greenfoot.isKeyDown("right")){
            //Andar para a direita:
            setLocation(getX()+velocidade, getY());
            setImage(imagemDireita);
        }
        if(Greenfoot.isKeyDown("left")){
            //Andar para a esquerda:
            setLocation(getX()-velocidade, getY());
            setImage(imagemEsquerda);
        }
        if(Greenfoot.isKeyDown("up")){
            //Andar para a cima:
            setLocation(getX(), getY()-velocidade);
            setImage(imagemCima);
        }
        if(Greenfoot.isKeyDown("down")){
            //Andar para a baixo:
            setLocation(getX(), getY()+velocidade);
            setImage(imagemBaixo);
        }
    }

    public void coletarMoedas(){
        //Quando o jogado encostar numa moeda. A moeda deve sumir e o jogador ganhar os pontos dela.
        if(isTouching(Moeda.class)){
            Moeda moedaEncontrada = (Moeda) getOneIntersectingObject(Moeda.class);
            this.pontos = this.pontos + moedaEncontrada.valor;
            getWorld().removeObject(moedaEncontrada);
            System.out.println(this.pontos);
        }
    }

    public void sofrerDano(int dano){

        if(this.vidas > dano && !sofrendoDano){
            this.vidas = this.vidas - dano;
            sofrendoDano = true;
        }
        else{
            this.vidas = 0;
        }

        System.out.println("Vidas: " + this.vidas);
    }
}

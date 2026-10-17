import greenfoot.Actor;
import greenfoot.Greenfoot;

public class Inimigo extends Actor {

    //ATRIBUTOS
    int velocidade;
    int direcao;    //Pode ser +1 (Direita) ou -1 (Esquerda)
    int dano;

    //CONSTRUTORES
    public Inimigo(){}

    public Inimigo(int velocidade, int dano){
        this.velocidade = velocidade;
        this.dano = dano;
        definirDirecaoInicial();
        setImage("imagens/inimigos/Monstro/Monstro_baixo_0.png");
    }

    //METODOS
    public void act(){
        movimentar();
        atacar();
    }

    public void movimentar(){
        setLocation(getX()+(velocidade * direcao), getY());
        if(getX()<20 || getX() >1180){
            direcao = direcao * -1;
        }
    }

    public void atacar(){
        //Quando o inimigo encostar no jogador. O inimigo deve fazer o jogar perder vida
        if(isTouching(Jogador.class)){
            Jogador jogadorEncontrado = (Jogador) getOneIntersectingObject(Jogador.class);
            jogadorEncontrado.sofrerDano(this.dano);
        }
    }

    public void definirDirecaoInicial(){
        int numero = Greenfoot.getRandomNumber(10);
        if(numero<5){
            this.direcao = +1;
        }
        else {
            this.direcao = -1;
        }
    }

}

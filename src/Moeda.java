import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.World;

public class Moeda extends Actor {

    //ATRIBUTOS
    int valor;
    int tempo; //milisegundos

    //CONSTRUTOR
    public Moeda(){}

    public Moeda(int valor, int tempo){
        this.valor = valor;
        this.tempo = tempo;
        setImage("imagens/moedas/coin_java.png");
    }

    //METODOS
    public void act(){
        despawnar();
    }

    public void spawnar(World mundo){
        int x = Greenfoot.getRandomNumber(1200);
        int y = Greenfoot.getRandomNumber(700);
        mundo.addObject(this,x,y);
    }

    public void despawnar(){
        this.tempo --;
        if(tempo == 0){
            getWorld().removeObject(this);
        }
        getImage().setTransparency(tempo/4);
    }

}

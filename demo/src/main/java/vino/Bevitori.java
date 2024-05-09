package vino;

public class Bevitori extends Thread {
    private Botte b= new Botte();

    //costruttore
    public Bevitori( Botte b, String nome){
        super(nome);
        this.b=b;
    }

    public void run(){
        try{
            
            int tempo=b.entra();
            Thread.sleep(tempo);
            b.esci();


        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }  

}

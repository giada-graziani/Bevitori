package vino;

public class Main {
    public static void main(String[] args) {
        Botte b=new Botte();
        
        for(int i =0; i<10;i++){
            Bevitori bev= new Bevitori(b,"Bevitore"+(i+1));
            bev.start();
        }
    }
}
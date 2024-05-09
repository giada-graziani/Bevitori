package vino;

public class Botte {
    private int rubOccupati=0;
    private int litri= 100;

    public synchronized int entra(){
        String nome= Thread.currentThread().getName();
        int tempo=0;
        try{
            while(rubOccupati>=3 || litri<=0){
                System.out.println(nome+" è in attesa");
                wait();
            }

            //entra
            

            if(litri>=0 && litri <=100){
                rubOccupati++;

                tempo= 2000+(int)(Math.random()*3001);
                System.out.println(nome+" beve per "+ tempo/1000+" secondi" );

                //System.out.println(litri);
                int bevuta=1+(int)(Math.random()*4);
                litri-=bevuta;
                System.out.println(nome + " ha bevuto "+ bevuta+" litri da "+ litri);

                if(litri<=0){
                    System.out.println(nome+" ha finito il vino!");
                    Thread.interrupted();
                }

            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        return tempo;
    }

    public synchronized void esci(){
        String nome= Thread.currentThread().getName();
        System.out.println(nome + " ha finto di bere");
        rubOccupati--;
        notify();
    }
}

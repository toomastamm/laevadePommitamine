public class m_arvuti extends Mängija {
    public m_arvuti(String nimi, int pikkus) {
        super(nimi, pikkus);
    }

    @Override
    boolean paigutaLaev(int pikkus) {
        väljastaVäliEndale();
        int x;
        int y;
        String suund;
        int suuna = (int)(Math.random()*2);
        if(suuna == 0) {
            suund = "paremale";
            y = (int) (Math.random() * (10 - pikkus));
            x = (int) (Math.random() * 10);
        }
        else {
            suund = "alla";
            y = (int) (Math.random() * 10);
            x = (int) (Math.random() * (10 - pikkus));

        }
            boolean paigutus = prooviPaigutada(x, y, pikkus, suund);

        if (!paigutus) {
            System.out.println("Paigutamine ebaõnnestus!");
        }

        return paigutus;
    }

    @Override
    boolean lase(Mängija vastane) {
        vastane.väljastaVäliVastasele();
        boolean sobiv = false;
        int y = (int)(Math.random()*10);
        int x = (int)(Math.random()*10);
        while (sobiv = false){

        if((vastane.getMänguväli().getSisu(x,y)).equals("tavaline")){
            sobiv = true;
        }
        else {
            y = (int)(Math.random()*10);
            x = (int)(Math.random()*10);
        }
        }
        return vastane.vastaseLask(y, x);
    }
}


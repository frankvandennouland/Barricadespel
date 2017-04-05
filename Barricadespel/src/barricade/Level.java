/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barricade;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author W. Kuik
 */
public class Level extends JFrame {

    private int aantalRijen;
    private Vak[][] vak;
    private JPanel panel;
    private final int SIZE = 50;
    private Speler speler;

    public Level(int levelNr, int aantalRijen) {
        this.aantalRijen = aantalRijen;
        laadLevel(levelNr);
        initComponents();
        this.addKeyListener(new arrowListener());
    }

    private void laadLevel(int levelNr) {
        //v is een leeg vakje
        //s is een speler
        //m is een muur
        //1 is een baricade met nummer 1
        //2 is een baricade met nummer 2
        //3 is een baricade met nummer 3
        //4 is een baricade met nummer 4
        //5 is een baricade met nummer 5
        //6 is een sleutel met nummer 1
        //7 is een sleutel met nummer 2
        //8 is een sleutel met nummer 3
        //9 is een sleutel met nummer 4
        //0 is een sleutel met nummer 5
        //f is finish
        
        String Layout = "";
        
        switch (levelNr) {
            case 1:
               Layout = "sm1vvvv555vvvv68v555vv1vvvv336vm1vvvv555vm11mmm515v21vvvm15vvm1mm3mmvvvm1551vvvv7m15vvvmvvvm15vvvmvf";
            break;
        }
        
        maakLevel(Layout);
    }

    public boolean checkVak(int rij, int kolom) {
        if ((rij > -1 && rij < 10) && (kolom > -1 && kolom < 10)) {
            return vak[rij][kolom].loopBaar();
        } else {
            return false;
        }
    }

    private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(850, 550);
        this.setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        for (int i = 0; i < this.aantalRijen; i++) {
            plaatsRij(i);
        }
    }
   
    private void maakLevel(String Layout) {
        vak = new Vak[aantalRijen][aantalRijen];
        int i = 0;
        for (int rij = 0; rij < aantalRijen; rij++) {
            for (int kolom = 0; kolom < aantalRijen; kolom++) {
                if(i < Layout.length()) {
                    char soort = Layout.charAt(i);
                    switch (soort) {
                        case 'v':
                            vak[rij][kolom] = new Vak(this);
                        break;
                        case 'm':
                            vak[rij][kolom] = new Muur(this);
                        break;
                        case 'f':
                            vak[rij][kolom] = new Finish(this);
                        break;
                        case 's':
                            vak[rij][kolom] = new Vak(this);
                            this.speler = new Speler(rij,kolom);
                        break;
                        case '0':
                            vak[rij][kolom] = new Sleutel(this, 5);
                        break;
                        case '1':
                            vak[rij][kolom] = new Barricade(this, 1);
                        break;
                        case '2':
                            vak[rij][kolom] = new Barricade(this, 2);
                        break;
                        case '3':
                            vak[rij][kolom] = new Barricade(this, 3);
                        break;
                        case '4':
                            vak[rij][kolom] = new Barricade(this, 4);
                        break;
                        case '5':
                            vak[rij][kolom] = new Barricade(this, 5);
                        break;
                        case '6':
                            vak[rij][kolom] = new Sleutel(this, 1);
                        break;
                        case '7':
                            vak[rij][kolom] = new Sleutel(this, 2);
                        break;
                        case '8':
                            vak[rij][kolom] = new Sleutel(this, 3);
                        break;
                        case '9':
                            vak[rij][kolom] = new Sleutel(this, 4);
                        break;
                        default:
                            vak[rij][kolom] = new Vak(this);
                        break;
                    }
                }
                i++;
            }
        }
    }

    private void plaatsRij(int rij) {
        for (int i = 0; i < this.aantalRijen; i++) {
            panel.add(vak[rij][i]);
            vak[rij][i].setSize(SIZE, SIZE);
            vak[rij][i].setLocation(SIZE * i, SIZE * rij);
        }
    }

    private void moveLeft() {
        if (checkVak(speler.getPosHorizontaal() -1, speler.getPosVerticaal())){
            this.vak[speler.getPosHorizontaal()][speler.getPosVerticaal()] = new Vak(this);
            speler.StapLinks();
        }
    }

    private void moveUp() {
        if (checkVak(speler.getPosHorizontaal(), speler.getPosVerticaal() - 1)){
            this.vak[speler.getPosHorizontaal()][speler.getPosVerticaal()] = new Vak(this);
            speler.StapBoven();
        }
    }

    private void moveRight() {
        if (checkVak(speler.getPosHorizontaal() +1, speler.getPosVerticaal())){
            this.vak[speler.getPosHorizontaal()][speler.getPosVerticaal()] = new Vak(this);
            speler.StapRechts();
        }
    }

    private void moveDown() {
        if (checkVak(speler.getPosHorizontaal(), speler.getPosVerticaal()+1)){
            this.vak[speler.getPosHorizontaal()][speler.getPosVerticaal()] = new Vak(this);
            speler.StapBeneden();
        }
    }

    class arrowListener implements KeyListener {
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case 37:
                    moveLeft();
                    break;
                case 38:
                    moveUp();
                    break;
                case 39:
                    moveRight();
                    break;
                case 40:
                    moveDown();
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            //wordt niet gebruikt
        }

        @Override
        public void keyPressed(KeyEvent e) {
            //wordt niet gebruikt
        }

    }
}

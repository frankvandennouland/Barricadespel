/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barricade;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author frank
 */
public class Sleutel extends Vak {

    private Icon iconSleutel;
    private int sleutelNr;
    private boolean opgepakt;

    /**
     * Constructor Sleutel.
     * @param level
     * @param sleutelNr
     */
    public Sleutel(Level level, int sleutelNr) {
        super(level);
        switch (sleutelNr){
            case 1:
                this.iconSleutel = new ImageIcon(getClass().getResource("images/Sleutel100.png"));
                break;
            case 2:
                this.iconSleutel = new ImageIcon(getClass().getResource("images/Sleutel200.png"));
                break;
            case 3:
                this.iconSleutel = new ImageIcon(getClass().getResource("images/Sleutel300.png"));
                break;
            case 4:
                this.iconSleutel = new ImageIcon(getClass().getResource("images/Sleutel400.png"));
                break;
            case 5:
                this.iconSleutel = new ImageIcon(getClass().getResource("images/Sleutel500.png"));
                break;
        }
        
        this.sleutelNr = sleutelNr;
        this.opgepakt = false;
        showMe();
    }
    
    /**
     * Checken of vak loopbaar is.
     * @param speler
     * @return
     */
    @Override
    public boolean loopBaar(Speler speler) {    
        if(this.opgepakt == false) {
            speler.setSleutel(this.sleutelNr);
        }

        setOpgepakt();
        return true;
    }
    
    /**
     * update sleutelopgepake.
     */
    public void setOpgepakt() {
       this.opgepakt = true;
    }

    /**
     * set icon
     */
    @Override
    public void showMe() {
        this.setIcon(iconSleutel);
    }


}

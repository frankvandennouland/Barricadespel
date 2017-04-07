/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barricade;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author frank
 */
public class Vak extends JLabel {
    private Icon icon;
    private Level level;

    /**
     * Constructor vak.
     * @param level
     */
    public Vak(Level level) {
        this.level = level;
        this.icon = new ImageIcon(getClass().getResource("images/Vak.png"));
        showMe();
    }

    /**
     * Zet icon.
     */
    public void showMe() {
        this.setIcon(this.icon);
    }

    /**
     * Returned of het vak loopbaar is.
     * @param speler
     * @return
     */
    public boolean loopBaar(Speler speler) {
        return true;
    }
    
    /**
     * Zet icon.
     * @param icon
     */
    public void showIcon(Icon icon) {
        this.setIcon(icon);
    }
}

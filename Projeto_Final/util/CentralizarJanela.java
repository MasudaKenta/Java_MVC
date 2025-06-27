package util;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class CentralizarJanela {
    public void abrirJanela(JInternalFrame janela, JDesktopPane desktop){
        int wFrame = janela.getWidth();
        int hFrame = janela.getHeight();
        int wDesktop = desktop.getWidth();
        int hDesktop = desktop.getHeight();
        
        janela.setLocation(wDesktop / 2 - wFrame / 2, hDesktop / 2 - hFrame / 2);
        desktop.add(janela);
        janela.setVisible(true);
    }
}

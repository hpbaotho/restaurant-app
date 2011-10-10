import java.awt.*;
import javax.swing.JFrame;


/**
 * 
 * @author Martinsen
 */

public class Main extends JFrame {
    
    /**
     * 
     * @param args 
     */
	public static void main(String[] args)
	{
		DisplayMode dm = new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Main m = new Main();
		m.run(dm);
	}
	
        /**
         * 
         * @param dm 
         */
	public void run(DisplayMode dm)
	{
		setBackground(Color.BLACK);
		setForeground(Color.RED);
		setFont(new Font("Arial", Font.PLAIN, 30));
		
		Screen s = new Screen();
		try
		{
			s.setFullScreen(dm, this);
			try{
				Thread.sleep(6000); //6000 milliseconds
			}catch(Exception ex){}
		}finally{
			s.restoreScreen();
		}
	}
        
        
	/**
         * 
         * @param g 
         */
	public void paint(Graphics g)
	{
		if(g instanceof Graphics2D)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		g.drawString("Made by Martinsen!", 250, 300);
	}

}

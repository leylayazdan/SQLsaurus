package Main;

import javax.swing.JFrame;


public class SingletonFrame extends JFrame{
	private static SingletonFrame myInstance;


    private SingletonFrame() {
    /*    this.setSize(400, 100);

        this.setTitle("Singleton Frame. Timestamp:" +
            System.currentTimeMillis());
*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }

    public static SingletonFrame getInstance() {
        if (myInstance == null)
            myInstance = new SingletonFrame();

        return myInstance;
    }
}


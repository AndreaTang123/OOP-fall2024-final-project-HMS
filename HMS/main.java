import java.awt.EventQueue;

public class Main{
    
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            try{
                MainGUI g = new MainGUI();
                g.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

    }
}
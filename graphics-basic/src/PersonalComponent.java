import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

public class PersonalComponent {
    public JPanel panel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JLabel label;
    private JButton wczytaj;
    private JButton zapisz;

    public PersonalComponent() {
        var buttons = new JButton[] {button1, button2, button3, button4, button5, button6, button7, button8, button9,
        button10,button11,button12,button13,button14,button15,button16};
        Color[] col= {Color.BLUE,Color.GRAY,Color.GREEN,Color.YELLOW,Color.PINK,Color.CYAN,Color.RED,Color.MAGENTA};


        int [] ind= {2,2,2,2,2,2,2,2};
        for(int i=0;i<16;i++ ){
            Random random = new Random();
            int randomNumber = random.nextInt(8);
            while(ind[randomNumber]==0){
                randomNumber = random.nextInt(8);
            }
            buttons[i].setBackground(col[randomNumber]);
            ind[randomNumber]-=1;
        }
        Color[] permutacja= {buttons[0].getBackground(),buttons[1].getBackground(),buttons[2].getBackground(),
                buttons[3].getBackground(),buttons[4].getBackground(),buttons[5].getBackground(),
                buttons[6].getBackground(),buttons[7].getBackground(),buttons[8].getBackground(),
                buttons[9].getBackground(),buttons[10].getBackground(),buttons[11].getBackground(),buttons[12].getBackground(),
                buttons[13].getBackground(),buttons[14].getBackground(),buttons[15].getBackground()};

        for(var but:buttons){
            but.setBackground(Color.WHITE);
        }

        for(var but:buttons){
            but.addActionListener(new ActionListener() {
                int indeks=0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < 16; i++) {
                        if (buttons[i] == but) {
                            indeks = i;
                        }
                    }
                    but.setBackground(permutacja[indeks]);
                    boolean jestbaily=false;
                    for(var bb:buttons){
                        if(bb.getBackground().equals(Color.WHITE)){
                            jestbaily=true;
                        }
                    }
                    if(!jestbaily){
                        JOptionPane.showMessageDialog(null,":)");
                    }
                }
            });

            but.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    but.setText("Click me!");
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    but.setText("Button");
                }
            });
        }


        label.setText("Game duration: 0");
        Timer timer = new Timer(1000, new ActionListener() {
            int secondsElapsed = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                secondsElapsed++;
                label.setText("Game duration: " + secondsElapsed );
            }
        });
        timer.start();



        ///////gra
        //nie zrobiona(

        String path = "./gra.txt";
        zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(InputStream is= new FileInputStream(path)) {
                    //////////////
                    JOptionPane.showMessageDialog(null, "gra zostala zapisana");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "blad");
                }
            }
        });


    }





}


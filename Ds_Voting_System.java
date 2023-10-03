import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.text.*;  
import java.util.*; 
import java.util.Scanner;
import java.util.Calendar;
import sun.audio.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
class Ds_Voting_System extends JFrame implements ActionListener,Runnable,ChangeListener
{
    JFrame f,f1;
    Frame fload;
    Robot bot;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jbb;
    JPasswordField pf;
    JMenu j1,j2,j3,j4;
    JMenuBar jm;
    Image dimage1;
    BufferedImage image1=null;
    char chh[] = {'D','d','h','a','w','a','l',' ',' ',' ',' '};
    JLabel label1,label2,label3,label4,label5,label6,labelb,label11,label12,label13,label14,label15,label16,label1b,lab1;   
    String na[] = new String[6];
    JTextField jt[] = new JTextField[6];
    Thread t=null;  
    int hours=0, minutes=0, seconds=0;  
    String timeString = "",postn="",schooln="";  
    JLabel l,l1,l2,ll1,ll2,labelnn;  
    int divHei=0,colorno=0;
    Font ff1 = new Font("Montype Corsiva", Font.BOLD|Font.ITALIC, 14);
    Font ff2 =new Font("Mistral", Font.PLAIN, 62);
    Font ff3 =new Font("sans-serif", Font.PLAIN, 40);
    int size1=8,size2=6,style1=157,style2=161,size3=6,style3=157;
    JButton b1,b2,b3,b4,b5,b6,b7,b8,bcno,bcna,sa,ent,bcpl,tool,bcr,log,clo,cha,bsv,bst,bup;
    int v1=0,v2=0,v3=0,v4=0,v5=0,v6=0,n=0,ni=0,count=2,cl=0,checkc=0,checkt=0,check=0,open=0,checka=0,checklb=0,checkj=0;
    int xSize=0,ySize=0,fxs=0,fys=0,ot=0,wid=0,Hei=0;
    String sib,si1,si2,si3,si4,si5,si6;
    JComboBox cbb,sizeComboBox;
    JTextField canvas = new JTextField("");
    JSlider red = new JSlider(0,255,0);
    JSlider green = new JSlider(0,255,0);
    JSlider blue = new JSlider(0,255,0);
    JRadioButton jrb;
    JTextField tfn,tfo;
    AudioStream as;
    InputStream in;
    Color nilback,canback;
    String gf;
    JPanel panelf;
    Ds_Voting_System()
    {
        Toolkit tk = Toolkit.getDefaultToolkit();
        xSize = ((int)tk.getScreenSize().getWidth());
        ySize = ((int)tk.getScreenSize().getHeight());
        fxs=xSize/2;
        fys=ySize/2;
        loading();
        nilback = Color.black;
        canback = Color.white;
        f= new JFrame(" D's Voting System ");
        f1 = new JFrame("");
        b1 = new JButton(" CANDIDATE 1 ");
        b2 = new JButton(" CANDIDATE 2 ");
        b3 = new JButton(" CANDIDATE 3 ");
        b4 = new JButton(" CANDIDATE 4 ");
        b5 = new JButton(" CANDIDATE 5 ");
        b6 = new JButton(" CANDIDATE 6 ");
        b7 = new JButton(" NILL ");
        ent= new JButton(" Enter ");
        sa= new JButton(" Save ");
        jb1 = new JButton(" Candidate 1 ");
        jb2  = new JButton(" Candidate 2 ");
        jb3 = new JButton(" Candidate 3 ");
        jb4  = new JButton(" Candidate 4 ");
        jb5 = new JButton(" Candidate 5");
        jb6  = new JButton(" Candidate 6 ");
        jbb = new JButton(" Background");
        j1 = new JMenu(" Edit");
        j2 = new JMenu(" Tool ");
        j3 = new JMenu(" Help ");
        j4 = new JMenu(" Add ");
        jm =  new JMenuBar();

        sa = new JButton(" SAVE ");
        clo = new JButton("CLOSE");

        b8 = new JButton();

        f.setSize(xSize,ySize);

        sib= "C:/Program Files/D's Voting System/Background.jpg";
        si1= "C:/Program Files/D's Voting System/candidate.png";
        si2= "C:/Program Files/D's Voting System/candidate.png";
        si3= "C:/Program Files/D's Voting System/candidate.png";
        si4= "C:/Program Files/D's Voting System/candidate.png";
        si5= "C:/Program Files/D's Voting System/candidate.png";
        si6= "C:/Program Files/D's Voting System/candidate.png";

        panelf = (JPanel)f.getContentPane();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        labelb = new JLabel();
        lab1 = new JLabel();
        labelnn = new JLabel("\u00a9"+" Diwakar_Dhawal");
        labelnn.setFont(new Font("Matura MT Script Capitals", Font.BOLD|Font.ITALIC, 18));
        b7.setForeground(Color.white);
        cb1 = new JCheckBox(" Candidate 1 ");
        cb2 = new JCheckBox(" Candidate 2 ");
        cb3 = new JCheckBox(" Candidate 3 ");
        cb4 = new JCheckBox(" Candidate 4 ");
        cb5 = new JCheckBox(" Candidate 5 ");
        cb6 = new JCheckBox(" Candidate 6 ");
        cb7 = new JCheckBox("  ");
        l = new JLabel("");
        l1 = new JLabel("");
        l2 = new JLabel("");
        ll1 = new JLabel("");
        ll2 = new JLabel("");
        l2.setFont(new Font("Old English Text MT", Font.BOLD, 20));
        l1.setFont(new Font("Old English Text MT", Font.BOLD, 20));
        l.setFont(new Font("Forte", Font.BOLD, 18));
        DigitalWatch();
        change();
        try
        {
            FileReader fr = new FileReader("C:/Program Files/D's Voting System/Font.txt");
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(new File("C:/Program Files/D's Voting System/Font.txt"));
            String[] fonts = new String[262];
            for(int i=0;sc.hasNext();i++)
            {
                fonts[i] = sc.nextLine();

            }
            l2.setFont(new Font(fonts[182], Font.BOLD, 20));
            l1.setFont(new Font(fonts[182], Font.BOLD, 20));
            l.setFont(new Font(fonts[80], Font.BOLD, 18));
            labelnn.setFont(new Font(fonts[137], Font.BOLD|Font.ITALIC, 18));
            br.close();
            sc.close();
        }
        catch(Exception asd)
        {
        }
        editMenu();
        toolMenu();
        helpMenu();
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);
        l.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);
        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);

        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        label1.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b1.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        label2.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b2.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        label3.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b3.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        label4.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b4.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        label5.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b5.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        label6.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    b6.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);

        jbb.addActionListener(this);
        ent.addActionListener(this);
        sa.addActionListener(this);
        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(ll1);
        f.add(ll2);
        f.add(labelnn);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        ll1.setVisible(false);
        ll2.setVisible(false);
        j1.setVisible(false);
        j2.setVisible(false);
        jm.add(j4);
        jm.add(j1);
        jm.add(j2);
        jm.add(j3);

        j1.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {

                }

                @Override
                public void mousePressed(MouseEvent me)
                {
                    j2.setEnabled(false);
                    j1.setEnabled(true);
                    j4.setEnabled(false);
                    check=1;

                    if(checkc==0)
                    {
                        lock();

                    }

                }

                @Override
                public void mouseEntered(MouseEvent me)
                {

                }

                @Override
                public void mouseReleased(MouseEvent me)
                {

                }
            });
        j2.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {

                }

                @Override
                public void mousePressed(MouseEvent me)
                {
                    j1.setEnabled(false);
                    j2.setEnabled(true);
                    j4.setEnabled(false);
                    check=2;

                    if(checkt==0)
                    {
                        lock();

                    }

                }

                @Override
                public void mouseEntered(MouseEvent me)
                {

                }

                @Override
                public void mouseReleased(MouseEvent me)
                {

                }
            });
        j4.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {

                }

                @Override
                public void mousePressed(MouseEvent me)
                {
                    if(checkj==0)
                    {
                        j1.setEnabled(false);
                        j2.setEnabled(false);
                        j4.setEnabled(true);
                        check=9;
                        lock();
                    }

                }

                @Override
                public void mouseEntered(MouseEvent me)
                {

                }

                @Override
                public void mouseReleased(MouseEvent me)
                {

                }
            });
        f.setJMenuBar(jm);
        f.add(b8);
        ImageIcon icon = new ImageIcon("C:/Program Files/D's Voting System/D's Voting System icon.jpg");
        f.setIconImage(icon.getImage());
        panelf.add(label1);
        panelf.add(label2);
        panelf.add(label3);
        panelf.add(label4);
        panelf.add(label5);
        panelf.add(label6);

        panelf.add(labelb);

        panelf.setLayout(null);
        fload.dispose();

        try
        {
            prev();
        }
        catch(IOException sdf)
        {

        }
        b1.setFont(ff1);
        b2.setFont(ff1);
        b3.setFont(ff1);
        b4.setFont(ff1);
        b5.setFont(ff1);
        b6.setFont(ff1);
        Font type1 = new Font("Arial Black", Font.BOLD, 16);
        b7.setFont(type1);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        f.setVisible(true);
        red.setMajorTickSpacing(50);
        red.setMinorTickSpacing(10);
        red.setPaintTicks(true);
        red.setPaintLabels(true);
        red.addChangeListener(this);
        green.setMajorTickSpacing(50);
        green.setMinorTickSpacing(10);
        green.setPaintTicks(true);
        green.setPaintLabels(true);
        green.addChangeListener(this);
        blue.setMajorTickSpacing(50);
        blue.setMinorTickSpacing(10);
        blue.setPaintTicks(true);
        blue.setPaintLabels(true);
        blue.addChangeListener(this);
        canvas.setEnabled(false);
        f.setResizable(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);

        clo.addActionListener(this);

        b1.setBackground(canback);
        b2.setBackground(canback);
        b3.setBackground(canback);
        b4.setBackground(canback);
        b5.setBackground(canback);
        b6.setBackground(canback);
        b7.setBackground(nilback);
        f.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we )
                {
                    cl=1;
                    lock();
                }
            });
        f.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                }

                @Override
                public void mouseExited(MouseEvent me)
                {

                }

                @Override
                public void mousePressed(MouseEvent me)
                {
                    int xSize1 = f.getWidth();
                    int ySize1 = f.getHeight();

                    if(xSize==xSize1&&ySize==ySize1)
                    {
                    }
                    else
                    {

                        xSize = xSize1;
                        ySize= ySize1;
                        infoMessage(" Please Wait for few seconds After this Message... "," Changing Size ");
                        change();
                    }

                }

                @Override
                public void mouseEntered(MouseEvent me)
                {

                }

                @Override
                public void mouseReleased(MouseEvent me)
                {
                }
            });

    }

    public void loading()
    {
        fload = new Frame(" Loading... ");

        try
        {
            ImageIcon load = new ImageIcon("C:/Program Files/D's Voting System/load.gif");
            ImageIcon load1 = new ImageIcon("C:/Program Files/D's Voting System/school.jpg");
            JLabel j1 = new JLabel();
            j1.setIcon(load1);
            JLabel j12 = new JLabel();
            JLabel jn = new JLabel();
            j12.setIcon(load);
            j1.setBounds(0,0,200,200);
            j12.setBounds(00,150,200,1000);
            Panel p = new Panel();
            p.add(j1);
            p.add(j12);
            fload.add(p);
        }
        catch(Exception asd)
        {
        }

        fload.setSize(200,350);
        fload.setLocation(fxs-100,fys-175);
        fload.setUndecorated(true);

        fload.setVisible(true);
    }

    public void loadingRF()
    {
        fload = new Frame(" Loading... ");

        try
        {
            ImageIcon load = new ImageIcon("C:/Program Files/D's Voting System/load1.gif");
            ImageIcon load1;
            if(open==1)
            {
                load1 = new ImageIcon("C:/Program Files/D's Voting System/result.png");
            }
            else
            {
                load1 = new ImageIcon("C:/Program Files/D's Voting System/database.jpg");
            }
            JLabel j1 = new JLabel();
            j1.setIcon(load1);
            JLabel j12 = new JLabel();
            JLabel jn = new JLabel();
            j12.setIcon(load);
            j1.setBounds(0,0,240,200);
            j12.setBounds(00,150,240,1000);
            Panel p = new Panel();
            p.add(j1);
            p.add(j12);
            fload.add(p);
        }
        catch(Exception asd)
        {
        }

        fload.setSize(240,350);
        fload.setLocation(fxs-120,fys-175);
        fload.setUndecorated(true);

        fload.setVisible(true);
    }

    public void changingsize()
    {
        if(b1.isVisible()||b2.isVisible()||b3.isVisible()||b4.isVisible()||b5.isVisible()||b6.isVisible())
        {
            f1 = new JFrame(" Changing Size");
            final JFrame f2 = new JFrame(" Components");
            final JCheckBox jccb1 = new JCheckBox(" Candidate 1");
            final JCheckBox jccb2 = new JCheckBox(" Candidate 2");
            final JCheckBox jccb3 = new JCheckBox(" Candidate 3");
            final JCheckBox jccb4 = new JCheckBox(" Candidate 4");
            final JCheckBox jccb5 = new JCheckBox(" Candidate 5");
            final JCheckBox jccb6 = new JCheckBox(" Candidate 6");
            final JCheckBox jccno = new JCheckBox("");
            JButton jup = new JButton(" Update");
            int j = 30;

            if(b1.isVisible())
            {
                jccb1.setBounds(30,j+10,150,40);
                f2.add(jccb1);
                j=j+50;
            }   
            if(b2.isVisible())
            {
                jccb2.setBounds(30,j+10,150,40);
                f2.add(jccb2);
                j=j+50;
            }
            if(b3.isVisible())
            {
                jccb3.setBounds(30,j+10,150,40);
                f2.add(jccb3);
                j=j+50;
            }
            if(b4.isVisible())
            {
                jccb4.setBounds(30,j+10,150,40);
                f2.add(jccb4);
                j=j+50;
            }
            if(b5.isVisible())
            {
                jccb5.setBounds(30,j+10,150,40);
                f2.add(jccb5);
                j=j+50;
            }
            if(b6.isVisible())
            {
                jb6.setBounds(30,j+10,150,40);
                f2.add(jccb6);
                j=j+50;
            }
            j=j+5;
            jup.setBounds(100,j,80,40);
            f2.add(jup);
            j=j+70;
            f2.add(jccno);
            jccno.setVisible(false);
            JPanel p = new JPanel();
            try
            {
                image1= ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
                dimage1 = image1.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
                lab1.setIcon(new ImageIcon(dimage1));
            }
            catch(Exception sdf)
            {
            }
            p.addComponentListener(new ComponentAdapter()
                {
                    public void componentResized(ComponentEvent evt)
                    {
                        try
                        {
                            dimage1 = image1.getScaledInstance(f1.getWidth()-20,f1.getHeight()-45,Image.SCALE_SMOOTH);
                        }
                        catch(Exception asd)
                        {
                            JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                            final JDialog dialog = pane.createDialog("Error");
                            dialog.setVisible(true);
                        }
                        lab1.setIcon(new ImageIcon(dimage1));

                        f2.setLocation(f1.getX()+f1.getWidth()+10,f1.getY());
                    }

                });
            jup.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent asa)
                    {
                        wid = f1.getWidth();
                        Hei = f1.getHeight();
                        int w;
                        if(wid>150)
                        {
                            w=wid-100;
                        }
                        else
                            w=150;
                        int a = w/2;
                        if(jccb1.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si1));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label1.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }

                            label1.setSize(wid,Hei);
                            b1.setBounds(label1.getX()+wid/2-a ,label1.getY()+Hei-40 , w , 40);
                        }
                        if(jccb2.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si2));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label2.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }
                            label2.setSize(wid,Hei);
                            b2.setBounds(label2.getX()+wid/2-a , label2.getY()+Hei-40 , w , 40);
                        }
                        if(jccb3.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si3));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label3.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }
                            label3.setSize(wid,Hei);
                            b3.setBounds(label3.getX()+wid/2-a , label3.getY()+Hei-40 , w , 40);
                        }
                        if(jccb4.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si4));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label4.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }
                            label4.setSize(wid,Hei);
                            b4.setBounds(label4.getX()+wid/2-a , label4.getY()+Hei-40 , w , 40);
                        }
                        if(jccb5.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si5));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label5.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }
                            label5.setSize(wid,Hei);
                            b5.setBounds(label5.getX()+wid/2-a , label5.getY()+Hei-40 , w , 40);
                        }
                        if(jccb6.isSelected())
                        {
                            try
                            {
                                BufferedImage img = ImageIO.read(new File(si6));;
                                Image dimg = img.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);
                                label6.setIcon(new ImageIcon(dimg));
                            }
                            catch(Exception asd)
                            {
                                JOptionPane pane = new JOptionPane("Error", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
                                final JDialog dialog = pane.createDialog("Error");
                                dialog.setVisible(true);
                            }
                            label6.setSize(wid,Hei);
                            b6.setBounds(label6.getX()+wid/2-a , label6.getY()+Hei-40 , w , 40);
                        }
                    }
                });
            p.add(lab1);
            f1.add(p);
            f1.pack();
            f1.setLocation(fxs-f1.getWidth(),j/2);
            f2.setLocation(f1.getX()+f1.getWidth()+5,f1.getY());
            f2.setSize(230,j+10);
            f1.setVisible(true);
            f2.setVisible(true);
            f2.setLayout(null);
            f1.addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent we )
                    {
                        f1.dispose();
                        f2.dispose();
                    }
                });
            f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            f2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        else
        {
            errorMessage(" Select Some Candidates to Change Size ");
        }
    }

    public void thank()
    {
        fload.dispose();
        fload = new Frame(" thank you ");

        try
        {
            ImageIcon load = new ImageIcon("C:/Program Files/D's Voting System/thank you.gif");

            fload.add(new JLabel("",load,JLabel.CENTER));
        }
        catch(Exception asd)
        {
        }

        fload.setSize(210,124);
        fload.setLocation(fxs-105,fys-62);
        fload.setUndecorated(true);

        fload.setVisible(true);

    }

    public void change()
    {

        BufferedImage img1 = null;
        BufferedImage img2 = null;
        BufferedImage img3 = null;
        BufferedImage img4 = null;
        BufferedImage img5 = null;
        BufferedImage img6 = null;
        BufferedImage imgb = null;
        try
        {
            img1 = ImageIO.read(new File(si1));
            img2 = ImageIO.read(new File(si2));
            img3 = ImageIO.read(new File(si3));
            img4 = ImageIO.read(new File(si4));
            img5 = ImageIO.read(new File(si5));
            img6 = ImageIO.read(new File(si6));
            imgb = ImageIO.read(new File(sib));

        }
        catch(IOException e)
        {
        }
        int rySize = ySize-40;
        int divWid = xSize/4;
        divHei = rySize/3;
        wid = divHei+30;
        Hei = divHei-20;
        Image dimg1 = img1.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimg2 = img2.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimg3 = img3.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimg4 = img4.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimg5 = img5.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimg6 = img6.getScaledInstance(divHei+30,divHei-20,Image.SCALE_SMOOTH);
        Image dimgb = imgb.getScaledInstance(f.getWidth(),f.getHeight(),Image.SCALE_SMOOTH);

        label1.setIcon(new ImageIcon(dimg1));
        label2.setIcon(new ImageIcon(dimg2));
        label3.setIcon(new ImageIcon(dimg3));
        label4.setIcon(new ImageIcon(dimg4));
        label5.setIcon(new ImageIcon(dimg5));
        label6.setIcon(new ImageIcon(dimg6));
        labelb.setIcon(new ImageIcon(dimgb));

        labelb.setBounds(0,0,f.getWidth(),f.getHeight());
        label1.setBounds(40 , 10,divHei+30,divHei-20);
        label2.setBounds(xSize-divHei-40-40 , 10,divHei+30,divHei-20);
        label3.setBounds(40 , divHei , divHei+30,divHei-20);
        label4.setBounds(xSize-divHei-40-40 , divHei,divHei+30,divHei-20);
        label5.setBounds(40,2*divHei -10, divHei+30,divHei-20);
        label6.setBounds(xSize-divHei-40-40 , 2*divHei-10,divHei+30,divHei-20);
        int w;
        if(divHei+30>150)
        {
            w=(divHei+30)-100;
        }
        else
            w=150;
        int a = w/2;
        b1.setBounds(label1.getX()+(divHei+30)/2-a , divHei-50 , w , 40);
        b2.setBounds(label2.getX()+(divHei+30)/2-a , divHei-50 , w , 40);
        b3.setBounds(label3.getX()+(divHei+30)/2-a , 2*divHei-50-10 , w , 40);
        b4.setBounds(label4.getX()+(divHei+30)/2-a , 2*divHei-50-10 , w , 40);
        b5.setBounds(label5.getX()+(divHei+30)/2-a , 3*divHei-50-20 , w , 40);
        b6.setBounds(label6.getX()+(divHei+30)/2-a , 3*divHei-50-20 , w , 40);
        b7.setBounds(xSize/2-a , 2*divHei+50 , w , 40);
        l2.setBounds(xSize/2+100,0,400,25);
        l.setBounds(xSize/2-20,00,400,25); 
        l1.setBounds(xSize/2-200,0,400,25);
        ll2.setBounds(label1.getX()+(divHei+50),100,xSize,80);
        ll1.setBounds(label1.getX()+(divHei+50),40,xSize,80);
        labelnn.setBounds(xSize-(divHei+300),ySize-100,xSize,25);
    }

    public void prev()throws IOException
    {

        File folder = new File("C:/D's Voting System Data");
        if(!folder.exists())
            folder.mkdir();
        File folder1 = new File("C:/D's Voting System Backup");
        if(!folder1.exists())
        {
            folder1.mkdir();
            try
            {
                hide(folder1);
            }
            catch(Exception df)
            {
            }

        }
        else
        {
            try
            {
                show(folder1);
            }
            catch(Exception df)
            {
            }
            File Res  = new File("C:/D's Voting System Backup/EncR.encrypted");
            if(Res.exists())
            {
                decrypt(Res);
            }
            File FRes = new File("C:/D's Voting System Backup/EncData.encrypted");
            if(FRes.exists())
            {
                decrypt(FRes);
            }
            try
            {
                hide(folder1);
            }
            catch(Exception df)
            {
            }
        }
        try
        {
            FileReader fr = new FileReader("C:/D's Voting System Data/Result.txt");
            BufferedReader br = new BufferedReader(fr);
            Scanner sc = new Scanner(new File("C:/D's Voting System Data/Result.txt"));
            int a = sc.nextInt();
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            v3 = sc.nextInt();
            v4 = sc.nextInt();
            v5 = sc.nextInt();
            v6 = sc.nextInt();
            ni  = sc.nextInt();
            sc.close();
            br.close();
            fr.close();
        } 
        catch(Exception adf)
        {
            v1=0;v2=0;v3=0;v4=0;v5=0;v6=0;ni=0;
        }
    }

    public void disenable(boolean b)
    { 
        b1.setEnabled(b);
        b2.setEnabled(b);
        b3.setEnabled(b);
        b4.setEnabled(b);
        b5.setEnabled(b);
        b6.setEnabled(b);
        b7.setEnabled(b);
    }

    public void changingLocation(final JLabel jlab,final JButton jbut)
    {
        JButton jb1 = new JButton(" Move UP ");
        JButton jb2 = new JButton(" Move DOWN ");
        JButton jb3 = new JButton(" Move RIGHT ");
        JButton jb4 = new JButton(" Move LEFT ");
        JLabel df = new JLabel("");
        df.setVisible(false);
        JFrame ff1 = new JFrame("Location");
        jb1.setBounds(130,10,150,40);
        jb2.setBounds(130,110,150,40);
        jb4.setBounds(10,60,150,40);
        jb3.setBounds(250,60,150,40);
        ff1.add(jb1);
        ff1.add(jb2);
        ff1.add(jb3);
        ff1.add(jb4);
        ff1.add(df);
        jb1.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {}

                @Override
                public void mousePressed(MouseEvent me)
                {
                    jlab.setLocation(jlab.getX(),jlab.getY()-10);
                    if(jbut!=null)
                        jbut.setLocation(jbut.getX(),jbut.getY()-10);
                }

                @Override
                public void mouseEntered(MouseEvent me)
                {}

                @Override
                public void mouseReleased(MouseEvent me)
                {}
            });
        jb2.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {}

                @Override
                public void mousePressed(MouseEvent me)
                {
                    jlab.setLocation(jlab.getX(),jlab.getY()+10);
                    if(jbut!=null)
                        jbut.setLocation(jbut.getX(),jbut.getY()+10);
                }

                @Override
                public void mouseEntered(MouseEvent me)
                {}

                @Override
                public void mouseReleased(MouseEvent me)
                {}
            });
        jb3.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {}

                @Override
                public void mousePressed(MouseEvent me)
                {
                    jlab.setLocation(jlab.getX()+10,jlab.getY());
                    if(jbut!=null)
                        jbut.setLocation(jbut.getX()+10,jbut.getY());
                }

                @Override
                public void mouseEntered(MouseEvent me)
                {}

                @Override
                public void mouseReleased(MouseEvent me)
                {}
            });
        jb4.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {

                }

                @Override
                public void mouseExited(MouseEvent me)
                {}

                @Override
                public void mousePressed(MouseEvent me)
                {
                    jlab.setLocation(jlab.getX()-10,jlab.getY());
                    if(jbut!=null)
                        jbut.setLocation(jbut.getX()-10,jbut.getY());
                }

                @Override
                public void mouseEntered(MouseEvent me)
                {}

                @Override
                public void mouseReleased(MouseEvent me)
                {}
            });

        ff1.setSize(430,200);
        ff1.setLocation(xSize/2-215,ySize/2-100);
        ff1.setVisible(true);
        ff1.setResizable(false);

    }

    public void passInput()throws IOException
    {
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
            show(folder);

        FileOutputStream fout = new FileOutputStream("C:/D's Voting System Backup/Pass.dat");
        DataOutputStream ffout = new DataOutputStream(fout);
        for(int i=0;i<10;i++)
        {
            ffout.writeChar(chh[i]);
        }
        fout.close();
        ffout.close();
        if(folder.exists())
            hide(folder);
    }

    public void Colors()
    {
        final JFrame f2 = new JFrame("Color Slide"); 
        f2.setBounds(xSize/2-135,ySize/2-150,270,300);
        f2.setVisible(true);
        f2.setResizable(false);
        JButton b =new JButton(" Change ");
        JLabel redLabel = new JLabel("Red: ");
        JLabel greenLabel = new JLabel("Green: ");
        JLabel blueLabel = new JLabel("Blue: ");
        GridLayout grid = new GridLayout(5,1);
        FlowLayout right = new FlowLayout(FlowLayout.RIGHT);
        Container pane = f2.getContentPane();
        pane.setLayout(grid);
        JPanel redPanel = new JPanel();
        redPanel.setLayout(right);
        redPanel.add(redLabel);
        redPanel.add(red);
        pane.add(redPanel);
        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(right);
        greenPanel.add(greenLabel);
        greenPanel.add(green);
        pane.add(greenPanel);
        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(right);
        bluePanel.add(blueLabel);
        bluePanel.add(blue);
        pane.add(bluePanel);
        pane.add(canvas);
        JPanel button = new JPanel();
        b.setLayout(right);
        button.add(b);
        pane.add(button);
        f2.setContentPane(pane);
        b.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent asd)
                {
                    Color c = canvas.getBackground();
                    if(colorno==1)
                    {
                        b1.setBackground(c);
                        b2.setBackground(c);
                        b3.setBackground(c);
                        b4.setBackground(c);
                        b5.setBackground(c);
                        b6.setBackground(c);
                        canback = c;
                    }
                    if(colorno==2)
                    {
                        b1.setForeground(c);
                        b2.setForeground(c);
                        b3.setForeground(c);
                        b4.setForeground(c);
                        b5.setForeground(c);
                        b6.setForeground(c);
                    }
                    if(colorno==3)
                    {
                        b7.setBackground(c);
                        nilback =c;
                    }
                    if(colorno==4)
                    {
                        b7.setForeground(c);
                    }
                    if(colorno==5)
                    {
                        ll1.setForeground(c);
                    }
                    if(colorno==6)
                    {
                        ll2.setForeground(c);
                    }
                    f2.dispose();

                }
            });

    }

    public void passOutput()throws IOException
    {
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
            show(folder);
        FileInputStream fit = new FileInputStream("C:/D's Voting System Backup/Pass.dat");
        DataInputStream ffit = new DataInputStream(fit);
        for(int i=0;i<10;i++)
        {
            chh[i] = ffit.readChar();
        }
        ffit.close();
        fit.close();
        if(folder.exists())
            hide(folder);
    }

    public void colour(Color Colcan,Color Colnil)
    {
        b1.setBackground(Colcan);
        b2.setBackground(Colcan);
        b3.setBackground(Colcan);
        b4.setBackground(Colcan);
        b5.setBackground(Colcan);
        b6.setBackground(Colcan);
        b7.setBackground(Colnil);
    }

    public void lock()
    {
        if(f1.isVisible())
            f1.dispose();
        f1 = new JFrame("LOG IN ");
        JLabel lab = new JLabel();
        int wi = 190;
        if(check==3)
        {
            lab.setText(" Enter Current Password :");
            wi =  250;
        }
        else if(check==6)
        {
            lab.setText(" Enter Admin Password :");
            wi = 220;
        }
        else
        {
            lab.setText("Password :");
            wi = 190;
        }
        if(cl==1)
            lab.setText("Password :");
        pf = new JPasswordField(20);
        log = new JButton("LOGIN");
        pf.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent key)
                {
                    if(key.getKeyChar()==KeyEvent.VK_ENTER)
                    {
                        if(cl==0)
                            log.doClick();
                        if(cl==1)
                            clo.doClick();
                    }   
                }
            });
        f1.add(lab);
        f1.add(pf);
        if(cl==0)
            f1.add(log);
        if(cl==1)
            f1.add(clo);

        f1.setLayout(new FlowLayout());
        f1.setResizable(false);

        f1.setLocation(fxs-wi,fys-50);
        gf = "C:/Program Files/D's Voting System/mali.wav";
        try
        {
            music();
        }
        catch(Exception wesd)
        {
        }
        log.addActionListener(this);
        f1.setVisible(true);
        f1.pack();
    }

    public void editMenu()
    {
        JMenuItem item;
        item = new JMenuItem("Number Of Candidates ");
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Name Of Candidates ");
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Name Of School And Post "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Picture Of Candidates "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Sizes and Fonts "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Picture's Size "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Colors "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("School Name Location "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Post Name Location "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("Picture's Location "); 
        item.addActionListener(this);
        j1.add(item);
        item = new JMenuItem("View "); 
        item.addActionListener(this);
        j1.add(item);
    }

    public void helpMenu()
    {
        JMenuItem item;
        item = new JMenuItem("Forgotten Password ");
        item.addActionListener(this);
        j3.add(item);
        item = new JMenuItem("Instructions ");
        item.addActionListener(this);
        j3.add(item);
        item = new JMenuItem("About ");
        item.addActionListener(this);
        j3.add(item);
    }

    public void toolMenu()
    {

        JMenuItem item;
        item = new JMenuItem("Result ");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Display Database ");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Add Result to Database ");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Reset Password");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Reset Votes");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Clear Database ");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Lock Menus ");
        item.addActionListener(this);
        j2.add(item);
        item = new JMenuItem("Hide Menus ");
        item.addActionListener(this);
        j2.add(item);
    }

    public void DigitalWatch(){  
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("  MMMM dd yyyy");
        Date date = new Date();

        l1.setText(""+formatter.format( date ));
        formatter = new SimpleDateFormat("EEEE  ");
        l2.setText(""+formatter.format( date ));
        t = new Thread(this);  

        t.start();  

        l.setBackground(Color.white);
        l.setForeground(Color.red);
        l.setVisible(true);
        l1.setVisible(true);
        l2.setVisible(true);

        f.add(l);  
        f.add(l1); 
        f.add(l2); 
    }  

    public void printTime(){  
        l.setText(timeString);  
    } 

    public void run() {  
        try {  
            while (true) {  

                Calendar cal = Calendar.getInstance();  
                hours = cal.get( Calendar.HOUR_OF_DAY );  
                if ( hours > 12 )
                    hours -= 12;  
                minutes = cal.get( Calendar.MINUTE );  
                seconds = cal.get( Calendar.SECOND );  

                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");  
                Date date = cal.getTime();  
                timeString = formatter.format( date );  

                printTime();  

                t.sleep( 1000 );
            }  
        }  
        catch (Exception e) { }  
    }

    public void adding()
    {
        f1 = new JFrame("Add");
        bsv = new JButton(" START VOTING ");
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        BufferedImage img3 = null;
        BufferedImage img4 = null;
        BufferedImage img5 = null;
        BufferedImage img6 = null;
        BufferedImage imgb = null;
        try
        {
            img1 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            img2 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            img3 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            img4 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            img5 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            img6 = ImageIO.read(new File("C:/Program Files/D's Voting System/candidate.png"));
            imgb = ImageIO.read(new File("C:/Program Files/D's Voting System/Background.jpg"));

        }
        catch(IOException e)
        {
        }
        int rySize = ySize-40;
        int divWid = xSize/4;
        divHei = rySize/3;
        Image dimg1 = img1.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimg2 = img2.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimg3 = img3.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimg4 = img4.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimg5 = img5.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimg6 = img6.getScaledInstance(divHei,divHei-55,Image.SCALE_SMOOTH);
        Image dimgb = imgb.getScaledInstance(f.getWidth(),f.getHeight(),Image.SCALE_SMOOTH);

        label11=new JLabel("");
        label12=new JLabel("");
        label13=new JLabel("");
        label14=new JLabel("");
        label15=new JLabel("");
        label16=new JLabel("");
        label1b= new JLabel("");
        label11.setIcon(new ImageIcon(dimg1));
        label12.setIcon(new ImageIcon(dimg2));
        label13.setIcon(new ImageIcon(dimg3));
        label14.setIcon(new ImageIcon(dimg4));
        label15.setIcon(new ImageIcon(dimg5));
        label16.setIcon(new ImageIcon(dimg6));
        label1b.setIcon(new ImageIcon(dimgb));

        label1b.setBounds(0,0,f.getWidth(),f.getHeight());
        label11.setBounds(40 , 10,divHei,divHei-55);
        label12.setBounds(xSize-divHei-40-40 , 10,divHei,divHei-55);
        label13.setBounds(40 , divHei , divHei,divHei-55);
        label14.setBounds(xSize-divHei-40-40 , divHei,divHei,divHei-55);
        label15.setBounds(40,2*divHei -10, divHei,divHei-55);
        label16.setBounds(xSize-divHei-40-40 , 2*divHei-10,divHei,divHei-55);
        int w;
        if(divHei+30>150)
        {
            w=(divHei+30)-100;
        }
        else
            w=150;
        int a = w/2;
        jt[0] = new JTextField("Candidate 1");
        jt[1] = new JTextField("Candidate 2");
        jt[2] = new JTextField("Candidate 3");
        jt[3] = new JTextField("Candidate 4");
        jt[4] = new JTextField("Candidate 5");
        jt[5] = new JTextField("Candidate 6");
        jt[0].setBounds(label1.getX()+(divHei)/2-a , divHei-45 , w , 30);
        jt[1].setBounds(label2.getX()+(divHei)/2-a , divHei-45 , w , 30);
        jt[2].setBounds(label3.getX()+(divHei)/2-a , 2*divHei-45-10 , w , 30);
        jt[3].setBounds(label4.getX()+(divHei)/2-a , 2*divHei-45-10 , w , 30);
        jt[4].setBounds(label5.getX()+(divHei)/2-a , 3*divHei-45-20 , w , 30);
        jt[5].setBounds(label6.getX()+(divHei)/2-a , 3*divHei-45-20 , w , 30);
        bsv.setBounds(xSize/2-a , 2*divHei+50 , w , 40);
        bsv.setVisible(true);
        label11.setVisible(true);
        label12.setVisible(true);
        label13.setVisible(true);
        label14.setVisible(true);
        label15.setVisible(true);
        label16.setVisible(true);
        label1b.setVisible(true);
        jt[0].setVisible(true);
        jt[1].setVisible(true);
        jt[2].setVisible(true);
        jt[3].setVisible(true);
        jt[4].setVisible(true);
        jt[5].setVisible(true);
        JButton sdf = new JButton();
        sdf.setVisible(true);
        label11.setEnabled(false);
        label12.setEnabled(false);
        label13.setEnabled(false);
        label14.setEnabled(false);
        label15.setEnabled(false);
        label16.setEnabled(false);
        jt[0].setEnabled(false);
        jt[1].setEnabled(false);
        jt[2].setEnabled(false);
        jt[3].setEnabled(false);
        jt[4].setEnabled(false);
        jt[5].setEnabled(false);

        f1.add(jt[0]);
        f1.add(jt[1]);
        f1.add(jt[2]);
        f1.add(jt[3]);
        f1.add(jt[4]);
        f1.add(jt[5]);
        f1.add(label11);
        f1.add(label12);
        f1.add(label13);
        f1.add(label14);
        f1.add(label15);
        f1.add(label16);
        f1.add(bsv);
        f1.add(label1b);
        JLabel no = new JLabel("");
        no.setVisible(false);

        f1.add(sdf);
        f1.add(no);
        bsv.addActionListener(this);
        label11.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label11.isEnabled()==true)
                        {
                            label11.setEnabled(false);
                            jt[0].setEnabled(false);
                            cb1.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label11.isEnabled()==false)
                        {
                            label11.setEnabled(true);
                            jt[0].setEnabled(true);
                            cb1.setSelected(true);
                        }
                        else
                            jb1.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label12.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label12.isEnabled()==true)
                        {
                            label12.setEnabled(false);
                            jt[1].setEnabled(false);
                            cb2.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label12.isEnabled()==false)
                        {
                            label12.setEnabled(true);
                            jt[1].setEnabled(true);
                            cb2.setSelected(true);
                        }
                        else
                            jb2.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label13.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label13.isEnabled()==true)
                        {
                            label13.setEnabled(false);
                            jt[2].setEnabled(false);
                            cb3.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label13.isEnabled()==false)
                        {
                            label13.setEnabled(true);
                            jt[2].setEnabled(true);
                            cb3.setSelected(true);
                        }
                        else
                            jb3.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label14.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label14.isEnabled()==true)
                        {
                            label14.setEnabled(false);
                            jt[3].setEnabled(false);
                            cb4.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label14.isEnabled()==false)
                        {
                            label14.setEnabled(true);
                            jt[3].setEnabled(true);
                            cb4.setSelected(true);
                        }
                        else
                            jb4.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label15.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label15.isEnabled()==true)
                        {
                            label15.setEnabled(false);
                            jt[4].setEnabled(false);
                            cb5.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label15.isEnabled()==false)
                        {
                            label15.setEnabled(true);
                            jt[4].setEnabled(true);
                            cb5.setSelected(true);
                        }
                        else
                            jb5.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label16.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    if(SwingUtilities.isRightMouseButton(me))
                    {
                        if(label16.isEnabled()==true)
                        {
                            label16.setEnabled(false);
                            jt[5].setEnabled(false);
                            cb6.setSelected(false);
                        }
                    }
                    if(SwingUtilities.isLeftMouseButton(me))
                    {
                        if(label16.isEnabled()==false)
                        {
                            label16.setEnabled(true);
                            jt[5].setEnabled(true);
                            cb6.setSelected(true);
                        }
                        else
                            jb6.doClick();
                    }
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });
        label1b.addMouseListener(new MouseListener()
            {
                @Override
                public void mouseClicked(MouseEvent me)
                {
                    jbb.doClick();
                }

                @Override
                public void mouseExited(MouseEvent me){}

                @Override
                public void mousePressed(MouseEvent me){}

                @Override
                public void mouseEntered(MouseEvent me){}

                @Override
                public void mouseReleased(MouseEvent me){}
            });

        f1.addWindowListener(new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we )
                {
                    bsv.doClick();
                }
            });
        f.setVisible(false);
        f1.setVisible(true);
        f1.setSize(xSize,ySize);
    }

    public void errorMessage(String sss)
    {
        gf = "C:/Program Files/D's Voting System/mali.wav";
        try
        {
            music();
        }
        catch(Exception wesd)
        {
        }
        JOptionPane pane = new JOptionPane(sss, JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        final JDialog dialog = pane.createDialog(" ERROR ");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                {public void actionPerformed(ActionEvent ae)
                    {
                        dialog.setVisible(false);
                    }
                });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }

    public void infoMessage(String sss,String sssn)
    {

        gf = "C:/Program Files/D's Voting System/menu.wav";
        try
        {
            music();
        }   catch(Exception wesd)
        {
        }
        JOptionPane pane = new JOptionPane(sss, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        final JDialog dialog = pane.createDialog(sssn);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                {public void actionPerformed(ActionEvent ae)
                    {
                        dialog.setVisible(false);
                    }
                });
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
        String s = e.getActionCommand();
        if(o==clo)
        {
            char ch[] = pf.getPassword();
            f1.dispose();
            cl=0;
            int len = ch.length;
            char c[] = new char[10];
            for(int a=0;a<len;a++)
                c[a] =ch[a];
            for(int a=len;a<10;a++)
                c[a] =' ';
            try
            {

                passOutput();
            }
            catch(IOException efd)
            {
            }
            if(ch[0]==chh[0]&&c[1]==chh[1]&&c[2]==chh[2]&&c[3]==chh[3]&&c[4]==chh[4]&&c[5]==chh[5]&&c[6]==chh[6]&&c[7]==chh[7]&&c[8]==chh[8]&&c[9]==chh[9])
            {
                gf = "C:/Program Files/D's Voting System/menu.wav";
                try
                {
                    music();
                }
                catch(Exception wesd)
                {
                }
                String btt[] = {"Yes","NO"};
                int PResult = JOptionPane.showOptionDialog(null,"Do You Want To Save Votes ?"," Save ", JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null,btt,btt[1]);
                if(PResult==0)
                {
                    try
                    {
                        FInput();
                    }
                    catch(IOException fd)
                    {
                    }

                }
                try
                {
                    music();
                }
                catch(Exception wesd)
                {
                }
                String btt1[] = {"Yes","NO"};
                int PResult1 = JOptionPane.showOptionDialog(null,"Do You Want To Reset Votes ?"," Resest ", JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null,btt,btt[1]);
                if(PResult1==0)
                {
                    try
                    {
                        reset();
                    }
                    catch(IOException fd)
                    {
                    }

                }

                gf = "C:/Program Files/D's Voting System/exit.wav";
                try
                {
                    music();
                }
                catch(Exception wesd)
                {
                }

                javax.swing.Timer timer = new javax.swing.Timer(9200, new ActionListener()
                        {public void actionPerformed(ActionEvent ae)
                            {
                                fload.dispose();
                                System.exit(0);
                            }
                        });
                thank();
                timer.setRepeats(false);
                timer.start();

            }
            else
            {
                errorMessage("Wrong Password");
                check=0;
            }
        }

        if(o==log)
        {
            char ch[] = pf.getPassword();
            int len = ch.length;
            char c[] = new char[10];
            for(int a=0;a<len;a++)
                c[a] =ch[a];
            for(int a=len;a<10;a++)
                c[a] =' ';
            if(check==6)
            {
                if(c[0]=='D'&&c[1]=='d'&&c[2]=='h'&&c[3]=='a'&&c[4]=='w'&&c[5]=='a'&&c[6]=='l'&&c[7]==' '&&c[8]==' '&&c[9]==' ')
                {

                    resetP();
                }
                else
                {errorMessage("Wrong Password");
                    check=0;
                }
            }
            else
            {
                try
                { 
                    passOutput();
                }
                catch(IOException efd)
                {
                }
                f1.dispose();
                if(c[0]==chh[0]&&c[1]==chh[1]&&c[2]==chh[2]&&c[3]==chh[3]&&c[4]==chh[4]&&c[5]==chh[5]&&c[6]==chh[6]&&c[7]==chh[7]&&c[8]==chh[8]&&c[9]==chh[9])
                {
                    String stri="";
                    if(check==1)
                    {
                        checkc=1;
                        infoMessage(" Edit Menu Unlocked ","unlocking Edit Menu");
                        j1.doClick();
                    }
                    if(check==2)
                    {
                        checkt=1;
                        infoMessage(" Tools Menu Unlocked ","unlocking Tools Menu");
                        j2.doClick();
                    }
                    if(check==3)
                        resetP();
                    if(check==4)
                    {
                        try
                        {
                            reset();
                        }
                        catch(IOException sdf)
                        {
                        }
                    }
                    if(check==5)
                    {
                        try
                        {
                            FClear();
                        }
                        catch(IOException sdf)
                        {
                        }
                    }

                    if(check==9||check==10)
                    {
                        f1 = new JFrame(" Criteria");
                        JLabel sn = new JLabel(" School Name : ");
                        String type[] =  {"School Leader","General Secretary","House Captain","House Vice Captain"};;
                        cbb = new JComboBox(type);
                        tfn = new JTextField();
                        JLabel sp = new JLabel(" Voting for Post Of  : ");
                        jrb = new JRadioButton(" Other : ");
                        tfo = new JTextField("");
                        JLabel jghf = new JLabel();
                        JButton but1 = new JButton(" UPDATE ");
                        gf = "C:/Program Files/D's Voting System/menu.wav";
                        try
                        {
                            music();
                        }   catch(Exception wesd)
                        {
                        }
                        tfo.setEnabled(false);
                        if(check==9)
                        {

                            bst=new JButton(" START ");
                            bst.setBounds(290,130,100,40);  
                            f1.add(bst); 
                            bst.addActionListener(this);
                        }
                        if(check==10)
                        {
                            tfn.setText(""+schooln);
                            but1.setBounds(290,130,100,40);  
                            if(ot==1)
                            {
                                cbb.setEnabled(false);
                                jrb.setSelected(true);

                                tfo.setText(""+postn);
                                tfo.setEnabled(true);
                            }
                            if(ot==0)
                            {
                                for(int i=0;i<type.length;i++)
                                {
                                    if(postn.equals(type[i]))
                                    {
                                        cbb.setSelectedIndex(i);
                                    }
                                }
                            }
                            f1.add(but1); 
                            but1.addActionListener(new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed(ActionEvent as)
                                    {
                                        f1.dispose();
                                        schooln = tfn.getText();
                                        if(ll2.isVisible())
                                            ll1.setText(""+schooln+"'S");
                                        else
                                            ll1.setText(""+schooln);

                                        if(ot==0)
                                        {
                                            postn =(String)cbb.getSelectedItem();
                                            ll2.setText(""+postn+" Election " );
                                        }
                                        else
                                        {
                                            postn = tfo.getText();
                                            ll2.setText(""+postn+" Election " );
                                        }
                                    }
                                });

                        }

                        jghf.setVisible(false);
                        sn.setBounds(50,10,100,25);
                        tfn.setBounds(170,10,280,30);
                        sp.setBounds(45,50,150,25);
                        cbb.setBounds(170,50,150,30);
                        jrb.setBounds(170,85,70,25);
                        tfo.setBounds(250,85,200,30);
                        jrb.addActionListener(new ActionListener()
                            {
                                @Override
                                public void actionPerformed(ActionEvent as)
                                {
                                    if(jrb.isSelected())
                                    {
                                        ot=1;
                                        cbb.setEnabled(false);
                                        tfo.setEnabled(true);
                                    }
                                    else
                                    {
                                        ot=0;
                                        cbb.setEnabled(true);
                                        tfo.setEnabled(false);
                                    }
                                }
                            });

                        f1.add(sn);
                        f1.add(tfn);
                        f1.add(sp);
                        f1.add(cbb);
                        f1.add(jrb);
                        f1.add(tfo);
                        f1.add(jghf);
                        f1.setBounds(fxs-250,fys-110,500,220);
                        f1.setLayout(null);
                        f1.setVisible(true);
                        f1.setResizable(false);
                    }
                }
                else
                {
                    errorMessage("Wrong Password");
                    check=0;
                }
            }
        }
        if(o==bst)
        {

            if(tfn.getText().equals("")||tfn.equals(" ")||tfn.equals(null))
            {
                errorMessage("School Name cannot be empty");
            }
            else
            {
                if(ot==1)
                {
                    if(tfo.getText().equals("")||tfo.equals(" ")||tfo.equals(null))
                    {
                        errorMessage("Post Name cannot be empty");
                    }
                    else
                    {
                        checkj=1;
                        f1.dispose();
                        ll1.setText(""+tfn.getText()+" 'S ");
                        schooln = tfn.getText();
                        ll2.setText(""+tfo.getText()+" Election " );
                        ll1.setFont(ff2);
                        ll2.setFont(ff3);
                        ll1.setVisible(true);
                        ll2.setVisible(true);
                        gf = "C:/Program Files/D's Voting System/menu.wav";
                        try
                        {
                            music();
                        }   catch(Exception wesd)
                        {
                        }
                        adding();
                    }
                }
                else
                {
                    checkj=1;
                    f1.dispose();
                    ll1.setText(""+tfn.getText()+" 'S ");
                    postn = (String) cbb.getSelectedItem();
                    ll2.setText(""+postn+" Election " );
                    schooln = tfn.getText();
                    ll1.setFont(ff2);
                    ll2.setFont(ff3);
                    ll1.setVisible(true);
                    ll2.setVisible(true);
                    adding();
                }

            }
        }
        if(o==bsv)
        {
            f.setVisible(true);
            jt[0].setVisible(true);
            jt[1].setVisible(true);
            jt[2].setVisible(true);
            jt[3].setVisible(true);
            jt[4].setVisible(true);
            jt[5].setVisible(true);
            j4.setVisible(false);
            j1.setVisible(true);
            j2.setVisible(true);
            sa.doClick();
            ent.doClick();
            checka=1;
            change();
            if(v1>0||v2>0||v3>0||v4>0||v5>0||v6>0||ni>0)
            {
                gf = "C:/Program Files/D's Voting System/menu.wav";
                try
                {
                    music();
                }
                catch(Exception wesd)
                {
                }
                String btt1[] = {"Yes","NO"};
                int PResult1 = JOptionPane.showOptionDialog(null,"Result of Previous Election are Still Stored \nDo You Want To Reset Votes ?"," Resest ", JOptionPane.DEFAULT_OPTION , JOptionPane.QUESTION_MESSAGE, null,btt1,btt1[1]);
                if(PResult1==0)
                {
                    try
                    {
                        reset();
                    }
                    catch(IOException fd)
                    {
                    }

                }
            }
        }
        if(s.equals("Number Of Candidates "))
        {
            f1.dispose();
            f1 = new JFrame(" No. Of Candidates ");
            n=0;

            cb7.setVisible(false);
            cb1.setBounds(30,30,150,40);
            cb2.setBounds(30,80,150,40);
            cb3.setBounds(30,130,150,40);
            cb4.setBounds(30,180,150,40);
            cb5.setBounds(30,230,150,40);
            cb6.setBounds(30,280,150,40);
            sa.setBounds(100,320,80,40);
            sa.addActionListener(this);
            f1.add(cb1);
            f1.add(cb2);
            f1.add(cb3);
            f1.add(cb4);
            f1.add(cb5);
            f1.add(cb6);
            f1.add(sa);

            sa.addKeyListener(new KeyAdapter()
                {
                    public void keyPressed(KeyEvent key)
                    {
                        if(key.getKeyChar()==KeyEvent.VK_ENTER)
                        {
                            sa.doClick();
                        }
                    }
                });
            f1.add(cb7);
            f1.setVisible(true);
            f1.setBounds(fxs-115,fys-200,230,400);
            f1.setResizable(false);
        }
        if(s.equals("School Name Location "))
        {
            if(ll1.isVisible()==true)
            {
                if(f1.isVisible())
                    f1.dispose();
                changingLocation(ll1,null);
            }
            else
            {
                errorMessage("School Name is NOT Visible");
            }
        }
        if(s.equals("Colors "))
        {
            if(f1.isVisible())
                f1.dispose();
            f1 = new JFrame(" Colors ");
            JLabel scn = new JLabel(" School Name ");
            JLabel d = new JLabel(" Original:- ");
            JLabel c = new JLabel(" Change Color Of :- ");
            JLabel p = new JLabel(" Post Name ");
            JButton can = new JButton(" Candidate ");
            JButton nil = new JButton(" NILL ");
            JButton canb = new JButton(" Background ");
            JButton cant = new JButton(" text ");
            JButton nilb = new JButton(" Background ");
            JButton st = new JButton(" text ");
            JButton pt = new JButton(" text ");
            JButton nilt = new JButton(" text ");
            JLabel df = new JLabel("");
            df.setVisible(false);
            f1 = new JFrame("Color");
            d.setBounds(30,10,100,50);
            c.setBounds(190,10,200,50);
            scn.setBounds(10,60,130,40);
            p.setBounds(10,110,130,40);
            st.setBounds(160,60,130,40);
            pt.setBounds(160,110,130,40);
            can.setBounds(10,160,100,40);
            nil.setBounds(10,210,100,40);
            canb.setBounds(160,160,130,40);
            cant.setBounds(310,160,130,40);
            nilb.setBounds(160,210,130,40);
            nilt.setBounds(310,210,130,40);
            can.setBackground(b1.getBackground());
            can.setForeground(b1.getForeground());
            nil.setBackground(b7.getBackground());
            nil.setForeground(b7.getForeground());
            scn.setForeground(ll1.getForeground());
            p.setForeground(ll2.getForeground());
            f1.setResizable(false);
            f1.add(d);
            f1.add(c);
            f1.add(can);
            f1.add(nil);
            f1.add(canb);
            f1.add(cant);
            f1.add(nilb);
            f1.add(nilt);

            f1.add(scn);
            f1.add(p);
            f1.add(st);
            f1.add(pt);
            canb.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno =1;
                        Color c = b1.getBackground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });
            cant.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno=2;
                        Color c = b1.getForeground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });
            nilb.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno = 3;
                        Color c = b7.getBackground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });
            nilt.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno = 4;
                        Color c = b7.getForeground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });
            st.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno=5;
                        Color c =ll1.getForeground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });
            pt.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent aae)
                    {
                        colorno=6;
                        Color c = ll2.getForeground();
                        red.setValue(c.getRed());
                        green.setValue(c.getGreen());
                        blue.setValue(c.getBlue());
                        Colors();
                    }
                });

            f1.add(df);
            f1.setBounds(xSize/2-238,ySize/2-155,475,310);
            f1.setVisible(true);
        }
        if(s.equals("Picture's Size "))
        {
            changingsize();
        }
        if(s.equals("View "))
        {
            final JCheckBox jcb1 = new JCheckBox(" Date ");
            final JCheckBox jcb2 = new JCheckBox(" Time ");
            final JCheckBox jcb3 = new JCheckBox(" Day ");
            final JCheckBox jcb4 = new JCheckBox(" School Name ");
            final JCheckBox jcb5 = new JCheckBox(" Post Name ");
            JButton  jjb = new JButton(" Change ");
            f1 = new JFrame("View");
            jcb1.setBounds(30,30,150,30);
            jcb2.setBounds(30,80,150,30);
            jcb3.setBounds(30,130,150,30);
            jcb4.setBounds(30,180,150,30);
            jcb5.setBounds(30,230,150,30);
            jjb.setBounds(60,280,100,40);
            if(l.isVisible())
                jcb2.setSelected(true);
            if(l1.isVisible())
                jcb1.setSelected(true);
            if(l2.isVisible())
                jcb3.setSelected(true);
            if(ll1.isVisible())
                jcb4.setSelected(true);
            if(ll2.isVisible())
                jcb5.setSelected(true);
            jjb.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent as)
                    {
                        if(jcb1.isSelected())
                        {
                            l1.setVisible(true);
                        }
                        else
                        {
                            l1.setVisible(false);
                        }
                        if(jcb2.isSelected())
                        {
                            l.setVisible(true);
                        }
                        else
                        {
                            l.setVisible(false);
                        }
                        if(jcb3.isSelected())
                        {
                            l2.setVisible(true);
                        }
                        else
                        {
                            l2.setVisible(false);
                        }
                        if(jcb4.isSelected())
                        {
                            ll1.setVisible(true);
                        }
                        else
                        {
                            ll1.setVisible(false);
                        }
                        if(jcb5.isSelected())
                        {
                            ll2.setVisible(true);
                            ll1.setText(""+schooln+"'S");
                        }
                        else
                        {
                            ll2.setVisible(false);
                            ll1.setText(""+schooln);
                        }
                        f1.dispose();
                    }
                });

            JLabel df = new JLabel("");
            df.setVisible(false);
            f1.add(jcb1);
            f1.add(jcb2);
            f1.add(jcb3);
            f1.add(jcb4);
            f1.add(jcb5);
            f1.add(jjb);
            f1.add(df);
            f1.setBounds(xSize/2-115,ySize/2-190,230,380);
            f1.setVisible(true);
            f1.setResizable(false);
        }
        if(s.equals("Hide Menus "))
        {
            if(f1.isVisible())
                f1.dispose();
            f1 = new JFrame("Show");
            final JButton show = new JButton("Show");
            show.setSize(80,40);
            f1.setLayout(new FlowLayout());
            f1.setVisible(true);
            f1.setLocation(xSize/2-45,ySize/2-25);
            f1.add(show);
            f1.pack();

            f1.setResizable(false);
            jm.setVisible(false);
            show.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent asd)
                    {
                        jm.setVisible(true);
                        f1.dispose();
                    }
                });
            f1.addWindowListener(new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent we )
                    {
                        show.doClick();
                    }
                });
        }
        if(s.equals("Post Name Location "))
        {
            if(ll2.isVisible()==true)
            {
                if(f1.isVisible())
                    f1.dispose();
                changingLocation(ll2,null);
            }
            else
            {
                errorMessage("Post Name not Visible");

            }
        }

        if(s.equals("Sizes and Fonts "))
        {
            if(f1.isVisible()==true)
            {
                f1.dispose();
            }
            try
            {
                Font ff11 = b1.getFont();
                Font ff = ll1.getFont();
                Font ff22 = ll2.getFont();
                f1 = new JFrame(" Sizes and Fonts ");
                String[] fonts,fonts1,fonts2;
                final JComboBox fontComboBox,fontComboBox1,fontComboBox2; 
                final JComboBox sizeComboBox,sizeComboBox1,sizeComboBox2;
                final JCheckBox boldCheck, italCheck,boldCheck1,italCheck1,boldCheck2, italCheck2;
                Integer[] sizes = { 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 54, 58, 62, 66, 70, 74, 78, 82, 84, 86, 90};
                Integer[] sizes1 = { 7, 8, 9, 10, 11, 12, 14, 18, 20, 22, 24, 26, 28, 30, 34, 36, 38, 40, 42};
                Integer[] sizes2 = { 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 54, 58, 62, 66, 70, 74, 78, 82, 84, 86, 90};

                sizeComboBox = new JComboBox(sizes);
                sizeComboBox1 = new JComboBox(sizes1);
                sizeComboBox2 = new JComboBox(sizes2);
                bup = new JButton(" UPDATE ");
                GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
                fonts1 = g.getAvailableFontFamilyNames();
                fonts = g.getAvailableFontFamilyNames();
                fontComboBox = new JComboBox(fonts);
                fontComboBox1 = new JComboBox(fonts1);
                fontComboBox2 = new JComboBox(fonts1);
                JLabel j1 = new JLabel(" School Name Font Size      : ");
                JLabel j = new JLabel(" Post Name Font Size         : ");
                JLabel j2 = new JLabel(" Candidate Name Font Size   : ");
                JLabel jj1 = new JLabel(" School Name Font Style    : ");
                JLabel jj = new JLabel(" Post Name Font Style       : ");
                JLabel jj2 = new JLabel(" Candidate Name Font Style : ");
                final JLabel ssn = new JLabel(" School Name Demo ");
                final JLabel ppn = new JLabel(" Post Name Demo ");
                final JLabel ccn = new JLabel(" Candidate Name Demo ");

                boldCheck = new JCheckBox("Bold");
                italCheck = new JCheckBox("Italics");
                boldCheck1 = new JCheckBox("Bold");
                boldCheck2 = new JCheckBox("Bold");
                italCheck1 = new JCheckBox("Italics");
                italCheck2 = new JCheckBox("Italics");
                int a2 = ff22.getSize();
                int a1 = ff11.getSize();
                int a = ff.getSize();
                for(int i=0;i<sizes.length;i++)
                    if(a == sizes[i])
                    {
                        size1=i;
                        break;
                }
                for(int i=0;i<sizes2.length;i++)
                    if(a2 == sizes2[i])
                    {
                        size3=i;
                        break;
                }
                sizeComboBox.setSelectedIndex(size1);
                sizeComboBox2.setSelectedIndex(size3);
                for(int i=0;i<sizes1.length;i++)
                    if(a1 == sizes1[i])
                    {
                        size2=i;
                        break;
                }
                sizeComboBox1.setSelectedIndex(size2);
                for(int i=0;i<fonts.length;i++)
                    if(ff.getName().equals(fonts[i]))
                    {
                        style1=i;
                        break;
                }
                for(int i=0;i<fonts1.length;i++)
                    if(ff11.getName().equals(fonts1[i]))
                    {
                        style2=i;
                        break;
                }
                for(int i=0;i<fonts.length;i++)
                    if(ff22.getName().equals(fonts1[i]))
                    {
                        style3=i;
                        break;
                }
                fontComboBox.setSelectedIndex(style1);
                fontComboBox1.setSelectedIndex(style2);
                fontComboBox2.setSelectedIndex(style3);
                ssn.setBounds(20,10,480,70);
                ccn.setBounds(40,75,480,100);
                ppn.setBounds(30,35,480,100);
                j1.setBounds(50,145,300,20);

                sizeComboBox.setBounds(230,150,50,30);
                j.setBounds(50,195,300,20);
                j1.setBounds(50,155,300,20);
                sizeComboBox2.setBounds(230,190,50,30);
                j2.setBounds(50,235,300,20);
                sizeComboBox1.setBounds(230,230,50,30);
                jj1.setBounds(50,275,300,20);
                fontComboBox.setBounds(230,270,200,30);
                jj.setBounds(50,315,300,20);
                fontComboBox2.setBounds(230,310,200,30);
                jj2.setBounds(50,355,300,20);
                fontComboBox1.setBounds(230,350,200,30);
                boldCheck.setBounds(300,150,60,30);
                boldCheck2.setBounds(300,190,60,30);
                boldCheck1.setBounds(300,230,60,30);
                italCheck.setBounds(360,150,200,30);
                italCheck2.setBounds(360,190,200,30);
                italCheck1.setBounds(360,230,200,30);
                bup.setBounds(340,390,100,40);
                f1.add(bup);
                f1.add(jj1);
                f1.add(ssn);
                f1.add(ccn);
                f1.add(ppn);
                f1.add(jj);
                f1.add(j);
                f1.add(jj2);
                f1.add(j1);
                f1.add(j2);
                f1.add(sizeComboBox);
                f1.add(sizeComboBox1);
                f1.add(fontComboBox);
                f1.add(fontComboBox1);
                f1.add(sizeComboBox2);
                f1.add(fontComboBox2);
                f1.add(boldCheck);
                f1.add(boldCheck1);
                f1.add(italCheck);
                f1.add(italCheck1);
                f1.add(boldCheck2);
                f1.add(italCheck2);
                if(ff11.getStyle()==Font.BOLD)
                    boldCheck1.setSelected(true);
                else
                    boldCheck1.setSelected(false);
                if(ff11.getStyle()==Font.ITALIC)
                    italCheck1.setSelected(true);
                else
                    italCheck1.setSelected(false);
                if(ff.getStyle()==Font.BOLD)
                    boldCheck.setSelected(true);
                else
                    boldCheck.setSelected(false);
                if(ff.getStyle()==Font.ITALIC)
                    italCheck.setSelected(true);
                else
                    italCheck.setSelected(false);

                ssn.setFont(ff);
                boldCheck.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox.getSelectedItem();
                            Integer size = (Integer) sizeComboBox.getSelectedItem();
                            int style;
                            if (boldCheck.isSelected() && italCheck.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff2 = new Font(name, style, size.intValue());
                            ssn.setFont(ff2);
                        }
                    });
                ppn.setFont(ff22);
                boldCheck2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox2.getSelectedItem();
                            Integer size = (Integer) sizeComboBox2.getSelectedItem();
                            int style;
                            if (boldCheck2.isSelected() && italCheck2.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck2.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck2.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff3 = new Font(name, style, size.intValue());
                            ppn.setFont(ff3);
                        }
                    });

                ccn.setFont(ff11);
                boldCheck1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox1.getSelectedItem();
                            Integer size = (Integer) sizeComboBox1.getSelectedItem();
                            int style;
                            if (boldCheck1.isSelected() && italCheck1.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck1.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck1.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff1 = new Font(name, style, size.intValue());
                            ccn.setFont(ff1);
                        }
                    });
                sizeComboBox.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                sizeComboBox1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                fontComboBox.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                fontComboBox1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                sizeComboBox2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });
                fontComboBox2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });

                italCheck.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                italCheck1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                italCheck2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });
                f1.setBounds(xSize/2-250,ySize/2-235,500,470);
                f1.setLayout(null);
                bup.addActionListener(this);
                f1.setVisible(true);
                f1.setResizable(false);
            }
            catch(Exception asd)
            {

                Font ff11 = b1.getFont();
                Font ff = ll1.getFont();
                Font ff22 = ll2.getFont();
                f1 = new JFrame(" Sizes and Fonts ");
                String[] fonts,fonts1,fonts2;
                final JComboBox fontComboBox,fontComboBox1,fontComboBox2; 
                final JComboBox sizeComboBox,sizeComboBox1,sizeComboBox2;
                final JCheckBox boldCheck, italCheck,boldCheck1,italCheck1,boldCheck2, italCheck2;
                Integer[] sizes = { 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 54, 58, 62, 66, 70, 74, 78, 82, 84, 86, 90};
                Integer[] sizes1 = { 7, 8, 9, 10, 11, 12, 14, 18, 20, 22, 24, 26, 28, 30, 34, 36, 38, 40, 42};
                Integer[] sizes2 = { 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 54, 58, 62, 66, 70, 74, 78, 82, 84, 86, 90};
                fonts = new String[262];
                fonts1 = new String[262];
                try
                {
                    FileReader fr = new FileReader("C:/Program Files/D's Voting System/Font.txt");
                    BufferedReader br = new BufferedReader(fr);
                    Scanner sc = new Scanner(new File("C:/Program Files/D's Voting System/Font.txt"));

                    for(int i=0;sc.hasNext();i++)
                    {
                        fonts[i] = sc.nextLine();
                        fonts1[i] = fonts[i];
                    }
                    br.close();
                    sc.close();
                }
                catch(Exception sdfds)
                {
                }
                sizeComboBox = new JComboBox(sizes);
                sizeComboBox1 = new JComboBox(sizes1);
                sizeComboBox2 = new JComboBox(sizes2);
                bup = new JButton(" UPDATE ");
                JLabel j1 = new JLabel(" School Name Font Size      : ");
                JLabel j = new JLabel(" Post Name Font Size         : ");
                JLabel j2 = new JLabel(" Candidate Name Font Size   : ");
                JLabel jj1 = new JLabel(" School Name Font Style    : ");
                JLabel jj = new JLabel(" Post Name Font Style       : ");
                JLabel jj2 = new JLabel(" Candidate Name Font Style : ");
                final JLabel ssn = new JLabel(" School Name Demo ");
                final JLabel ppn = new JLabel(" Post Name Demo ");
                final JLabel ccn = new JLabel(" Candidate Name Demo ");
                fontComboBox = new JComboBox(fonts);
                fontComboBox1 = new JComboBox(fonts1);
                fontComboBox2 = new JComboBox(fonts1);
                boldCheck = new JCheckBox("Bold");
                italCheck = new JCheckBox("Italics");
                boldCheck1 = new JCheckBox("Bold");
                boldCheck2 = new JCheckBox("Bold");
                italCheck1 = new JCheckBox("Italics");
                italCheck2 = new JCheckBox("Italics");
                int a2 = ff22.getSize();
                int a1 = ff11.getSize();
                int a = ff.getSize();
                for(int i=0;i<sizes.length;i++)
                    if(a == sizes[i])
                    {
                        size1=i;
                        break;
                }
                for(int i=0;i<sizes2.length;i++)
                    if(a2 == sizes2[i])
                    {
                        size3=i;
                        break;
                }
                sizeComboBox.setSelectedIndex(size1);
                sizeComboBox2.setSelectedIndex(size3);
                for(int i=0;i<sizes1.length;i++)
                    if(a1 == sizes1[i])
                    {
                        size2=i;
                        break;
                }
                sizeComboBox1.setSelectedIndex(size2);
                for(int i=0;i<fonts.length;i++)
                    if(ff.getName().equals(fonts[i]))
                    {
                        style1=i;
                        break;
                }
                for(int i=0;i<fonts1.length;i++)
                    if(ff11.getName().equals(fonts1[i]))
                    {
                        style2=i;
                        break;
                }
                for(int i=0;i<fonts.length;i++)
                    if(ff22.getName().equals(fonts1[i]))
                    {
                        style3=i;
                        break;
                }
                fontComboBox.setSelectedIndex(style1);
                fontComboBox1.setSelectedIndex(style2);
                fontComboBox2.setSelectedIndex(style3);
                ssn.setBounds(20,10,480,70);
                ccn.setBounds(40,75,480,100);
                ppn.setBounds(30,35,480,100);
                j1.setBounds(50,145,300,20);

                sizeComboBox.setBounds(230,150,50,30);
                j.setBounds(50,195,300,20);
                j1.setBounds(50,155,300,20);
                sizeComboBox2.setBounds(230,190,50,30);
                j2.setBounds(50,235,300,20);
                sizeComboBox1.setBounds(230,230,50,30);
                jj1.setBounds(50,275,300,20);
                fontComboBox.setBounds(230,270,200,30);
                jj.setBounds(50,315,300,20);
                fontComboBox2.setBounds(230,310,200,30);
                jj2.setBounds(50,355,300,20);
                fontComboBox1.setBounds(230,350,200,30);
                boldCheck.setBounds(300,150,60,30);
                boldCheck2.setBounds(300,190,60,30);
                boldCheck1.setBounds(300,230,60,30);
                italCheck.setBounds(360,150,200,30);
                italCheck2.setBounds(360,190,200,30);
                italCheck1.setBounds(360,230,200,30);
                bup.setBounds(340,390,100,40);
                f1.add(bup);
                f1.add(jj1);
                f1.add(ssn);
                f1.add(ccn);
                f1.add(ppn);
                f1.add(jj);
                f1.add(j);
                f1.add(jj2);
                f1.add(j1);
                f1.add(j2);
                f1.add(sizeComboBox);
                f1.add(sizeComboBox1);
                f1.add(fontComboBox);
                f1.add(fontComboBox1);
                f1.add(sizeComboBox2);
                f1.add(fontComboBox2);
                f1.add(boldCheck);
                f1.add(boldCheck1);
                f1.add(italCheck);
                f1.add(italCheck1);
                f1.add(boldCheck2);
                f1.add(italCheck2);
                if(ff11.getStyle()==Font.BOLD)
                    boldCheck1.setSelected(true);
                else
                    boldCheck1.setSelected(false);
                if(ff11.getStyle()==Font.ITALIC)
                    italCheck1.setSelected(true);
                else
                    italCheck1.setSelected(false);
                if(ff.getStyle()==Font.BOLD)
                    boldCheck.setSelected(true);
                else
                    boldCheck.setSelected(false);
                if(ff.getStyle()==Font.ITALIC)
                    italCheck.setSelected(true);
                else
                    italCheck.setSelected(false);

                ssn.setFont(ff);
                boldCheck.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox.getSelectedItem();
                            Integer size = (Integer) sizeComboBox.getSelectedItem();
                            int style;
                            if (boldCheck.isSelected() && italCheck.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff2 = new Font(name, style, size.intValue());
                            ssn.setFont(ff2);
                        }
                    });
                ppn.setFont(ff22);
                boldCheck2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox2.getSelectedItem();
                            Integer size = (Integer) sizeComboBox2.getSelectedItem();
                            int style;
                            if (boldCheck2.isSelected() && italCheck2.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck2.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck2.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff3 = new Font(name, style, size.intValue());
                            ppn.setFont(ff3);
                        }
                    });

                ccn.setFont(ff11);
                boldCheck1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)

                        {
                            String name = (String) fontComboBox1.getSelectedItem();
                            Integer size = (Integer) sizeComboBox1.getSelectedItem();
                            int style;
                            if (boldCheck1.isSelected() && italCheck1.isSelected())
                                style = Font.BOLD | Font.ITALIC; 
                            else if (boldCheck1.isSelected())
                                style = Font.BOLD; 
                            else if (italCheck1.isSelected())
                                style = Font.ITALIC;
                            else 
                                style = Font.PLAIN;
                            ff1 = new Font(name, style, size.intValue());
                            ccn.setFont(ff1);
                        }
                    });
                sizeComboBox.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                sizeComboBox1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                fontComboBox.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                fontComboBox1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                sizeComboBox2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });
                fontComboBox2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });

                italCheck.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {

                            if(boldCheck.isSelected())
                                boldCheck.setSelected(false);
                            else
                                boldCheck.setSelected(true);
                            boldCheck.doClick();
                        }
                    });
                italCheck1.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck1.isSelected())
                                boldCheck1.setSelected(false);
                            else
                                boldCheck1.setSelected(true);
                            boldCheck1.doClick();
                        }
                    });
                italCheck2.addActionListener(new ActionListener()
                    {
                        public void actionPerformed(ActionEvent as)
                        {
                            if(boldCheck2.isSelected())
                                boldCheck2.setSelected(false);
                            else
                                boldCheck2.setSelected(true);
                            boldCheck2.doClick();
                        }
                    });
                f1.setBounds(xSize/2-250,ySize/2-235,500,470);
                f1.setLayout(null);
                bup.addActionListener(this);
                f1.setVisible(true);
                f1.setResizable(false);
            }
        }
        if(o==bup)
        {
            b1.setFont(ff1);
            b2.setFont(ff1);
            b3.setFont(ff1);
            b4.setFont(ff1);
            b5.setFont(ff1);
            b6.setFont(ff1);
            ll1.setFont(ff2);
            ll2.setFont(ff3);
        }
        if(o==sa)
        {
            f1.dispose();
            n=0;

            if(cb1.isSelected())
            {
                b1.setVisible(true);
                label1.setVisible(true);
                n++;
            }
            else
            {
                b1.setVisible(false);
                label1.setVisible(false);
            }
            if(cb2.isSelected())
            {
                b2.setVisible(true);
                label2.setVisible(true);
                n++;
            }
            else
            {
                b2.setVisible(false);
                label2.setVisible(false);
            }
            if(cb3.isSelected())
            {
                b3.setVisible(true);
                label3.setVisible(true);
                n++;
            }
            else
            {
                b3.setVisible(false);
                label3.setVisible(false);
            }
            if(cb4.isSelected())
            {
                b4.setVisible(true);
                label4.setVisible(true);
                n++;
            }
            else
            {
                b4.setVisible(false);
                label4.setVisible(false);
            }
            if(cb5.isSelected())
            {
                b5.setVisible(true);
                label5.setVisible(true);
                n++;
            }
            else
            {
                b5.setVisible(false);
                label5.setVisible(false);
            }
            if(cb6.isSelected())
            {
                b6.setVisible(true);
                label6.setVisible(true);
                n++;
            }
            else
            {
                b6.setVisible(false);
                label6.setVisible(false);
            }
            if(n>0)
                b7.setVisible(true);
            else
                b7.setVisible(false);
        }
        if(s.equals("Name Of School And Post "))
        {
            check=10;
            lock();
        }
        if(s.equals("Name Of Candidates "))
        {
            if(f1.isVisible())
                f1.dispose();
            if(!b1.isVisible()&&!b2.isVisible()&&!b3.isVisible()&&!b4.isVisible()&&!b5.isVisible()&&!b6.isVisible())
            {
                errorMessage("Select Some Candidates To Change Name ");
            }
            else
            {
                f1 = new JFrame(" Name ");
                JLabel ln[] = new JLabel[6];

                int j=30;
                ln[0] = new JLabel(" Edit Name Of Candidate 1 :" );
                ln[1] = new JLabel(" Edit Name Of Candidate 2 :");
                ln[2] = new JLabel(" Edit Name Of Candidate 3 :");
                ln[3] = new JLabel(" Edit Name Of Candidate 4 :");
                ln[4] = new JLabel(" Edit Name Of Candidate 5 :");
                ln[5] = new JLabel(" Edit Name Of Candidate 6 :");

                jt[0] = new JTextField(b1.getText());
                jt[1] = new JTextField(b2.getText());
                jt[2] = new JTextField(b3.getText());
                jt[3] = new JTextField(b4.getText());
                jt[4] = new JTextField(b5.getText());
                jt[5] = new JTextField(b6.getText());

                jt[0].setVisible(true);
                jt[1].setVisible(true);
                jt[2].setVisible(true);
                jt[3].setVisible(true);
                jt[4].setVisible(true);
                jt[5].setVisible(true);
                if(b1.isVisible())
                {
                    ln[0].setBounds(30,j-25,400,100);
                    jt[0].setBounds(200,j+10,200,30);
                    f1.add(ln[0]);
                    f1.add(jt[0]);
                    j=j+50;
                }   
                if(b2.isVisible())
                {
                    ln[1].setBounds(30,j-25,400,100);
                    jt[1].setBounds(200,j+10,200,30);
                    f1.add(ln[1]);
                    f1.add(jt[1]);
                    j=j+50;
                }
                if(b3.isVisible())
                {
                    ln[2].setBounds(30,j-25,400,100);
                    jt[2].setBounds(200,j+10,200,30);
                    f1.add(ln[2]);
                    f1.add(jt[2]);
                    j=j+50;
                }
                if(b4.isVisible())
                {
                    ln[3].setBounds(30,j-25,400,100);
                    jt[3].setBounds(200,j+10,200,30);
                    f1.add(ln[3]);
                    f1.add(jt[3]);
                    j=j+50;
                }
                if(b5.isVisible())
                {
                    ln[4].setBounds(30,j-25,400,100);
                    jt[4].setBounds(200,j+10,200,30);
                    f1.add(ln[4]);
                    f1.add(jt[4]);
                    j=j+50;
                }
                if(b6.isVisible())
                {
                    ln[5].setBounds(30,j-25,400,100);
                    jt[5].setBounds(200,j+10,200,30);
                    f1.add(ln[5]);
                    f1.add(jt[5]);
                    j=j+50;
                }

                ent = new JButton("ENTER");
                ent.setBounds(350,j,100,40);
                ent.addActionListener(this);
                f1.add(ent);

                j=j+100;
                for(int abc=0;abc<6;abc++)
                {
                    jt[abc].addKeyListener(new KeyAdapter()
                        {
                            public void keyPressed(KeyEvent key)
                            {
                                if(key.getKeyChar()==KeyEvent.VK_ENTER)
                                {
                                    ent.doClick();
                                }
                            }
                        });
                }
                JLabel ni = new JLabel();
                f1.add(ni);
                ni.setVisible(false);
                f1.setVisible(true);

                f1.setBounds(fxs-240,fys-j/2,480,j);
                f1.setLayout(null);
                f1.setResizable(false);
            }
        }
        if(o==ent)
        {
            f1.dispose();

            b1.setText(jt[0].getText());
            b2.setText(jt[1].getText());
            b3.setText(jt[2].getText());
            b4.setText(jt[3].getText());
            b5.setText(jt[4].getText());
            b6.setText(jt[5].getText());
            String ss,s1;
            if(checka==1)
            {
                ss = " Name Changed ";
                s1 = "Changing Name "; 
            }
            else
            {
                s1 = "Adding Candidates";
                ss = " Candidates Added ";
            }
            infoMessage(ss,s1);
        }
        if(s.equals("Reset Password"))
        {
            check=3;
            lock();

        }
        if(s.equals("Result "))

        {
            if(!b1.isVisible()&&!b2.isVisible()&&!b3.isVisible()&&!b4.isVisible()&&!b5.isVisible()&&!b6.isVisible())
            {
                errorMessage("Select Some Candidates To View Their Result ");
            }
            else
            {
                try
                {
                    f1.dispose();
                    result();
                }
                catch(IOException sdf)
                {
                    errorMessage(" You Have Not Voted To Anyone");
                }
            }
        }
        if(s.equals("Reset Votes"))
        {
            check = 4;
            lock();

        }
        if(s.equals("Picture Of Candidates "))
        {
            if(f1.isVisible())
                f1.dispose();
            f1 = new JFrame(" Pictures of Candidate");
            jb1 = new JButton(" Candidate 1 ");
            jb2  = new JButton(" Candidate 2 ");
            jb3 = new JButton(" Candidate 3 ");
            jb4  = new JButton(" Candidate 4 ");
            jb5 = new JButton(" Candidate 5");
            jb6  = new JButton(" Candidate 6 ");
            JButton no =  new JButton(" ");
            jbb = new JButton(" BackGround ");
            int j = 30;
            jbb.setBounds(30,j+10,150,40);
            f1.add(jbb);
            j=j+50;

            if(b1.isVisible())
            {
                jb1.setBounds(30,j+10,150,40);
                f1.add(jb1);
                j=j+50;
            }   
            if(b2.isVisible())
            {
                jb2.setBounds(30,j+10,150,40);
                f1.add(jb2);
                j=j+50;
            }
            if(b3.isVisible())
            {
                jb3.setBounds(30,j+10,150,40);
                f1.add(jb3);
                j=j+50;
            }
            if(b4.isVisible())
            {
                jb4.setBounds(30,j+10,150,40);
                f1.add(jb4);
                j=j+50;
            }
            if(b5.isVisible())
            {
                jb5.setBounds(30,j+10,150,40);
                f1.add(jb5);
                j=j+50;
            }
            if(b6.isVisible())
            {
                jb6.setBounds(30,j+10,150,40);
                f1.add(jb6);
                j=j+50;
            }
            j=j+50;
            no.setVisible(false);
            f1.add(no);
            jb1.addActionListener(this);
            jb2.addActionListener(this);
            jb3.addActionListener(this);
            jb4.addActionListener(this);
            jb5.addActionListener(this);
            jb6.addActionListener(this);
            jbb.addActionListener(this);
            f1.setLayout(null);
            f1.setVisible(true);
            f1.setLocation(fxs-115,fys-j/2);
            f1.setSize(230,j);
            f1.setResizable(false);
        }
        if(s.equals("Lock Menus "))
        {
            checkc =0;
            checkt = 0;
            infoMessage(" Menus are Locked ", " Locking Menu ");
        }
        if(s.equals("Add Result to Database "))
        {
            try
            {
                FInput();
            }
            catch(IOException sdf)
            {

            }
        }
        if(s.equals("Picture's Location "))
        {
            if(f1.isVisible())
                f1.dispose();
            f1 = new JFrame(" Picture's Location ");
            JButton jjbb1 = new JButton(" Candidate 1 ");
            JButton jjbb2  = new JButton(" Candidate 2 ");
            JButton jjbb3 = new JButton(" Candidate 3 ");
            JButton jjbb4  = new JButton(" Candidate 4 ");
            JButton jjbb5 = new JButton(" Candidate 5");
            JButton jjbb6  = new JButton(" Candidate 6 ");
            JButton no =  new JButton(" ");
            int j = 30;
            if(b1.isVisible())
            {
                jjbb1.setBounds(30,j+10,150,40);
                f1.add(jjbb1);
                j=j+50;
            }   
            if(b2.isVisible())
            {
                jjbb2.setBounds(30,j+10,150,40);
                f1.add(jjbb2);
                j=j+50;
            }
            if(b3.isVisible())
            {
                jjbb3.setBounds(30,j+10,150,40);
                f1.add(jjbb3);
                j=j+50;
            }
            if(b4.isVisible())
            {
                jjbb4.setBounds(30,j+10,150,40);
                f1.add(jjbb4);
                j=j+50;
            }
            if(b5.isVisible())
            {
                jjbb5.setBounds(30,j+10,150,40);
                f1.add(jjbb5);
                j=j+50;
            }
            if(b6.isVisible())
            {
                jjbb6.setBounds(30,j+10,150,40);
                f1.add(jjbb6);
                j=j+50;
            }
            j=j+50;
            no.setVisible(false);
            f1.add(no);
            jjbb1.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label1,b1);   
                    }
                });
            jjbb2.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label2,b2);   
                    }
                });
            jjbb3.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label3,b3);   
                    }
                });
            jjbb4.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label4,b4);   
                    }
                });
            jjbb5.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label5,b5);   
                    }
                });
            jjbb6.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent as)
                    {
                        changingLocation(label6,b6);   
                    }
                });
            f1.setLayout(null);
            f1.setVisible(true);
            f1.setLocation(fxs-115,fys-j/2);
            f1.setSize(230,j);
            f1.setResizable(false);
        }
        if(s.equals("Display Database "))
        {
            try
            {
                FOutput();
            }
            catch(IOException sdf)
            {
                errorMessage("Database is Empty");
            }

        }
        if(s.equals("Clear Database "))
        {
            check = 5;
            lock();
        }
        if(s.equals("Forgotten Password "))
        {
            check = 6;
            lock();
        }
        if(s.equals("Instructions "))
        {
            try
            {
                Instruction();
            }
            catch(IOException sd)
            {
            }
        }

        if(s.equals("About "))
        {
            try
            {
                About();
            }
            catch(IOException sd)
            {
            }
        }
        if(o==jb1||o==jb2||o==jb3||o==jb4||o==jb5||o==jb6||o==jbb)
        {
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle(" Choose Image ");
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int rv = fc.showOpenDialog(this);
            if(rv==JFileChooser.APPROVE_OPTION)
            {
                File file =  fc.getSelectedFile();
                BufferedImage b1=null;
                Image ima=null;
                try
                {

                    b1 = ImageIO.read(file);
                    ima = b1.getScaledInstance(wid,Hei,Image.SCALE_SMOOTH);

                }catch(IOException eam)
                {

                }
                try
                {
                    if(o==jb1)
                    {si1=file.toString();
                        label1.setIcon(new ImageIcon(ima));
                        label11.setIcon(new ImageIcon(ima));}
                    if(o==jb2)
                    {si2=file.toString();
                        label2.setIcon(new ImageIcon(ima));
                        label12.setIcon(new ImageIcon(ima));}
                    if(o==jb3)
                    {
                        si3=file.toString();
                        label3.setIcon(new ImageIcon(ima));
                        label13.setIcon(new ImageIcon(ima));}
                    if(o==jb4)
                    {
                        si4=file.toString();
                        label4.setIcon(new ImageIcon(ima));
                        label14.setIcon(new ImageIcon(ima));}
                    if(o==jb5)
                    {
                        si5=file.toString();
                        label5.setIcon(new ImageIcon(ima));
                        label15.setIcon(new ImageIcon(ima));}
                    if(o==jb6)
                    {
                        si6=file.toString();
                        label6.setIcon(new ImageIcon(ima));
                        label16.setIcon(new ImageIcon(ima));}
                    if(o==jbb)

                    {
                        sib=file.toString();
                        ima = b1.getScaledInstance(xSize,ySize,Image.SCALE_SMOOTH);
                        labelb.setIcon(new ImageIcon(ima));
                        label1b.setIcon(new ImageIcon(ima));
                    }
                }
                catch(Exception asdf)
                {
                    errorMessage(" Image File Not Supported ");
                }
            }

        }
        if(o==cha)
        {
            char ch[] = pf.getPassword();
            int len = ch.length;
            if(len<=10)
            {
                for(int a=0;a<len;a++)
                    chh[a] =ch[a];
                for(int a=len;a<10;a++)
                    chh[a] =' ';
                try
                {
                    passInput();
                }
                catch(IOException rdf)
                {
                }
                f1.dispose();;
                infoMessage(" Password Changed ", " Changing password ");

            }
            else
            {
                f1.dispose();
                errorMessage(" Password is of more than 10 Characters ");
            }
        }
        if(o==b1)
        {
            v1++;
        }
        if(o==b2)
        {
            v2++;
        }
        if(o==b3)
        {
            v3++;
        }
        if(o==b4)
        {
            v4++;
        }
        if(o==b5)
        {
            v5++;
        }
        if(o==b6)
        {
            v6++;
        }
        if(o==b7)
        {
            ni++;
        }
        if(o==b1||o==b2||o==b3||o==b4||o==b5||o==b6||o==b7)
        {

            JOptionPane pane = new JOptionPane(" \tThank You For Voting\n Your Vote Has been Registered", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
            final JDialog dialog = pane.createDialog(" Vote ");
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                    {public void actionPerformed(ActionEvent ae)
                        {
                            gf = "C:/Program Files/D's Voting System/beep1.wav";
                            try
                            {
                                music();
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);
                            }

                            catch(Exception wesd)
                            {
                            }
                            dialog.setVisible(false);
                            disenable(true);
                            colour(canback,nilback);

                        }
                    });
            BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
            dialog.getContentPane().setCursor(blankCursor);
            try
            {
                bot = new Robot();
                bot.mouseMove(xSize/2+10,ySize/2+20);

            }catch(Exception asfd)
            {
            }

            gf = "C:/Program Files/D's Voting System/beep.wav";
            try
            {

                music();
            }
            catch(Exception wesd)
            {
            }

            try
            {
                Input();
            }
            catch(IOException eg)
            {
            }

            disenable(false);
            colour(Color.RED,Color.RED);
            dialog.addMouseListener(new MouseListener()
                {
                    @Override
                    public void mouseClicked(MouseEvent me)
                    {
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent me){
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }}

                    @Override
                    public void mousePressed(MouseEvent me){
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }}

                    @Override
                    public void mouseEntered(MouseEvent me){
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }}

                    @Override
                    public void mouseReleased(MouseEvent me){
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }}
                });
            dialog.addMouseMotionListener(new MouseMotionListener()
                {
                    public void mouseMoved(MouseEvent me)
                    {
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2+20)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }
                    }

                    public void mouseDragged(MouseEvent me)
                    {
                        if(me.getX()!= xSize/2+10||me.getY()!= ySize/2)
                        {
                            try
                            {
                                bot = new Robot();
                                bot.mouseMove(xSize/2,ySize/2);

                            }catch(Exception asfd)
                            {
                            }
                        }
                    }
                });

            timer.setRepeats(false);
            timer.start();

            dialog.setVisible(true);
        }  
    }

    public void stateChanged(ChangeEvent evt)
    {
        JSlider source = (JSlider)evt.getSource();
        if(source.getValueIsAdjusting() != true)
        {
            Color current = new Color(red.getValue(),green.getValue(),blue.getValue());
            canvas.setBackground(current);
        }
    }

    public void resetP()
    {
        if(f1.isVisible())
            f1.dispose();
        f1 = new JFrame("Change Password");
        JLabel lab = new JLabel(" Enter New Password ");
        pf = new JPasswordField(20);
        cha = new JButton("CHANGE");
        cha.addActionListener(this);
        f1.add(lab);
        f1.add(pf);
        f1.add(cha);
        f1.setLayout(new FlowLayout());
        f1.setLocation(fxs-250,fys-50);
        gf = "C:/Program Files/D's Voting System/menu.wav";
        try
        {
            music();
        }
        catch(Exception wesd)
        {
        }
        pf.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent key)
                {
                    if(key.getKeyChar()==KeyEvent.VK_ENTER)
                    {
                        cha.doClick();
                    }   
                }
            });

        f1.setVisible(true);
        f1.setResizable(false);
        f1.pack();
    }

    public void FInput() throws IOException
    {
        File check = new File("C:/D's Voting System Data");
        File folder = new File("C:/D's Voting System Backup");
        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/FResult.txt");
            if(!check.exists())
            {
                prev();
            }
        }

        if(folder.exists())
        {
            show(folder);
            File decrypting = new File("C:/D's Voting System Backup/EncData.encrypted");
            if(decrypting.exists())
                decrypt(decrypting);
        }

        FileWriter fw = new FileWriter("C:/D's Voting System Data/FResult.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        FileReader fr = new FileReader("C:/D's Voting System Data/Result.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(new File("C:/D's Voting System Data/Result.txt"));
        Calendar calendar=Calendar.getInstance();
        pw.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        pw.println("Date: "+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR));
        pw.println("Time: "+calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE));
        pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(b1.isVisible()||b2.isVisible()||b3.isVisible()||b4.isVisible()||b5.isVisible()||b6.isVisible()||b7.isVisible())
            pw.println("              Total No. Of Votes        : "+sc.nextInt());
        if(b1.isVisible());
        pw.println("              Vote For "+b1.getText()+" : "+sc.nextInt());
        if(b2.isVisible());
        pw.println("              Vote For "+b2.getText()+" : "+sc.nextInt());
        if(b3.isVisible());
        pw.println("              Vote For "+b3.getText()+" : "+sc.nextInt());
        if(b4.isVisible());
        pw.println("              Vote For "+b4.getText()+" : "+sc.nextInt());
        if(b5.isVisible());
        pw.println("              Vote For "+b5.getText()+" : "+sc.nextInt());
        if(b6.isVisible());
        pw.println("              Vote For "+b6.getText()+" : "+sc.nextInt());
        if(b7.isVisible());
        pw.println("              Vote For "+b7.getText()+" : "+sc.nextInt());
        pw.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        pw.println();
        pw.close();
        bw.close();
        sc.close();
        fw.close();
        br.close();
        File encrypting = new File("C:/D's Voting System Data/FResult.txt");
        encrypt(encrypting);
        hide(folder);
        infoMessage(" Result added To Database ", " Storing Result ");

    }

    public void FClear()throws IOException
    {
        File check = new File("C:/D's Voting System Data");
        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/FResult.txt");
            if(!check.exists())
            {
                prev();
            }
        }

        PrintWriter pw = new PrintWriter("C:/D's Voting System Data/FResult.txt");
        pw.close();
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
        {
            show(folder);
            File encrypting = new File("C:/D's Voting System Data/FResult.txt");
            if(encrypting.exists())
                encrypt(encrypting);
            hide(folder);
        }
        gf = "C:/Program Files/D's Voting System/recycle.wav";
        try
        {
            music();
        }
        catch(Exception wesd)
        {
        }
        JOptionPane pane = new JOptionPane(" Database Cleared ", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        final JDialog dialog = pane.createDialog(" Cleaning Database  ");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                {public void actionPerformed(ActionEvent ae)
                    {
                        dialog.setVisible(false);
                    }
                });
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);

    }

    public void music()throws Exception
    {

        in = new FileInputStream(gf);
        as = new AudioStream(in);
        AudioPlayer.player.start(as);

    }

    public void FOutput() throws IOException
    {
        File check = new File("C:/D's Voting System Data");
        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/FResult.txt");
            if(!check.exists())
            {
                prev();
            }
        }

        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
        {
            show(folder);
            File decrypting = new File("C:/D's Voting System Backup/EncData.encrypted");
            if(decrypting.exists())
                decrypt(decrypting);
            hide(folder);
        }
        if(f1.isVisible())
            f1.dispose();
        FileReader fr = new FileReader("C:/D's Voting System Data/FResult.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(new File("C:/D's Voting System Data/FResult.txt"));
        f1 = new JFrame("File");
        JLabel jb = new JLabel(new ImageIcon("C:/Program Files/D's Voting System/data.png"));

        f1.setBounds(fxs-225,fys-250,450,500);
        JPanel panel = new JPanel();
        JScrollPane scrollbar = new JScrollPane(panel);
        int j=30;
        Font type = new Font("Script mj bold", Font.BOLD|Font.ITALIC, 13);
        panel.setLayout(null);
        f1.setResizable(false);

        JLabel jla;
        jb.setBounds(2,0,450,50);
        panel.add(jb);
        while(sc.hasNext())
        {
            jla = new JLabel(""+sc.nextLine());
            jla.setFont(type);
            jla.setBounds(30,j,500,100);
            j=j+30;
            panel.add(jla);
        }
        br.close();
        sc.close();

        panel.setPreferredSize(new Dimension(400,j+50));

        f1.getContentPane().add(scrollbar);
        if(j==30)
        {
            errorMessage(" Database is Empty ");
        }
        else
        {
            try
            {
                f1.dispose();
                javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                        {public void actionPerformed(ActionEvent ae)
                            {
                                fload.dispose();
                                gf ="C:/Program Files/D's Voting System/tama.wav"; 
                                try
                                {

                                    music();
                                }
                                catch(Exception sdf)
                                {
                                }

                                f1.setVisible(true);
                                f.setEnabled(true);
                                f.requestFocus();
                                f1.requestFocus();
                            }
                        });
                f.setEnabled(false);
                timer.setRepeats(false);
                timer.start();
                open=2;
                loadingRF();
            }
            catch(Exception sdf)
            {
            }

        }
    }

    public void Instruction()throws IOException
    {
        if(f1.isVisible())
            f1.dispose();
        FileReader fr = new FileReader("C:/Program Files/D's Voting System/Instruction.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(new File("C:/Program Files/D's Voting System/Instruction.txt"));
        f1 = new JFrame("Instructions");

        JLabel jb = new JLabel(new ImageIcon("C:/Program Files/D's Voting System/RABackground.png"));
        f1.setBounds(fxs-225,fys-250,450,500);
        JPanel panel = new JPanel();
        JScrollPane scrollbar = new JScrollPane(panel);
        int j=30;
        JLabel jla;
        Font type = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 13);

        jb.setBounds(00,00,f1.getWidth(),f1.getHeight());
        panel.setLayout(null);
        f1.setResizable(false);
        while(sc.hasNext())
        {
            jla = new JLabel(""+sc.nextLine());
            jla.setFont(type);
            jla.setForeground(new Color(0,0,0));
            jla.setBounds(30,j,1000,100);
            j=j+30;
            panel.add(jla);
        }
        br.close();
        sc.close();
        panel.add(jb);
        panel.setPreferredSize(new Dimension(400,j+50));
        f1.getContentPane().add(scrollbar);

        f1.setVisible(true);
    }

    public void About()throws IOException
    {
        if(f1.isVisible())
            f1.dispose();
        FileReader fr = new FileReader("C:/Program Files/D's Voting System/About.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(new File("C:/Program Files/D's Voting System/About.txt"));
        f1 = new JFrame("About");
        f1.setBounds(fxs-225,fys-250,480,500);
        JLabel jb = new JLabel(new ImageIcon("C:/Program Files/D's Voting System/RABackground.png"));
        JLabel jba = new JLabel();
        try
        {
            BufferedImage imga = null;
            imga = ImageIO.read(new File("C:/Program Files/D's Voting System/Admin.jpg"));
            Image dimga = imga.getScaledInstance(120,140,Image.SCALE_SMOOTH);
            jba.setIcon(new ImageIcon(dimga));
        }
        catch(Exception asdsa)
        {
        }
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        jb.setBounds(00,00,f1.getWidth(),f1.getHeight());
        JScrollPane scrollbar = new JScrollPane(panel);
        int j=30;
        JLabel jla;
        Font type = new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 13);
        panel.setLayout(null);
        f1.setResizable(false);
        jba.setBounds(330,30,120,140);
        while(sc.hasNext())
        {
            jla = new JLabel(""+sc.nextLine());
            jla.setFont(type);
            jla.setForeground(new Color(0,0,0));
            jla.setBounds(10,j,1000,100);
            j=j+30;
            f1.add(jla);
        }
        br.close();
        sc.close();
        panel.add(jba);
        panel.add(jb);
        panel.setPreferredSize(new Dimension(400,j+50));
        f1.getContentPane().add(scrollbar);
        f1.setVisible(true);
    }

    public void Input() throws IOException
    {
        File check = new File("C:/D's Voting System Data");
        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/Result.txt");
            if(!check.exists())
            {
                prev();
            }
        }
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
        {
            show(folder);
            File decrypting = new File("C:/D's Voting System Backup/EncR.encrypted");
            if(decrypting.exists())
                decrypt(decrypting);
        }

        FileWriter fw = new FileWriter("C:/D's Voting System Data/Result.txt",false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        int a = v1+v2+v3+v4+v5+v6+ni;
        pw.println(a);
        pw.println(v1);
        pw.println(v2);
        pw.println(v3);
        pw.println(v4);
        pw.println(v5);
        pw.println(v6);
        pw.println(ni);
        pw.close();
        bw.close();
        fw.close();
        File encrypting = new File("C:/D's Voting System Data/Result.txt");
        encrypt(encrypting);
        hide(folder);
    }

    public void reset() throws IOException
    {
        File check = new File("C:/D's Voting System data");

        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/Result.txt");
            if(!check.exists())
            {
                prev();
            }
        }
        FileWriter fw = new FileWriter("C:/D's Voting System Data/Result.txt",false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        v1=0;
        v2=0;
        v3=0;
        v4=0;
        v5=0;
        v6=0;
        n=0;
        ni=0;
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
        {
            show(folder);
            File encrypting = new File("C:/D's Voting System Data/Result.txt");
            if(encrypting.exists())
                encrypt(encrypting);
            hide(folder);
        }
        pw.close();
        bw.close();
        fw.close();

        gf = "C:/Program Files/D's Voting System/recycle.wav";
        try
        {
            music();
        }
        catch(Exception wesd)
        {
        }
        JOptionPane pane = new JOptionPane(" Votes are Reset ", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        final JDialog dialog = pane.createDialog(" Reseting Votes ");
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                {public void actionPerformed(ActionEvent ae)
                    {
                        dialog.setVisible(false);
                    }
                });

        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
    }

    static void fileProcessor(int cipherMode,String key,File inputFile,File outputFile){
        try {
            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (Exception e) {

        }
    }

    void encrypt(File inputFile) {

        String key = "This is a secret";
        File encryptedFile=null;
        if(inputFile.getName().equals("Result.txt"))
            encryptedFile = new File("C:/D's Voting System Backup/EncR.encrypted");
        if(inputFile.getName().equals("FResult.txt"))
            encryptedFile = new File("C:/D's Voting System Backup/EncData.encrypted");
        try 
        {
            fileProcessor(Cipher.ENCRYPT_MODE,key,inputFile,encryptedFile);
        } catch (Exception ex) {

        }

    }

    void hide(File src)
    {
        try
        {
            if(src.exists())
            {
                Process p = Runtime.getRuntime().exec("attrib +a +s +h \""+src.getAbsolutePath().toString()+"\"");
                p.waitFor();
            }
        }
        catch(Exception asd)
        {

        }
    }

    void show(File src)
    {
        try
        {
            if(src.exists())
            {
                Process p = Runtime.getRuntime().exec("attrib -a -s -h \""+src.getAbsolutePath().toString()+"\"");
                p.waitFor();
            }
        }
        catch(Exception asd)
        {

        }
    }

    void decrypt(File encryptedFile)
    {
        String key = "This is a secret";
        File decryptedFile = null;
        if(encryptedFile.getName().equals("EncR.encrypted"))
            decryptedFile = new File("C:/D's Voting System Data/Result.txt");
        if(encryptedFile.getName().equals("EncData.encrypted"))
            decryptedFile = new File("C:/D's Voting System Data/FResult.txt");

        try {
            fileProcessor(Cipher.DECRYPT_MODE,key,encryptedFile,decryptedFile);

        } catch (Exception ex) {

        }

    }

    public void result()throws IOException
    {
        if(f1.isVisible())
            f1.dispose();
        File check = new File("C:/D's Voting System Data");
        if(!check.exists())
        {
            prev();
        }
        else
        {
            File check1 = new File("C:/D's Voting System Data/Result.txt");
            if(!check.exists())
            {
                prev();
            }
        }
        File folder = new File("C:/D's Voting System Backup");
        if(folder.exists())
        {
            show(folder);
            File decrypting = new File("C:/D's Voting System Backup/EncR.encrypted");
            if(decrypting.exists())
                decrypt(decrypting);
            hide(folder);
        }
        FileReader fr = new FileReader("C:/D's Voting System Data/Result.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(new File("C:/D's Voting System Data/Result.txt"));
        f1 = new JFrame("Result ");

        JPanel panel = new JPanel();
        JLabel jb = new JLabel(new ImageIcon("C:/Program Files/D's Voting System/resultB.png"));
       
        int aa,v11,v22,v33,v44,v55,v66,vni;
        try
        {
            aa=sc.nextInt();
            v11=sc.nextInt();
            v22=sc.nextInt();
            v33=sc.nextInt();
            v44=sc.nextInt();
            v55=sc.nextInt();
            v66=sc.nextInt();
            vni=sc.nextInt();
        }
        catch(Exception sdf)
        {
            aa=0;
            v11=0;
            v22=0;
            v33=0;
            v44=0;
            v55=0;
            v66=0;
            vni=0;
        }
        JLabel jl = new JLabel(" Total No. Of Votes          : "+aa);
        JLabel jl1 = new JLabel(" Vote for "+b1.getText()+" : "+v11);
        JLabel jl2 = new JLabel(" Vote for "+b2.getText()+" : "+v22);
        JLabel jl3 = new JLabel(" Vote for "+b3.getText()+" : "+v33);
        JLabel jl4 = new JLabel(" Vote for "+b4.getText()+" : "+v44);
        JLabel jl5 = new JLabel(" Vote for "+b5.getText()+" : "+v55);
        JLabel jl6 = new JLabel(" Vote for "+b6.getText()+" : "+v66);
        JLabel jln = new JLabel(" Vote for NILL             : "+vni);
        int j=30;
        Font type = new Font("Viner Hand ITC ", Font.BOLD|Font.ITALIC, 13);
        jl1.setFont(type);
        jl2.setFont(type);
        jl3.setFont(type);
        jl4.setFont(type);
        jl5.setFont(type);
        jl6.setFont(type);
        jln.setFont(type);
        jb.setBounds(2,0,270,50);
        if(b1.isVisible()||b2.isVisible()||b3.isVisible()||b4.isVisible()||b5.isVisible()||b6.isVisible()||b7.isVisible())
        {
            jl.setBounds(30,j,200,100);
            f1.add(jl);
            j=j+50;
        }
        if(b1.isVisible())
        {
            jl1.setBounds(30,j,200,100);
            f1.add(jl1);
            j=j+50;
        }   
        if(b2.isVisible())
        {
            jl2.setBounds(30,j,200,100);
            f1.add(jl2);
            j=j+50;
        }
        if(b3.isVisible())
        {
            jl3.setBounds(30,j,200,100);
            f1.add(jl3);
            j=j+50;
        }
        if(b4.isVisible())
        {
            jl4.setBounds(30,j,200,100);
            f1.add(jl4);
            j=j+50;
        }
        if(b5.isVisible())
        {
            jl5.setBounds(30,j,200,100);
            f1.add(jl5);
            j=j+50;
        }
        if(b6.isVisible())
        {
            jl6.setBounds(30,j,200,100);
            f1.add(jl6);
            j=j+50;
        }
        if(b7.isVisible())
        {
            jln.setBounds(30,j,200,100);
            f1.add(jln);
            j=j+50;
        }

        f.setEnabled(false);
        JOptionPane pane = new JOptionPane("Loading Result", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
        final JDialog dialog = pane.createDialog(" Result ");

        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        javax.swing.Timer timer = new javax.swing.Timer(3500, new ActionListener()
                {public void actionPerformed(ActionEvent ae)
                    {
                        fload.dispose();
                        gf ="C:/Program Files/D's Voting System/tama.wav";
                        try
                        {
                            music();
                        }
                        catch(Exception sdf)
                        {
                        }

                        f1.setVisible(true);
                        f.setEnabled(true);
                        f.requestFocus();
                        f1.requestFocus();
                    }
                });
        timer.setRepeats(false);
        timer.start();
        open=1;
        loadingRF();
        br.close();
        f1.setLayout(null);
        JLabel no = new JLabel("");
        no.setVisible(false);
        sc.close();

        f1.setResizable(false);
        f1.setLocation(fxs-140,fys-(j+50)/2);
        f1.setSize(280,j+50);
        f1.add(jb);
        f1.add(no);
    }


    public static void main(String[] args)
    {
        new Ds_Voting_System();
    }
}
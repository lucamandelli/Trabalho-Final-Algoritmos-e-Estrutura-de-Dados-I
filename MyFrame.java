import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame implements ActionListener {
  JFrame frame, frameOpc, frameRemiss, framePorcentagem, frameFrequente, frameProcura;
  JTextArea textRemiss, textPorcent, textFreq, textProc;
  JTextField textPalavra;

  JScrollPane scroll, scroll2;

  JButton[] opcArq = new JButton[4];
  JButton javaButton, fiveWeeksButton, cocoaButton, aliceButton;
  JButton[] opcSel = new JButton[4];
  JButton remissivoButton, percentualButton, frequenteButton, pesquisarButton;
  JButton[] opcVoltar = new JButton[5];
  JPanel panel, panelOpc, panelRemissivo;
  JButton[] opcEnterButton = new JButton[1];

  Font myFont = new Font("Arial", Font.BOLD, 14);

  MyFrame() {
    frame();
  }

  public void frame() {
    frame = new JFrame("Trabalho Alest");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);

    opcArq[0] = javaButton = new JButton("Java");
    opcArq[1] = fiveWeeksButton = new JButton("Five weeks in a balloon");
    opcArq[2] = cocoaButton = new JButton("Cocoa and chocolate");
    opcArq[3] = aliceButton = new JButton("Alice");
    for (int i = 0; i < 4; i++) {
      opcArq[i].addActionListener(this);
      opcArq[i].setFont(myFont);
      opcArq[i].setFocusable(false);
    }

    panel = new JPanel();
    panel.setBounds(100, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));
    panel.setBackground(Color.GRAY);
    panel.add(opcArq[0]);
    panel.add(opcArq[1]);
    panel.add(opcArq[2]);
    panel.add(opcArq[3]);

    frame.add(panel);

    frame.setVisible(true);
  }

  public void frameOpc() {
    frameOpc = new JFrame("Selecione o que quer!");
    frameOpc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameOpc.setSize(500, 500);
    frameOpc.setLayout(null);
    frameOpc.setLocationRelativeTo(null);
    opcSel[0] = remissivoButton = new JButton("Exibir índice remissivo");
    opcSel[1] = percentualButton = new JButton("Percentual de Stopwords");
    opcSel[2] = frequenteButton = new JButton("Palavra mais frequente");
    opcSel[3] = pesquisarButton = new JButton("Pesquise uma palavra");
    opcVoltar[0] = new JButton("Voltar");
    opcVoltar[0].addActionListener(this);
    opcVoltar[0].setFont(myFont);
    opcVoltar[0].setFocusable(false);
    for (int i = 0; i < 4; i++) {
      opcSel[i].addActionListener(this);
      opcSel[i].setFont(myFont);
      opcSel[i].setFocusable(false);
    }
    panelOpc = new JPanel();
    panelOpc.setBounds(100, 100, 300, 200);
    panelOpc.setLayout(new GridLayout(4, 4, 10, 10));
    panelOpc.setBackground(Color.GRAY);
    panelOpc.add(opcSel[0]);
    panelOpc.add(opcSel[1]);
    panelOpc.add(opcSel[2]);
    panelOpc.add(opcSel[3]);
    opcVoltar[0].setBounds(170, 350, 150, 50);
    frameOpc.add(opcVoltar[0]);
    frameOpc.add(panelOpc);

    frameOpc.setVisible(true);

  }

  public void frameRemissivo() {
    frameRemiss = new JFrame("Índice Remissivo");
    frameRemiss.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameRemiss.setSize(500, 500);
    frameRemiss.setLayout(null);
    frameRemiss.setLocationRelativeTo(null);
    opcVoltar[1] = new JButton("Voltar");

    opcVoltar[1].addActionListener(this);
    opcVoltar[1].setFont(myFont);
    opcVoltar[1].setFocusable(false);

    opcVoltar[1].setBounds(170, 350, 150, 50);

    textRemiss = new JTextArea(Menu.remissivo());
    textRemiss.setEditable(false);
    scroll = new JScrollPane(textRemiss);

    scroll.setBounds(50, 100, 370, 200);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    frameRemiss.add(opcVoltar[1]);
    frameRemiss.getContentPane().add(scroll);
    frameRemiss.setVisible(true);
  }

  public void framePorcentagem() {
    framePorcentagem = new JFrame("Porcentagem de Stopwords");
    framePorcentagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    framePorcentagem.setSize(500, 500);
    framePorcentagem.setLayout(null);
    framePorcentagem.setLocationRelativeTo(null);
    opcVoltar[2] = new JButton("Voltar");

    opcVoltar[2].addActionListener(this);
    opcVoltar[2].setFont(myFont);
    opcVoltar[2].setFocusable(false);

    opcVoltar[2].setBounds(170, 150, 150, 50);

    textPorcent = new JTextArea(Menu.porcentagem());
    textPorcent.setEditable(false);
    textPorcent.setBounds(225, 100, 40, 20);

    framePorcentagem.add(opcVoltar[2]);
    framePorcentagem.add(textPorcent);
    framePorcentagem.setVisible(true);
  }

  public void frameFrequente() {
    frameFrequente = new JFrame("Palavra mais frequente");
    frameFrequente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameFrequente.setSize(500, 500);
    frameFrequente.setLayout(null);
    frameFrequente.setLocationRelativeTo(null);
    opcVoltar[3] = new JButton("Voltar");

    opcVoltar[3].addActionListener(this);
    opcVoltar[3].setFont(myFont);
    opcVoltar[3].setFocusable(false);

    opcVoltar[3].setBounds(170, 150, 150, 50);

    textFreq = new JTextArea(Menu.frequente());
    textFreq.setEditable(false);
    textFreq.setBounds(100, 100, 250, 20);

    frameFrequente.add(opcVoltar[3]);
    frameFrequente.add(textFreq);
    frameFrequente.setVisible(true);
  }

  public void frameProcura() {
    frameProcura = new JFrame("Procure alguma palavra do texto!");
    frameProcura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameProcura.setSize(500, 500);
    frameProcura.setLayout(null);
    frameProcura.setLocationRelativeTo(null);

    opcVoltar[4] = new JButton("Voltar");
    opcVoltar[4].addActionListener(this);
    opcVoltar[4].setFont(myFont);
    opcVoltar[4].setFocusable(false);
    opcVoltar[4].setBounds(170, 250, 150, 50);

    opcEnterButton[0] = new JButton("Ir");
    opcEnterButton[0].addActionListener(this);
    opcEnterButton[0].setFont(myFont);
    opcEnterButton[0].setFocusable(false);
    opcEnterButton[0].setBounds(370, 100, 50, 20);

    textPalavra = new JTextField();
    textPalavra.setBounds(120, 100, 250, 20);

    textProc = new JTextArea();
    textProc.setEditable(false);

    scroll2 = new JScrollPane(textProc);

    scroll2.setBounds(15, 150, 450, 40);

    frameProcura.add(opcVoltar[4]);
    frameProcura.add(opcEnterButton[0]);
    frameProcura.add(textPalavra);
    frameProcura.add(scroll2);
    frameProcura.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == opcArq[0]) {
      new Menu("java.txt");
      frameOpc();
      frame.dispose();
    }
    if (e.getSource() == opcArq[1]) {
      new Menu("fiveweeksinaballoon.txt");
      frameOpc();
      frame.dispose();
    }
    if (e.getSource() == opcArq[2]) {
      new Menu("cocoaandchocolate.txt");
      frameOpc();
      frame.dispose();
    }
    if (e.getSource() == opcArq[3]) {
      new Menu("alice.txt");
      frameOpc();
      frame.dispose();
    }

    if (e.getSource() == opcSel[0]) {
      frameRemissivo();
      frameOpc.dispose();
    }
    if (e.getSource() == opcSel[1]) {
      framePorcentagem();
      frameOpc.dispose();
    }
    if (e.getSource() == opcSel[2]) {
      frameFrequente();
      frameOpc.dispose();
    }
    if (e.getSource() == opcSel[3]) {
      frameProcura();
      frameOpc.dispose();
    }
    if (e.getSource() == opcVoltar[0]) {
      frameOpc.dispose();
      frame();
    }
    if (e.getSource() == opcVoltar[1]) {
      frameRemiss.dispose();
      frameOpc();
    }
    if (e.getSource() == opcVoltar[2]) {
      framePorcentagem.dispose();
      frameOpc();
    }
    if (e.getSource() == opcVoltar[3]) {
      frameFrequente.dispose();
      frameOpc();
    }
    if (e.getSource() == opcVoltar[4]) {
      frameProcura.dispose();
      frameOpc();
    }
    if (e.getSource() == opcEnterButton[0]) {
      String palavra = Menu.procura(textPalavra.getText());
      textProc.setText(palavra);
    }

  }

}

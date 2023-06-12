import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuSwing {
    private JFrame frame;
    private JPanel panel;
    private int MENU_ALTURA = 600;
    private int MENU_LARGURA = 400;
    private int FORMULARIO_ALTURA = 300;
    private int FORMULARIO_LARGURA = 400;

    public static void iniciarInterface() {
        SwingUtilities.invokeLater(() -> {
            MenuSwing menuSwing = new MenuSwing();
            menuSwing.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        // Criar o JFrame
        frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0, 128, 0)); // Definir cor de fundo verde escuro

        // Criar o painel
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 128, 0)); // Definir cor de fundo verde escuro
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Definir margens

        // Criar os componentes do menu
        JLabel tituloLabel = new JLabel("BrassFoot 0.5");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloLabel, gbc);

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton continuarButton = new JButton("Continuar");
        JButton sairButton = new JButton("Sair");

        // Configurar o estilo dos botões
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        novoJogoButton.setFont(buttonFont);
        continuarButton.setFont(buttonFont);
        sairButton.setFont(buttonFont);

        // Adicionar os componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(novoJogoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(continuarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(sairButton, gbc);

        // Adicionar o painel ao JFrame
        frame.getContentPane().add(panel);

        // Configurar o tamanho e a visibilidade do JFrame
        frame.setSize(MENU_LARGURA, MENU_ALTURA);
        frame.setLocationRelativeTo(null); // Centralizar a janela na tela
        frame.setVisible(true);

        // Adicionar os ouvintes de eventos aos botões
        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNovoJogoForm();
            }
        });

        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Continuar"
                //JOptionPane.showMessageDialog(frame, "Continuar selecionado");
                Player p = new Player();
                Funcoes.carregarjogo(p);
                showPaginaInicial(p);
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Sair"
                System.exit(0);
            }
        });
    }

    private void showNovoJogoForm() {
        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar componentes do formulário
        JLabel nomeLabel = new JLabel("Nome do Jogador:");
        JTextField nomeTextField = new JTextField(20);
        JLabel generoLabel = new JLabel("Time Inicial:");
        String[] timeOpcao = new String[20];
        ArrayList<Time> times = new ArrayList<>();
        try {
            times = importarCsv.times();

        } catch (Exception e) {
            System.out.println(e);
        }
        int i = 0;
        for (Time t : times) {
            timeOpcao[i] = t.getNome();
            i++;
        }

        JComboBox<String> generoComboBox = new JComboBox<>(timeOpcao);
        JButton iniciarButton = new JButton("Iniciar");
        JButton voltarButton = new JButton("Voltar para o Menu");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nomeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(nomeTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(generoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(generoComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(iniciarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(voltarButton, gbc);

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(FORMULARIO_LARGURA, FORMULARIO_ALTURA);
        frame.setLocationRelativeTo(null);

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String time = (String) generoComboBox.getSelectedItem();
                panel.removeAll();
                //salvar no arquivo save
                Funcoes.iniciarnovoJogo(nome,time);
                Player p = new Player();
                Funcoes.carregarjogo(p);
                showPaginaInicial(p);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Voltar ao menu principal
                panel.removeAll();
                panel.removeAll();
                createAndShowGUI();
            }
        });
    }

    private void showPaginaInicial(Player p) {

        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Configurar estilo e posição dos textos
        JLabel jogadorLabel = new JLabel(p.getNome().toUpperCase()+" - "+p.getTime().getNome().toUpperCase());
        jogadorLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        jogadorLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Aumentar o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH; // Alinhar o texto ao topo
        panel.add(jogadorLabel, gbc);

//        JLabel timeLabel = new JLabel(time);
//        timeLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
//        timeLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentar o tamanho da fonte
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        panel.add(timeLabel, gbc);

        JLabel proximaLabel = new JLabel("Próximo Jogo");
        proximaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        proximaLabel.setFont(new Font("Arial", Font.BOLD,20 )); // Aumentar o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(proximaLabel, gbc);


        JLabel partidaLabel;
        try {
            String[] rodada = Funcoes.proximoJogo(p);
             partidaLabel = new JLabel("Brasileirão "+rodada[0]+"° Rodada "+rodada[2]+" x "+rodada[3]);

        }catch (Exception e){
            System.out.println(e);
             partidaLabel = new JLabel("Brasileirão 3° Rodada - Flamengo x Santos");

        }
        if(p.getRodada()>38){
            Liga l1 = new Liga(p);
            partidaLabel = new JLabel("O Campeão: "+l1.lider().getNome());
        }
        partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        partidaLabel.setFont(new Font("Arial", Font.ITALIC, 18)); // Aumentar o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(partidaLabel, gbc);

        // Adicionar botões
//

        JButton proximaPartidaButton = new JButton("Próxima Partida");
        JButton proximaTemporadaButton = new JButton("Próxima Temporada");
        JButton mostrarTabelaButton = new JButton("Mostrar Tabela");
        JButton mostrarProximaRodada = new JButton("Próxima Rodada");
        JButton salvarButtom = new JButton("Salvar Resultados");
        JButton sairButton = new JButton("Voltar");
        if (p.getRodada()<=38){
            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(proximaPartidaButton, gbc);

            gbc.gridx = 0;
            gbc.gridy = 6;
            panel.add(mostrarProximaRodada, gbc);

        }else {
            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(proximaTemporadaButton, gbc);
        }


        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(mostrarTabelaButton, gbc);



        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(salvarButtom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(sairButton, gbc);

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(MENU_LARGURA, MENU_ALTURA);
        frame.setLocationRelativeTo(null);

        // Adicionar os ouvintes de eventos aos botões
        proximaPartidaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                simRodada(p);
            }
        });

        proximaTemporadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Funcoes.novaTemporada(p.getNome(),p.getTime().getNome(),1,p.getDinheiro(),p.getTemporada()+1);
                Funcoes.carregarjogo(p);

                panel.removeAll();
                showPaginaInicial(p);
            }
        });

        mostrarTabelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Mostrar Tabela"
                panel.removeAll();
                mostrarTabela( p);
                // ...
            }
        });
        mostrarProximaRodada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                showRodada(p);
            }
        });

        salvarButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ///salvar no times.csv
                try {
                    ////////salvar tabela
                    Funcoes.salvarProgresso(p.getNome(),p.getTime().getNome(),p.getRodada(),p.getDinheiro(),p.getTemporada());
                    System.out.println("Dados Salvos");


                }catch (Exception f){
                    System.out.println("Dados não Salvos");
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para a opção "Sair"
                panel.removeAll();
                createAndShowGUI();
            }
        });
    }
    private void showRodada(Player p) {
        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar componentes da página
        JLabel tituloLabel = new JLabel("Detalhes da Rodada");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloLabel, gbc);

        JLabel rodadaLabel = new JLabel("Rodada: " + p.getRodada());
        rodadaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        rodadaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(rodadaLabel, gbc);
        int i = 0;
        try {
            String[][] rodada = importarCsv.Confrontos(p.getRodada());

            for (i = 0;i<10;i++){
                JLabel partidaLabel = new JLabel(rodada[i][2] + " x " + rodada[i][3]);
                partidaLabel.setFont(new Font("Arial", Font.ITALIC, 18));
                partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
                gbc.gridx = 0;
                gbc.gridy = i+2;
                panel.add(partidaLabel, gbc);

            }
        }catch(Exception e){
            JLabel partidaLabel = new JLabel("Jogos ainda não Definidos");
            partidaLabel.setFont(new Font("Arial", Font.BOLD, 18));
            partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(partidaLabel, gbc);
        }

        JButton sairButton = new JButton("Voltar");
        gbc.gridx = 0;
        gbc.gridy = i+3;
        panel.add(sairButton, gbc);

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(MENU_LARGURA, MENU_ALTURA);
        frame.setLocationRelativeTo(null);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaginaInicial(p);
            }
        });
    }

    private void simRodada(Player p) {
        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar componentes da página
        JLabel tituloLabel = new JLabel("Detalhes da Rodada");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloLabel, gbc);

        JLabel rodadaLabel = new JLabel("Rodada: " + p.getRodada());
        rodadaLabel.setFont(new Font("Arial", Font.BOLD, 18));
        rodadaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(rodadaLabel, gbc);
        int i = 0;
        try {
            String[][] rodada = Funcoes.simularRodada(p);

            for (i = 0;i<10;i++){

                JLabel partidaLabel = new JLabel(rodada[i][0] +" " + rodada[i][1]+" x "+ rodada[i][3]+" " + rodada[i][2]);
                partidaLabel.setFont(new Font("Arial", Font.ITALIC, 18));
                partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
                gbc.gridx = 0;
                gbc.gridy = i+2;
                panel.add(partidaLabel, gbc);

            }
        }catch(Exception e){
            JLabel partidaLabel = new JLabel("Jogos ainda não Definidos");
            partidaLabel.setFont(new Font("Arial", Font.BOLD, 18));
            partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(partidaLabel, gbc);
        }

        JButton sairButton = new JButton("Voltar");
        gbc.gridx = 0;
        gbc.gridy = i+3;
        panel.add(sairButton, gbc);

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(MENU_LARGURA, MENU_ALTURA);
        frame.setLocationRelativeTo(null);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaginaInicial(p);
            }
        });
    }


    private void mostrarTabela(Player p) {
        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar componentes da página
        JLabel tituloLabel = new JLabel("Tabela do Campeonato ");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloLabel, gbc);

        Liga l = new Liga(p);
        String[][] dados = new String[20][9];

        String[] colunas = {"Posição", "Time","Jogos", "Pontos","Vitorias","Empates","Derrotas","Gols Marcados","Gols Sofridos"};
        int i = 0;
        for (Time t:l.getTabela()){
            dados[i][0] = Integer.toString(i+1);
            dados[i][1] = t.getNome();
            dados[i][2] = Integer.toString(t.getJogos());
            dados[i][3] = Integer.toString(t.getPontos());
            dados[i][4] = Integer.toString(t.getVitorias());
            dados[i][5] = Integer.toString(t.getEmpates());
            dados[i][6] = Integer.toString(t.getDerrotas());
            dados[i][7] = Integer.toString(t.getGolsmarcados());
            dados[i][8] = Integer.toString(t.getGolsofridos());

            i++;
        }

        JTable tabela = new JTable(dados, colunas) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);

                // Set the background color for the first four rows to green
                if (row < 4) {
                    component.setBackground(Color.GREEN);
                    component.setForeground(Color.DARK_GRAY);
                }
                // Set the background color for the last four rows to red
                else if (row >= getRowCount() - 4) {
                    component.setBackground(Color.RED);
                    component.setForeground(Color.WHITE);

                }
                // Reset the background color for other rows
                else {
                    component.setBackground(Color.WHITE);
                }

                return component;
            }
        };
        tabela.setFont(new Font("Arial", Font.PLAIN, 16));
        tabela.setForeground(Color.BLACK);
        tabela.setBackground(Color.WHITE);
        tabela.setRowHeight(30);
        tabela.setEnabled(false);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(1500, 520));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(scrollPane, gbc);
        String[][] dados2 = {{"Melhor Ataque", ""}, {"Melhor Defesa", ""}};


        if (p.getRodada()>1){
            dados2[0][0] = "Melhor Ataque";
            dados2[1][0] = "Melhor Defesa";

            dados2[0][1] = l.melhorAtaque().getNome();
            dados2[1][1] = l.melhorDefesa().getNome();
        }
        String[] colunas2 = {"Estatitica", "Time"};

        JTable tabela2 = new JTable(dados2, colunas2);
        tabela2.setFont(new Font("Arial", Font.PLAIN, 16));
        tabela2.setForeground(Color.BLACK);
        tabela2.setBackground(Color.WHITE);
        tabela2.setRowHeight(30);
        tabela2.setEnabled(false);

        JScrollPane scrollPane2 = new JScrollPane(tabela2);
        scrollPane2.setPreferredSize(new Dimension(500, 100));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(scrollPane2, gbc);

        JButton sairButton = new JButton("Voltar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(sairButton, gbc);


        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(1920, 960);
        frame.setLocationRelativeTo(null);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPaginaInicial(p);
            }
        });
    }


}


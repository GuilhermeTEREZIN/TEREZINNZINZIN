import javax.swing.*;
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

    public static void main(String[] args) {
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
        gbc.gridy = 0;
        panel.add(novoJogoButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(continuarButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
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
                showPaginaInicial("Bruno - Flamengo", "Copa do Brasil - Flamengo x Santos");
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


                // Lógica para iniciar o jogo com os dados informados
                //JOptionPane.showMessageDialog(frame, "Iniciar jogo com nome: " + nome + ", gênero: " + genero);

                // Voltar ao menu principal
                panel.removeAll();
                showPaginaInicial(nome,time);
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

    private void showPaginaInicial(String jogador, String partida) {
        panel.removeAll();
        panel.repaint();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Configurar estilo e posição dos textos
        JLabel jogadorLabel = new JLabel(jogador);
        jogadorLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        jogadorLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Aumentar o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH; // Alinhar o texto ao topo
        panel.add(jogadorLabel, gbc);

        JLabel partidaLabel = new JLabel(partida);
        partidaLabel.setForeground(Color.WHITE); // Definir cor do texto como branco
        partidaLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Aumentar o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(partidaLabel, gbc);

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.setSize(MENU_LARGURA, MENU_ALTURA);
        frame.setLocationRelativeTo(null);
    }
}

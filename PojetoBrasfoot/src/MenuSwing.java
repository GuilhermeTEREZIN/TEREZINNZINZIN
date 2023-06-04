import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuSwing {
    private JFrame frame;
    private JPanel panel;
    private int ALTURA = 600;
    private int LARGURA = 400;

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
        frame.setSize(LARGURA, ALTURA);
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
                JOptionPane.showMessageDialog(frame, "Continuar selecionado");
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
        ArrayList<Time>  times = new ArrayList<>();
        try {
            times = importarCsv.times();

        }catch (Exception e){
            System.out.println(e);
        }
        int i = 0;
        for(Time t:times){
            timeOpcao[i] = t.getNome();
            i++;
        }

        JComboBox<String> generoComboBox = new JComboBox<>(timeOpcao);
        JButton iniciarButton = new JButton("Iniciar");

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

        // Atualizar o painel e redimensionar o JFrame
        panel.revalidate();
        frame.pack();

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String genero = (String) generoComboBox.getSelectedItem();

                // Lógica para iniciar o jogo com os dados informados
                //JOptionPane.showMessageDialog(frame, "Iniciar jogo com nome: " + nome + ", gênero: " + genero);

                // Voltar ao menu principal
                panel.removeAll();
                createAndShowGUI();
            }
        });
    }
}

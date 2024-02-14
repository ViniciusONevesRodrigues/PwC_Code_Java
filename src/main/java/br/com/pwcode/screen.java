package br.com.pwcode;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.com.pwcode.functions.functions;
import br.com.pwcode.test.testFunctions;


public class screen {

    private JFrame screen;
    private JLabel title;
    private JLabel titleResponse;
    private JButton button;
    private JButton buttonTest;
    private JTextField input;
    private JTextArea response;
    private JTextArea responseTest;
    functions functions = new functions();

    public JLabel title(){
        title = new JLabel("Digite o endereço:");
        title.setForeground(Color.black);
        title.setBounds(10, 0, 300, 50);
        int fontSize = 27;
        title.setFont(new Font("Roboto", Font.BOLD, fontSize));
        return title;
    }
    public JTextField input(){
        input = new JTextField(50);
        input.setBackground(Color.decode("#333333")); 
        input.setBounds(10, 50, 750, 30);
        input.setForeground(Color.white);
        input.setCaretColor(Color.white);
        

        return input;
    }
    public JButton button(){
        button = new JButton("Separar");
        button.setForeground(Color.white);
        button.setBounds(10, 77, 375, 40);
        button.setBackground(Color.decode("#FC6A03"));
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String request = input.getText();
                String response = functions.simpleAddress(request);
                updateTextArea(response);
            }
        };

        button.addActionListener(listener);
        return button;
    }
    
    public JLabel titleResponse(){
        titleResponse = new JLabel("Resposta:");
        titleResponse.setForeground(Color.black);
        titleResponse.setBounds(10, 130, 300, 50);
        int fontSize = 27;
        titleResponse.setFont(new Font("Roboto", Font.BOLD, fontSize));
        return titleResponse;
    }

    public JButton buttonTest(){
        buttonTest = new JButton("Testar");
        buttonTest.setForeground(Color.white);
        buttonTest.setBounds(385, 77, 375, 40);
        buttonTest.setBackground(Color.decode("#FC6A03"));
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                testFunctions test = new testFunctions();
        
                Result result = JUnitCore.runClasses(test.getClass());
                
                StringBuilder feedback = new StringBuilder("Resultados dos testes:\n");
                
                for (Failure failure : result.getFailures()) {
                    feedback.append(failure.toString()).append("\n");
                }
                
                feedback.append("Total de testes executados: ").append(result.getRunCount()).append("\n");
                feedback.append("Total de falhas: ").append(result.getFailureCount()).append("\n");
                
                updateTestResponseTextArea(feedback.toString());
            }
        };

        buttonTest.addActionListener(listener);

        return buttonTest;
    }

    public JTextArea response() {
        response = new JTextArea();
        response.setBounds(10, 170, 750, 50);
        response.setForeground(Color.white);
        response.setBackground(Color.decode("#333333"));
        int fontSize = 30;
        response.setFont(new Font("Roboto", Font.BOLD, fontSize));
        response.setEditable(false);

        return response;
    }

    public JTextArea responseTest() {
        responseTest = new JTextArea();
        responseTest.setBounds(10, 250, 750, 300);
        responseTest.setForeground(Color.white);
        int fontSize = 10;
        responseTest.setFont(new Font("Roboto", Font.BOLD, fontSize));
        responseTest.setBackground(Color.decode("#333333"));
        responseTest.setEditable(false);

        return responseTest;
    }

    public void updateTextArea(String text) {
        response.setText(text);
    }

    public void updateTestResponseTextArea(String text) {
        responseTest.setText(text);
    }

    public void screenAddress() {
        screen = new JFrame();
        screen.setTitle("Address • Splitter");
        screen.setBounds(0, 0, 800, 600);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        screen.setResizable(false);
        screen.getContentPane().setBackground(Color.decode("#ffffff"));

        screen.getContentPane().add(title());
        screen.getContentPane().add(input());
        screen.getContentPane().add(button());
        screen.getContentPane().add(buttonTest());
        screen.getContentPane().add(titleResponse());
        screen.getContentPane().add(response());
        screen.getContentPane().add(responseTest());

        screen.setVisible(true);
    }
}

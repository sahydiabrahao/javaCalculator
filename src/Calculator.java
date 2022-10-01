import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
	//VARIAVEIS..................................................................
	ImageIcon 	image 		= new ImageIcon("./src/calculator.png");
	Font 		myFont 		= new Font("Ink Free", Font.BOLD, 20);
	int 		corTela 	= 0x190940; //VERMELHO
	int 		corvVisor 	= 0xFFFFFF; //PRETO
	int 		corTeclado 	= 0x190940; //AZUL
	
	JFrame 		frame;
	JTextField 	textField;										//VISOR
	JPanel		panel;
	
	JButton[] 	numberButtons 	= new JButton[10];
	JButton[]	functionButton	= new JButton[9];
	JButton		addButton, subButton, mulButton, divButton;		// SOMAR 	SUBTRAIR MULTIPLICAR DIVIDIR
	JButton		decButton, equButton, delButton, clrButton;		// DECIMAL 	IGUAL 	 DELETAR 	 LIMPAR
	JButton		negButton;										// NUMERO NEGATIVO
	
	double 		num1 = 0, num2 = 0, result = 0;
	char		operator;
	
	//CONTRUTOR..................................................................
	Calculator(){
		//TELA...................................................................
		frame = new JFrame("Calculadora");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//BOTÃO DE FECHAR	
		frame.setSize(300, 360);								//DIMENSÃO
		frame.setLayout(new FlowLayout());						//FLOW LAYOUT
		frame.setResizable(false); 								//TAMANHO FIXO
		frame.setLocationRelativeTo(null);						//JANELA APARECE NO MEIO DA TELA
		frame.getContentPane().setBackground(new Color(corTela));//COR
		frame.setIconImage(image.getImage());					//ICONE
			
		//VISOR...................................................................
		textField = new JTextField();
		textField.setFont(myFont);
		textField.setPreferredSize(new Dimension(270,50));
		textField.setBackground(new Color(corvVisor));	
		textField.setEditable(false);							//NÃO CLICLA/ESCREVE NO VISOR
		
		//BOTÕES....................................................................
		addButton = new JButton("+");							//CRIA BOTÕES
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		
		functionButton[0] = addButton;							//ADICIONA BOTÕES A LISTA
		functionButton[1] = subButton;
		functionButton[2] = mulButton;
		functionButton[3] = divButton;
		functionButton[4] = decButton;
		functionButton[5] = equButton;
		functionButton[6] = delButton;
		functionButton[7] = clrButton;
		functionButton[8] = negButton;
		
		//BOTÕES COM FUNÇÃO	
		for(int i = 0; i < 9; i++) {							//ATRIBUI PARÂMETROS AOS BOTÕES POR MEIO DO FOR LOOP
			functionButton[i].addActionListener(this);			//FUNÇÃO AO CLICAR
			functionButton[i].setFont(myFont);					//FONTE	
			functionButton[i].setFocusable(false);				//TIRA BORDA INTERNA
			functionButton[i].setPreferredSize(new Dimension(62,50));//DIMENSÃO
		}
		//BOTÕES NUMERICOS	
		for(int i = 0; i < 10; i++) {							//ATRIBUI PARÂMETROS AOS BOTÕES POR MEIO DO FOR LOOP
			numberButtons[i] = new JButton(String.valueOf(i));	//VALOR DO CONTADOR 1234...10
			numberButtons[i].addActionListener(this);			//FUNÇÃO AO CLICAR
			numberButtons[i].setFont(myFont);					//FONTE	
			numberButtons[i].setFocusable(false);				//TIRA BORDA INTERNA
			numberButtons[i].setPreferredSize(new Dimension(62,50));//DIMENSÃO
		}
		//BOTÕES DELETAR E LIMPAR	
		negButton.setPreferredSize(new Dimension(86,25));
		delButton.setPreferredSize(new Dimension(86,25));
		clrButton.setPreferredSize(new Dimension(86,25));
		
		//TECLADO...................................................................
		panel = new JPanel();
		panel.setFont(myFont);
		panel.setPreferredSize(new Dimension(270,225));
		panel.setBackground(new Color(corTeclado));				
		//panel.setLayout(new GridLayout(4,4,10,10));			//LINHAS, COLUNAS, ESPAÇO X, ESPAÇO Y
		panel.add(numberButtons[1]);							//ADICIONA BOTÃO AO PAINEL
		panel.add(numberButtons[2]);	
		panel.add(numberButtons[3]);	
		panel.add(addButton);
		panel.add(numberButtons[4]);							//ADICIONA BOTÃO AO PAINEL
		panel.add(numberButtons[5]);	
		panel.add(numberButtons[6]);	
		panel.add(subButton);
		panel.add(numberButtons[7]);							//ADICIONA BOTÃO AO PAINEL
		panel.add(numberButtons[8]);	
		panel.add(numberButtons[9]);	
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		//ADICIONA A TELA............................................................
		frame.add(textField);									//ADICIONA VISOR
		frame.add(negButton);									//ADICIONA BOTÃO DELETAR
		frame.add(delButton);									//ADICIONA BOTÃO DELETAR
		frame.add(clrButton);									//ADICIONA BOTÃO LIMPAR
		frame.add(panel);										//ADICIONA TECLADO
		frame.setVisible(true);									//VISIBILIDADE	
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();			//OBJETO
		

	}
	//FUNÇÕES DOS BOTÕES..............................................................
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {	
			if(e.getSource() == numberButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");	
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");	
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");	
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");	
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());

			switch(operator) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			}
			textField.setText(String.valueOf(result));
			num1 = result;
		}
		if(e.getSource() == clrButton) {
			textField.setText("");	
		}	
		if(e.getSource() == delButton) {
			String string = textField.getText();	
			textField.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				textField.setText(textField.getText()+string.charAt(i));
			}
		}	
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp = temp * -1;
			textField.setText(String.valueOf(temp));
			
		}	
	}
}

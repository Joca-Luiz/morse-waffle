package br.com.jocaluiz.morsewaffle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class MorseWaffle {
	
	// Global Variables
	public static JFrame frame;
	public static String NEW_LINE = "\n";
	public static int frameX = 500, frameY = 500;
	public static PlaceholderTextField mainInput;
	public static String mainInputResults;
	public static JLabel title;
	public static JTextArea outputArea;
	public static Border outputDiv;
	public static int gameSelect;
	
	public static void main(String[]args) {
		createLayout();
	}
	
	public static void createLayout() {
		// Create Frame-
		frame = new JFrame("Morse Waffle");
		
		// Background Color
		frame.getContentPane().setBackground(Color.black);
		
		// Title
		title = new JLabel("Morse Waffle");
		title.setBounds(5, 5, 150, 50);
		title.setForeground(Color.green);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(title);
		
		// Border
		outputArea = new JTextArea("Type 'help' to see commands. Author: Joca" + NEW_LINE + NEW_LINE);
		outputArea.setBounds(5, 50, 475, 365);
		outputArea.setBorder(new LineBorder(Color.green));
		outputArea.setBackground(Color.black);
		outputArea.setForeground(Color.green);
		outputArea.setEditable(false);
		outputArea.setWrapStyleWord(true);
		frame.getContentPane().add(outputArea);
		
		// Main Text Box
		mainInput = new PlaceholderTextField();
	    mainInput.setBounds(5, 415, 475, 30);
	    mainInput.setPlaceholder("Digite Sua Função");
	    mainInput.setBackground(Color.black);
	    mainInput.setCaretColor(Color.green);
	    mainInput.setForeground(Color.green);
	    mainInput.setBorder(new LineBorder(Color.green));
	    frame.getContentPane().add(mainInput);
	    
	    // Enter Trigger
	    enterTrigger();
		
		// Sizing frame
		frame.setSize(new Dimension(frameX, frameY));
		
		// Setting Default Exit Method
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting Layout Null
		frame.setLayout(null);
		
		// Setting Visible
		frame.setVisible(true);
	}
	
	public static String commandsRemove(String str, String prefix) {
		return str.replaceAll(prefix, "");
	}
	
	public static void clearConsole(JTextArea txt) {
		txt.setText(null);
	}
	
	public static void commandsList() {
		// Command 01 - Write
		String writePrefix = "write ";
		boolean writeCheck = mainInputResults.startsWith(writePrefix);
		if (writeCheck) {
			outputArea.append(commandsRemove(mainInputResults, writePrefix) + NEW_LINE);
		}
		
		// Command 02 - clear
		String clearPrefix = "clear";
		boolean clearCheck = mainInputResults.startsWith(clearPrefix);
		if (clearCheck) {
			clearConsole(outputArea);
		}
		
		// Command 03 - Open Browser
		String openBrowserPrefix = "browser";
		boolean openBrowserCheck = mainInputResults.startsWith(openBrowserPrefix);
		if (openBrowserCheck) {
			outputArea.append("Opening browser..." + NEW_LINE);
			try {
				Runtime.getRuntime().exec("explorer https://google.com");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// Command 04 - Games
		String gamesPrefix = "games";
		boolean gamesCheck = mainInputResults.startsWith(gamesPrefix);
		
		if (gamesCheck) {
			outputArea.setText(
					"Game plataforms: " + NEW_LINE +
					"1. Steam" + NEW_LINE +
					"2. Frinday Night Funkin folder" + NEW_LINE +
					"3. Minecraft Laucher" + NEW_LINE
			);
			
			mainInput.addKeyListener(new java.awt.event.KeyAdapter() {
	            public void keyPressed(java.awt.event.KeyEvent evt) {
	               if (evt.getKeyCode() == KeyEvent.VK_ENTER){
	            	   mainInputResults = mainInput.getText();
	            	   gameSelect = Integer.parseInt(mainInputResults);
	            	   
	            	   
	            	   if (gameSelect == 1) {
	             		   outputArea.setText("Opening Steam..." + NEW_LINE);
	             	   }
	             	   
	             	   if (gameSelect == 2) {
	             		   outputArea.setText("Opening FNF folder..." + NEW_LINE);
	             	   }
	             	   
	             	   if (gameSelect == 3) {
	             		   outputArea.setText("Opening Minecraft laucher..." + NEW_LINE);
	             	   } 
	             	   
	             	   if (gameSelect > 3 || gameSelect <= 0) {
	             		   outputArea.setText("Game not found, try again! Use 1, 2 or 3" + NEW_LINE);
	             	   }
	             	   
	             	  enterTrigger();
	             	  gameSelect = 0;
	             	   
	               }
	            }
	        });
        }
		
		// Command 05 - Matrix
		String matrixPrefix = "matrix";
		boolean matrixCheck = mainInputResults.startsWith(matrixPrefix);
		if (matrixCheck) {
			clearConsole(outputArea);
			outputArea.append("0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" +"0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" +"0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "010101010101010101010100101010101010100010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" +"0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010" + "0101010101010101010101001010101010100011010100101101010100010101010" + NEW_LINE + "0101010101010101010101001010101010100011010100101101010100010101010");
		}
		
		// Command 06 - help
		String helpPrefix = "help";
		boolean helpCheck = mainInputResults.startsWith(helpPrefix);
		if (helpCheck) {
			outputArea.append(
					"Commands: " + NEW_LINE +
					"01 - write: Write something on the bord;" + NEW_LINE +
					"02 - clear: Clear the bord;" + NEW_LINE +
					"03 - browser: Open the you default browser;" + NEW_LINE +
					"04 - games: Open game platforms (Use: 1, 2 or 3 to chose);" + NEW_LINE +
					"05 - matrix: The famous 01." + NEW_LINE
			);
		}
		
		// If Command Not Found
		else if (gamesCheck == false && clearCheck == false && writeCheck == false && gameSelect == 0 && matrixCheck == false && openBrowserCheck == false) {
			outputArea.append("Function '" + mainInputResults + "' not found." + NEW_LINE);
		}
		
		
		
	}
	
	public static void enterTrigger() {
		mainInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
               if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            	   mainInputResults = mainInput.getText();
            	   commandsList();
               }
            }
        });
	}
}



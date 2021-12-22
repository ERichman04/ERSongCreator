import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.Border;
public class songGUI implements ActionListener {
	static JLabel message = new JLabel();
	static JLabel durationMessage = new JLabel();
	static JLabel ocativeMessage = new JLabel();
	static JLabel songMessages = new JLabel();
	static JLabel noteSelection = new JLabel();
	static JComboBox combo = new JComboBox();
	static JLabel showSong = new JLabel();
	static JTextArea showThatSong = new JTextArea();
	static int natural, flat, sharp, whole, half, quarter, eighth, one, two, three, four, five, six, seven, eight, nine, counter, harmany = 0;
	static Pattern p = new Pattern(); static Pattern p2 = new Pattern(); static Pattern p3 = new Pattern(); static Pattern p4 = new Pattern(); static Pattern p5 = new Pattern();
	public songGUI() {
		//creating the objects
		Player play = new Player();
		ArrayList<String> song = new ArrayList<String>();
		//create the frame
		JFrame f = new JFrame("Song Creator");
		f.getContentPane().setLayout(null);
		f.setSize(1000, 500);
		f.setPreferredSize(new Dimension(1000, 700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.black);
		//Create the music note icons
		JLabel picA = new JLabel(), picB = new JLabel(), picC = new JLabel(), picD = new JLabel(), picE = new JLabel(), picF = new JLabel(), picG = new JLabel(), picQNote = new JLabel(), measure = new JLabel(), restNote = new JLabel();
		
		//setting the music note icons
		picA.setIcon(new ImageIcon("src\\Letter A.PNG"));
		picB.setIcon(new ImageIcon("src\\Letter B.png"));
		picC.setIcon(new ImageIcon("src\\Letter C.png"));
		picD.setIcon(new ImageIcon("src\\Letter D.png"));
		picE.setIcon(new ImageIcon("src\\Letter E.png"));
		picF.setIcon(new ImageIcon("src\\Letter F.png"));
		picG.setIcon(new ImageIcon("src\\Letter G.png"));
		picQNote.setIcon(new ImageIcon("D:\\Javaprojects\\ERSongCreator\\srcQNote.png"));
		measure.setIcon(new ImageIcon("src\\measures.gif"));
		restNote.setIcon(new ImageIcon("src\\RNote.png"));

		//setting the image location
		picA.setBounds(145, 25, 75, 75);
		picB.setBounds(225, 25, 75, 75);
		picC.setBounds(295, 25, 75, 75);
		picD.setBounds(365, 25, 75, 75);
		picE.setBounds(435, 25, 75, 75);
		picF.setBounds(500, 25, 75, 75);
		picG.setBounds(565, 25, 75, 75);
		picQNote.setBounds(500, 300, 75, 75);
		measure.setBounds(150, 175, 800, 200);
		restNote.setBounds(635, 25, 75, 75);
		songMessages.setBounds(420, 575, 300, 50);
		noteSelection.setBounds(450, 125, 300, 50);
		durationMessage.setBounds(765, 75, 150, 25);
		ocativeMessage.setBounds(765, 125, 150, 25);
		showThatSong.setBounds(340, 420, 300, 25);
		//change color of text
		songMessages.setForeground(Color.white);
		noteSelection.setForeground(Color.white);
		durationMessage.setForeground(Color.white);
		ocativeMessage.setForeground(Color.white);
		//adding the music note icons
		f.add(picA);
		f.add(picB);
		f.add(picC);
		f.add(picD);
		f.add(picE);
		f.add(picF);
		f.add(picG);
		f.add(picQNote);
		f.add(measure);
		f.add(restNote);
		f.add(songMessages);
		f.add(noteSelection);
		f.add(durationMessage);
		f.add(ocativeMessage);
		f.add(showThatSong);
		//Create the buttons and Labels

		JButton startSong = new JButton("Start Song");
		JButton clearSong = new JButton("Clear Song");
		JButton removeLast = new JButton("Remove Last Note");
		JButton rip = new JButton("Piano Rip");
		JButton pattern = new JButton("Set Pattern 1");
		JButton pattern2 = new JButton("Set Pattern 2");
		JButton pattern3 = new JButton("Set Pattern 3");
		JButton pattern4 = new JButton("Set Pattern 4");
		JButton pattern5 = new JButton("Set Pattern 5");
		JButton runPattern = new JButton("Add Pattern 1");
		JButton runPattern2 = new JButton("Add Pattern 2");
		JButton runPattern3 = new JButton("Add Pattern 3");
		JButton runPattern4 = new JButton("Add Pattern 4");
		JButton runPattern5 = new JButton("Add Pattern 5");
		JToggleButton harmonyButton = new JToggleButton("Harmony");
//		JButton saveAFile = new JButton("Save Song");
//		JButton openSong = new JButton("Open Song");
		startSong.setBounds(200, 500, 100, 50);
		removeLast.setBounds(400, 500, 150, 50);
		clearSong.setBounds(650, 500, 100, 50);
		rip.setBounds(175, 135, 125, 25);
		pattern.setBounds(840, 180, 125, 25);
		pattern2.setBounds(840, 220, 125, 25);
		pattern3.setBounds(840, 260, 125, 25);
		pattern4.setBounds(840, 300, 125, 25);
		pattern5.setBounds(840, 340, 125, 25);
		runPattern.setBounds(12, 180, 125, 25);
		runPattern2.setBounds(12, 220, 125, 25);
		runPattern3.setBounds(12, 260, 125, 25);
		runPattern4.setBounds(12, 300, 125, 25);
		runPattern5.setBounds(12, 340, 125, 25);
		harmonyButton.setBounds(435, 385, 100, 25);
//		saveAFile.setBounds(865, 600, 100, 25);
//		openSong.setBounds(25, 600, 100, 25);
		f.add(startSong);
		f.add(clearSong);
		f.add(removeLast);
		f.add(rip);
		f.add(pattern);
		f.add(pattern2);
		f.add(pattern3);
		f.add(pattern4);
		f.add(pattern5);
		f.add(runPattern);
		f.add(runPattern2);
		f.add(runPattern3);
		f.add(runPattern4);
		f.add(runPattern5);
//		f.add(harmonyButton);
//		f.add(saveAFile);
//		f.add(openSong);
		//Drop down menu for sharp and flat
		String[] choices = {"None", "Sharp", "Flat"};
		JComboBox<String> cb = new JComboBox(choices);
		//Drop down menu for duration of notes
		String[] noteDuration = {"Quarter", "Half", "Whole", "Eighth"};
		JComboBox<String> notesDuration = new JComboBox(noteDuration);
		//Drop down menu for Ocatives
		String[] ocative = {"1", "2", "3" ,"4" ,"5" ,"6" ,"7" ,"8" ,"9"};
		JComboBox<String> ocativeBox = new JComboBox(ocative);
		combo.equals(cb);
		cb.setBounds(680, 25, 75, 25);
		cb.setVisible(true);
		message.setBounds(765, 25, 150, 25);
		message.setForeground(Color.white);
		notesDuration.setBounds(680, 75,75, 25);
		ocativeBox.setBounds(680, 125, 75, 25);
		f.add(cb);
		f.add(message);
		f.add(notesDuration);
		f.add(ocativeBox);

		//Create Action/Mouse Listeners
		cb.addActionListener(this);
		ActionListener songMessage = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton)e.getSource();
				if (temp == startSong) {
					play.play(playSong(song));
					songMessages.setText("Starting Song");
				}
				if (temp == removeLast) {
					if (!song.isEmpty()) {
						removeLast(song);
						songMessages.setText("Removing Last Note");
					}
				}
				if (temp == clearSong){
					clearSong(song);
					songMessages.setText("Clearing the song");
				}

				f.add(songMessages);
			}

			private String playSong(ArrayList<String> song) {
				String thatSong = "";
				for(int i = 0; i < song.size(); i++) {
					thatSong = thatSong + " " + song.get(i);
				}
				System.out.println(thatSong);
				return thatSong;
			}
		};
		//Adding Notes to the Song
		MouseListener pickNote = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				counter++;
				String note = "V0 ";
				JLabel temp = (JLabel)e.getSource();
				if (temp == picA) {
					note = "A";
					noteSelection.setText("You have added A");
					noteCheck();
				}
				if (temp == picB) {
					note = "B";
					noteSelection.setText("You have added B");
					noteCheck();
				}
				if (temp == picC) {
					note = "C";
					noteSelection.setText("You have added C");
					noteCheck();
				}
				if (temp == picD) {
					note = "D";
					noteSelection.setText("You have added D");
					noteCheck();
				}
				if (temp == picE) {
					note = "E";
					noteSelection.setText("You have added E");
					noteCheck();
				}
				if (temp == picF) {
					note = "F";
					noteSelection.setText("You have added F");
					noteCheck();
				}
				if (temp == picG) {
					note = "G";
					noteSelection.setText("You have added G");
					noteCheck();
				}
				if (temp == restNote) {
					note = "R";
					noteSelection.setText("You have added a Rest");
				}
				//checks for flat, sharp, or natural
				if (natural != 1 && temp != restNote) {
					if (flat == 1) {
						note = note + "b";
					}
					if(sharp == 1) {
						note = note + "#";
					}
				}
				note = note + ocativeCheck();
				note = note + durationCheck();
				if (harmany == 1) {
					note = note + "+";
				}
				showThatSong.append(note + " ");
				song.add(note);
				if (counter % 11 == 0) {
					showThatSong.setText(" ");
				}
			}
			private String durationCheck() {
				String s = "q";
				if (half == 1)
					s = "h";
				if (whole == 1)
					s = "w";
				if (eighth == 1)
					s = "i";
				return s;
			}
			private String ocativeCheck() {
				String s = "5";
				if (one == 1)
					s = "1";
				if (two == 1) 
					s = "2";
				if (three == 1)
					s = "3";
				if (four == 1)
					s = "4";
				if (six == 1)
					s = "6";
				if (seven == 1)
					s = "7";
				if (eight == 1)
					s = "8";
				if (nine == 1)
					s = "9";
				return s;
			}
			//prints if notes are flat or sharp
			private void noteCheck() {
				if(flat == 1) {
					String s = noteSelection.getText();
					noteSelection.setText(s + "b"); 
				}
				if(sharp == 1) {
					String s = noteSelection.getText();
					noteSelection.setText(s+ "#");
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		};

		ActionListener octives = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String s = (String)cb.getSelectedItem();
				switch (s) {
				case "1": ocativeMessage.setText("Octive set to 1");
					one = 1;
					two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "2": ocativeMessage.setText("Octive set to 2");
					two = 1;
					one = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "3": ocativeMessage.setText("Octive set to 3");
					three = 1;
					two = 0; one = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "4": ocativeMessage.setText("Octive set to 4");
					four = 1;
					two = 0; three = 0; one = 0; five = 0; six = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "5": ocativeMessage.setText("Octive set to 5");
					five = 1;
					two = 0; three = 0; four = 0; one = 0; six = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "6": ocativeMessage.setText("Octive set to 6");
					six = 1;
					two = 0; three = 0; four = 0; five = 0; one = 0; seven = 0; eight = 0; nine = 0;
					break;
				case "7": ocativeMessage.setText("Octive set to 7");
					seven = 1;
					two = 0; three = 0; four = 0; five = 0; six = 0; one = 0; eight = 0; nine = 0;
					break;
				case "8": ocativeMessage.setText("Octive set to 8");
					eight = 1;
					two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; one = 0; nine = 0;
					break;
				case "9": ocativeMessage.setText("Octive set to 9");
					nine = 1;
					two = 0; three = 0; four = 0; five = 0; six = 0; seven = 0; eight = 0; one = 0;
					break;
				}
			}
		};
		ActionListener duration = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				String s = (String)cb.getSelectedItem();
				switch (s) {
				case "Quarter": durationMessage.setText("set to quarter notes");
					quarter = 1;
					half = 0; whole = 0; eighth = 0;
					break;
				case "Half": durationMessage.setText("set to half notes");
					half = 1;
					quarter = 0; whole = 0; eighth = 0;
					break;
				case "Whole": durationMessage.setText("set to whole notes");
					whole = 1;
					quarter = 0; half = 0; eighth = 0;
					break;
				case "Eighth": durationMessage.setText("set to eighth notes");
					eighth = 1;
					quarter = 0; half = 0; whole = 0;
					break;
				}
			}
		};
		
		ActionListener pianoRip = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				play.play("C1x D1x E1x F1x G1x A1x B1x C2x D2x E2x F2x G2x A2x B2x C3x D3x E3x F3x G3x A3x B3x C4x D4x E4x F4x G4x A4x B4x C5x D5x E5x F5x G5x A5x B5x C6x D6x E6x F6x G6x A6x B6x C7x D7x E7x F7x G7x A7x B7x C8x D8x E8x F8x G8x A8x B8x C9x D9x E9x F9x G9x A9x B9x");
			}
		};
		
		ActionListener patternSetter = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton)e.getSource();
				if (temp == pattern)
					p = setPattern(returnSong(song));
				if (temp == pattern2)
					p2 = setPattern(returnSong(song));
				if (temp == pattern3)
					p3 = setPattern(returnSong(song));
				if (temp == pattern4)
					p4 = setPattern(returnSong(song));
				if (temp == pattern5)
					p5 = setPattern(returnSong(song));
				clearSong(song);
		}
		};
		
		ActionListener patternAdder = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton temp = (JButton)e.getSource();
				if (temp == runPattern)
					song.add(addPattern(song, p));
				if (temp == runPattern2)
					song.add(addPattern(song, p2));
				if (temp == runPattern3)
					song.add(addPattern(song, p3));
				if (temp == runPattern4)
					song.add(addPattern(song, p4));
				if (temp == runPattern5)
					song.add(addPattern(song, p5));
			}
		};
		
		ActionListener harmonys = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (harmany == 0) {
					harmany = 1;
				}
				else {
					harmany = 0;
				}
			}
		};
		
//		ActionListener songSaving = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					saveFile(returnSong(song));
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		};
//		
//		ActionListener songOpener = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					song.add(openFile());
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		};
		//adding mouseListeners

		picA.addMouseListener(pickNote);
		picB.addMouseListener(pickNote);
		picC.addMouseListener(pickNote);
		picD.addMouseListener(pickNote);
		picE.addMouseListener(pickNote);
		picF.addMouseListener(pickNote);
		picG.addMouseListener(pickNote);
		restNote.addMouseListener(pickNote);
		startSong.addActionListener(songMessage);
		clearSong.addActionListener(songMessage);
		removeLast.addActionListener(songMessage);
		notesDuration.addActionListener(duration);
		ocativeBox.addActionListener(octives);
		rip.addActionListener(pianoRip);
		pattern.addActionListener(patternSetter);
		pattern2.addActionListener(patternSetter);
		pattern3.addActionListener(patternSetter);
		pattern4.addActionListener(patternSetter);
		pattern5.addActionListener(patternSetter);
		runPattern.addActionListener(patternAdder);
		runPattern2.addActionListener(patternAdder);
		runPattern3.addActionListener(patternAdder);
		runPattern4.addActionListener(patternAdder);
		runPattern5.addActionListener(patternAdder);
		harmonyButton.addActionListener(harmonys);
//		saveAFile.addActionListener(songSaving);
//		openSong.addActionListener(songOpener);
		//display the window
		f.setLocationRelativeTo(null);
		f.pack();
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String s = (String)cb.getSelectedItem();
		switch (s) {
		case "None": message.setText("Normal Notes");
		natural = 1;
		sharp = 0;
		flat = 0;
		break;
		case "Sharp": message.setText("Notes are Sharp");
		sharp = 1;
		natural = 0;
		flat = 0;
		break;
		case "Flat": message.setText("Notes are Flat");
		flat = 1;
		natural = 0;
		sharp = 0;
		}

	}
	//removes the last note added
	public void removeLast(ArrayList<String> song) {
		if (song.size() == 1) {
			song.clear();
			showThatSong.setText("");
		}
		else {
		song.remove(song.size()-1);
		String s = (String)showThatSong.getText();
		int index = s.lastIndexOf(" ");
		String s2 = s.substring(0, index);
		index = s2.lastIndexOf(" ");
		showThatSong.setText(s2.substring(0, index) + " ");
		}
	}
	//clears the song
	public void clearSong(ArrayList<String> song) {
		song.clear();
		showThatSong.setText("");
		counter = 0;
	}
	//sets a pattern
	public Pattern setPattern(String song) {
		Pattern ptemp = new Pattern(song);
		System.out.println("Pattern set as: " + song);
		return ptemp;
	}
	//returns the song as a String
	public String returnSong(ArrayList<String> song) {
		String s = "";
		for(int i = 0; i < song.size(); i++) {
			s = s + " " + song.get(i);
		}
		return s;
	}
	//adds a pattern
	public String addPattern(ArrayList<String> song, Pattern p){
		String thatPattern = p.toString();
		System.out.println(thatPattern);
		String newSong = thatPattern;
		return newSong;
	}
	
//	public void saveFile(String s) throws IOException {
//		JFrame parentFrame = new JFrame();
//		File f = new File("New Song");
//		FileWriter fw = new FileWriter(f);
//		fw.write(s);
//		JFileChooser fileChooser = new JFileChooser();
//		fileChooser.setDialogTitle("Save file");
//		int userSelection = fileChooser.showSaveDialog(parentFrame);
//		
//		if (userSelection == JFileChooser.APPROVE_OPTION) {
//			File fileToSave = fileChooser.getSelectedFile();
//			System.out.println("Save as file: " + fileToSave.getAbsolutePath());
//		}
//	}
	
//	public String openFile() throws IOException {
//		JFileChooser chooser = new JFileChooser();
//		String fileSong = "";
//		int returnVal = chooser.showOpenDialog(null);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File f = new File("song");
//			f = chooser.getSelectedFile();
//			Scanner scan = new Scanner(f);
//			fileSong = scan.nextLine();
//		}
//		return fileSong;
//	}
}

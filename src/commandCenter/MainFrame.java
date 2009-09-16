package commandCenter;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import intraController.PicCommand;
import intraController.picArgs.PicArgument;

import javax.swing.ComboBoxEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	GodsEar listener;
	JPanel panel;
	JComboBox combo;
	ArrayList<PicCommand> commands;
	Container cp;
	
	public MainFrame(GodsEar newEar, ArrayList<PicCommand> newCommands){
		panel  = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		listener = newEar;
		commands = newCommands;
		cp = getContentPane();
		cp.setLayout(new GridLayout(2,1));
		setBounds(100, 100, 200, 100);
		
		CreateUI();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void CreateUI() {

		int size = commands.size() + 1;
		String[] com = new String[size];
		com[0] = "";
		for(int i = 1; i < size; i++){
			PicCommand temp = commands.get(i-1);
			com[i] = temp.getName();
		}
		combo = new JComboBox(com);
		combo.setEditable(false);
		combo.addActionListener(listener);
		panel.add(combo);
		cp.add(panel);
	}
	
	public void changeFields(){
		setBounds(100, 100, 200, 100);
		cp.setLayout(new GridLayout(2,1));
		int index = combo.getSelectedIndex();
		cp.removeAll();
		cp.add(panel);
		if(index > 0){
			PicCommand tempCom = commands.get(index-1);
			cp.setLayout(new GridLayout(tempCom.getArguments().size()+1,1));
			Rectangle bounds = getBounds();
			int height = bounds.height + (tempCom.getArguments().size()*50);
			setBounds(bounds.x, bounds.y, bounds.width, height);
			for(PicArgument tempArg : tempCom.getArguments()){
				cp.add(tempArg.createArgumentInputPanel());
			}
		}
		repaint();			
		setVisible(true);
	}

}

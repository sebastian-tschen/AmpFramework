package commandCenter;

import intraController.InvalidArgumentValueException;
import intraController.PicCommand;
import intraController.picArgs.PicArgument;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	GodsEar listener;
	JPanel panel;
	JComboBox combo;
	Collection<PicCommand> commands;
	Container cp;

	public MainFrame(GodsEar newEar, Collection<PicCommand> newCommands) {
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		listener = newEar;
		commands = newCommands;
		cp = getContentPane();
		cp.setLayout(new FlowLayout(FlowLayout.LEFT));
		//setBounds(100, 100, 200, 100);

		CreateUI();

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void CreateUI() {

		// int size = commands.size() + 1;
		// HashSet<String> com = new HashSet<String>;
		//		
		// for(int i = 1; i < size; i++){
		// PicCommand temp = commands.t.get(i-1);
		// com[i] = temp.getName();
		// }

		// ich glaub es is besser wenn man tatsaechlich die objekte in die kombo
		// box packt... dann is das nachher viel einfacher zu handeln, und man
		// muss nich von dem string der in der kombo box steht wieder irgendwie
		// auf das PicCommand objekt kommen. Nur die toString methode muss man
		// warscheinlich ueberlagern, dass er was nettes anzeigt.
		combo = new JComboBox(commands.toArray());
		combo.setEditable(false);
		combo.addActionListener(listener);
		panel.add(combo);
		
		JButton gibbim = new JButton("Gibbim");
		gibbim.addActionListener(listener);
		panel.add(gibbim);
		
		cp.add(panel);

	}

	public void changeFields() {
		// hab Strings in die Combo box gepackt... kriegt man ueber item
		// wieder... alles in allem erheblich einfacher zu handeln denk ich
		//setBounds(100, 100, 200, 100);
		//cp.setLayout(new GridLayout(1, 1));
		Object selectedCommand = combo.getSelectedItem();
		cp.removeAll();
		cp.add(panel);
		if (selectedCommand != null) {
			PicCommand tempCom = (PicCommand) selectedCommand;
			//cp.setLayout(new GridLayout(tempCom.getArguments().size() + 1, 1));
			Rectangle bounds = getBounds();
			int height = bounds.height + (tempCom.getArguments().size() * 50);
			//setBounds(bounds.x, bounds.y, bounds.width, height);
			for (PicArgument tempArg : tempCom.getArguments()) {
				cp.add(tempArg.createArgumentInputPanel());
			}
		}
		pack();
		repaint();
		setVisible(true);
	}

	public void sendBytes() {
		Object selectedCommand = combo.getSelectedItem();
		PicCommand tempCom = (PicCommand) selectedCommand;
		for (PicArgument tempArg : tempCom.getArguments()) {
			try{
				tempArg.parseInput(new Object());
			}
			catch(InvalidArgumentValueException e){
				System.out.println("I will ned");
			}
		}
	}

}

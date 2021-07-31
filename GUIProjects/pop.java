import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class pop extends JFrame {
	StringBuilder sb;
	Files file;
	JTextArea txt;
	List<String> list;
	
	public pop(Details d, String alcname) {
		JPanel poppnl = new JPanel();
		poppnl.setLayout(new BoxLayout(poppnl, BoxLayout.Y_AXIS));
		setTitle("수정할 내용");
		txt = new JTextArea(30, 30);

		JButton okbtn = new JButton("확인");
		JButton xbtn = new JButton("취소");

		
		file = new Files();
		String st = file.editLoad(alcname);
		txt.setText(st);
		
		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sb = new StringBuilder();
				sb.append(txt.getText().toString());
				file.editSave(txt.getText(), alcname);
				d.ta.setText(txt.getText());
				dispose();
			}
		});
		xbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				pop.this.dispose();
			}
		});

//		txt = (JTextArea) file.editLoad();
		poppnl.add(txt);
		poppnl.add(okbtn);
		poppnl.add(xbtn);

		add(poppnl);

		pack();
		setLocation(200, 150);
		setVisible(true);

	}
}

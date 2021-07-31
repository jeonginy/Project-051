import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class IdSearch extends JDialog {
	private Files io;
	public IdSearch() throws ParseException {
		io = new Files();		
		//전체 값이 다들어있는 거
		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
		
		JPanel pnlN = new JPanel();
		JLabel lblN = new JLabel("Phone Number");
//		JTextField tfN = new JTextField(15);
		MaskFormatter formatterPhone = new MaskFormatter("010-####-####");
		formatterPhone.setPlaceholderCharacter('ㅁ');
//		JLabel lblPN = new JLabel("연락처");
		
		JFormattedTextField tfN = new JFormattedTextField(formatterPhone);
		pnlN.add(lblN);
		pnlN.add(tfN);
		
		
		JPanel btnpnl = new JPanel();
		JButton btnOK = new JButton("찾기");
		
		btnOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> inFor = new ArrayList<>();
				inFor = io.load();
				//infor에 한 줄에 들어있는 정보를 ,로 잘라서 보관해줄 곳
				String [] getinFor = new String[3];
				//폰넘버만 넣을 곳
				String [] getPN = new String[inFor.size()];
				//아이디만 넣을 곳
				String [] getID = new String[inFor.size()];
				
				//getPN에 폰넘버가 저장되게하는 for문
				for (int i = 0; i < getPN.length; i++) {
					getinFor = inFor.get(i).split(",");
					getPN[i] = getinFor[2];
					getID[i] = getinFor[0];
				}
				String id = null;
				for (int i = 0; i < getPN.length; i++) {
					if(tfN.getText().equals(getPN[i])) {
						id = getID[i];
						JOptionPane.showMessageDialog(IdSearch.this, "아이디 : "+ id );
						break;
					} /*else if (!tfN.getText().equals(getPN[i])){
						JOptionPane.showMessageDialog(IdSearch.this, "일치하지 않습니다.");
						break;
					}*/
				}
				
			}
		});
		//스트림의 흐름을 한방향만 있음. 전체를 새로 작성.
		btnpnl.add(btnOK);
		
		add(pnlN);
		add(btnpnl, "South");
		
		
		
		showGUI();
	}

	private void showGUI() {
		setModal(true);
		pack();
		setVisible(true);
	}
		

}


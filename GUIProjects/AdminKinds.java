import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
class AdminKinds extends JFrame {
	Files file;
	HashMap<String, ImageIcon> alcohol;
	JPanel alchap;
	List<JPanel> list;

	public AdminKinds(String iD) {
		// load the information
		// main panel
		JPanel mainpnl = new JPanel();
		setTitle("Alcohol World");
		mainpnl.setLayout(new BoxLayout(mainpnl, BoxLayout.Y_AXIS));
		// name panel
		JPanel whopnl = new JPanel();
		JLabel wholbl = new JLabel();
		whopnl.add(wholbl);
		// 술 판넬
		JPanel kindpnl = new JPanel();
		JLabel kindlbl = new JLabel("Alcohol's World 술 도감");
		kindpnl.add(kindlbl);
		// 술 이름과 사진 레이블 같이 붙일 판
		alchap = new JPanel();
		alchap.setLayout(new GridLayout(0, 5));
		// 파일 생성 후, addInforAlc에서 사용할 것
		file = new Files();
		addInforAlc(iD);
		// 술 추가 버튼
		JPanel addpnl = new JPanel();
		JButton addalcbtn = new JButton("ෆ◟̊◞̊ෆ 나만의 술 추가 하기 ෆ◟̊◞̊ෆ");
		JButton acceptbtn = new JButton("확인");
		JButton logoutbtn = new JButton("로그아웃");
		
		addpnl.add(addalcbtn);
		addpnl.add(acceptbtn);
		addpnl.add(logoutbtn);
		
		addalcbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new AdminWindows(AdminKinds.this, iD);
			}
		});

		acceptbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new confirmWindows(AdminKinds.this, iD);
			}
		});
		
		logoutbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Main();
			}
		});
		mainpnl.add(whopnl);
		mainpnl.add(kindpnl);
		mainpnl.add(alchap);
		mainpnl.add(addpnl);
		add(mainpnl);
		showGUI();
	}
	
	public void addInforAlc(String iD) {
		alchap.removeAll(); // 기존에 있던 거를 모두 지우고
		alcohol = file.imageLoad(); // 이미지를 다시 불러들이기 (위에 파일 미리 선언한 이유)
		Set<String> keySet = alcohol.keySet(); // key값을 가져오기 위한 변수 선언
		Iterator<String> iterator = keySet.iterator(); // key는 set의 형식으로 돼있고, iterator로 원소를 하나씩 뽑아옴
		list = new ArrayList<JPanel>();
		
		for (int i = 0; i < alcohol.size(); i++) {

			JPanel alcpnl = new JPanel();
			alcpnl.setLayout(new BoxLayout(alcpnl, BoxLayout.Y_AXIS));
			String key = iterator.next(); // 키 값가져오기
			ImageIcon value = alcohol.get(key); // value값 가져오기
			Image scale = value.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);

			JLabel textlbl = new JLabel(key);
			JLabel imglbl = new JLabel(new ImageIcon(scale));

			alcpnl.add(textlbl);
			alcpnl.add(imglbl);
			alchap.add(alcpnl);
			list.add(alcpnl);
		}

		alchap.revalidate();
		alchap.repaint();

		for (int i = 0; i < list.size(); i++) {
			list.get(i).addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel tmpClick = (JPanel) e.getSource();
					JLabel lbl = new JLabel();
					lbl = (JLabel) tmpClick.getComponent(0);	
					String alcname = lbl.getText();
					new Details(iD, alcname);
				}
			});
		}
	}

	private void showGUI() {
		pack();
		setBackground(Color.WHITE);
		setLocation(650, 350);
		setVisible(true);
	}

}
class Details extends JDialog {
	JTextField nametf;
	Files file;
	JTextArea ta ;
	public Details(String iD, String alcname) {
		JPanel pnl = new JPanel();
		setTitle("알술도감");
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));
		ta = new JTextArea(30, 30);
		JPanel btnpnl = new JPanel();
		
		JButton editbtn = new JButton("수정");
		JButton confirmbtn = new JButton("적용");
		
		JLabel lbl = new JLabel("도움을 준 회원님들 [ " + iD + " ]");
		
		file = new Files();
//		file.editSave(ta.getText());
		String st = file.editLoad(alcname);
		ta.setText(st);
		
		editbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new pop(Details.this, alcname);
			}
		});
		confirmbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnpnl.add(editbtn);
		btnpnl.add(confirmbtn);
		btnpnl.add(lbl);
		
		pnl.add(ta);
		pnl.add(btnpnl);
		
		add(pnl);

		pack();
		setLocation(450, 300);
		setVisible(true);
	}

}

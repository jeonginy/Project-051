import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
/* 좋아하는 술 추가하기 버튼 
 * 저장 버튼 눌렸을 때 1) 관리자에게 술 추가 요청할거라는 창 띄우기	
 * 					   2) 새폴더에 사용자가 저장한 내용 저장하기 
 */
class UserKinds extends JDialog {
	Files file;	//	Files클라스 변수 
	JLabel imagelbl = new JLabel();
	JTextField idtf;	// 아이디 필드 
	HashMap<String, ImageIcon> alcohol;	//	술 이름, 이미지 들어갈 곳
	JPanel alchap;	//	술이 붙혀질 전체적인 판 

	// load the information
	public UserKinds() {
		JPanel mainpnl = new JPanel();
		setModal(true);
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
		addInforAlc();
		// 술 추가 버튼
		JPanel addpnl = new JPanel();
		JButton addalcbtn = new JButton("ෆ◟̊◞̊ෆ 나만의 술 추가 하기 ෆ◟̊◞̊ෆ");
		JButton logoutbtn = new JButton("로그아웃");
		addpnl.add(addalcbtn);
		
		addalcbtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new UserWindows(UserKinds.this);
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

	public void addInforAlc() {
		alchap.removeAll(); // 기존에 있던 거를 모두 지우고
		alcohol = file.imageLoad(); // 이미지를 다시 불러들이기 (위에 파일 미리 선언한 이유)
		Set<String> keySet = alcohol.keySet(); // key값을 가져오기 위한 변수 선언
		Iterator<String> iterator = keySet.iterator(); // key는 set의 형식으로 돼있고, iterator로 원소를 하나씩 뽑아옴
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
		}

		alchap.revalidate();
		alchap.repaint();

	}

	private void showGUI() {
		pack();
		setBackground(Color.WHITE);
		setLocation(650, 350);
		setVisible(true);
	}
}
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
class AdminWindows extends JDialog {
	static JTextField nametf;
	JLabel imagelbl;
	String filePath;
	Files f;
	File file;
	public AdminWindows(AdminKinds a, String iD) {
		JPanel pnl = new JPanel();
		setModal(true);
		setTitle("Alcohol World");
		
		nametf = new JTextField(15);

		pnl.setBackground(Color.white);
		pnl.setLayout(new FlowLayout());
		pnl.add(nametf);
		
		
		imagelbl = new JLabel(" 사진 ");
		pnl.add(imagelbl);

		JPanel btnpnl = new JPanel();
		JButton loadbtn = new JButton("불러오기");
		JButton savebtn = new JButton("저장하기");
		// 불러오기 버튼을 눌렸을 때 발생하는 행동
		loadbtn.addActionListener(new ActionListener() {
			JFileChooser choice = new JFileChooser();
			@Override
			public void actionPerformed(ActionEvent e) {
				// 확장자를 걸러주는 변수
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images OLNY", "jpg", "gif");
				// 선택된 파일에 필터 적용하기
				choice.setFileFilter(filter);
				// 선택됐을 때 다이얼로그 띄우기
				int result = choice.showOpenDialog(null);
				if (result != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택해주세요", "주의", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (result == JFileChooser.APPROVE_OPTION) {
					file = choice.getSelectedFile(); // 선택된 파일 담기
					BufferedImage bi = getImage(file); // getImage메소드에 선택된 파일 담아서 이미지로 변환하기
					Image scale = bi.getScaledInstance(80, 80, Image.SCALE_DEFAULT); // adjust the image scale
					imagelbl.setIcon((new ImageIcon(scale))); // 이미지 레이블에 크기 조정한 이미지 넣기
					imagelbl.setText("");
					pack();
				}
			}

			// to change file to image : 파일 받아서 이미지로 변환하기
			private BufferedImage getImage(File file) {
				BufferedImage bi = null;
				try {
					// 이미지 ImgaeIO로 파일 읽고, 이미지로 변환시켜 참조
					bi = ImageIO.read(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return bi;
			}
		});
		// 저장 버튼을 눌렸을 때 발생하는 행동
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 파일 생성
				try {
					// 술 이름이 적힌 내용과 파일을 받아서 txt 생성하고, 폴더를 생성하도록 함 -> 이미지 가져오기까지 하는 메서드
					f = new Files();
					f.imageSave(nametf.getText(), file);
					HashMap<String, ImageIcon> result = f.imageLoad(); // 이름, 이미지를 받아와서 참조
					a.addInforAlc(iD); // 기존에 잇던 사진들을 지우고 추가된 것들을 덧붙여서 업로드 시킴(HashMap key, value)
					a.pack();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnpnl.add(loadbtn);
		btnpnl.add(savebtn);

		add(pnl);
		add(btnpnl, "South");
//		pack();
		setSize(300,100);
		setBackground(Color.white);
		setLocation(650, 350);
		setVisible(true);
	}

}

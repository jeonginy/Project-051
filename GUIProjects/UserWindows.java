import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
public class UserWindows extends JDialog {
	File file;	//	파일 변수 
	JTextField nametf;	//	술 이름 변수 	
	JLabel imagelbl;	//	술 이미지 변수 	
	Files f;		//	Files 클라스 변수 
	public UserWindows(UserKinds u) {
		JPanel mainpnl = new JPanel();
		setModal(true);
		setTitle("ෆ◟̊◞̊ෆ 나만의 술 추가 하기 ෆ◟̊◞̊ෆ");
		nametf = new JTextField(15);
		mainpnl.setBackground(Color.white);
		mainpnl.setLayout(new FlowLayout());
		mainpnl.add(nametf);
		imagelbl = new JLabel(" 사진 ");
		mainpnl.add(imagelbl);
		JPanel btnpnl = new JPanel();
		JButton loadbtn = new JButton("불러오기");
		JButton savebtn = new JButton("저장하기");

		loadbtn.addActionListener(new ActionListener() {
			JFileChooser chooser = new JFileChooser();

			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF ONLY", "jpg", "gif");
				chooser.setFileFilter(filter);

				int values = chooser.showOpenDialog(null);
				if (values != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택해주세요", "주의", JOptionPane.WARNING_MESSAGE);
					return;
				} else if (values == JFileChooser.APPROVE_OPTION) {
					file = chooser.getSelectedFile();
					BufferedImage bi = getImage(file);
					Image scale = bi.getScaledInstance(80, 80, Image.SCALE_DEFAULT); // adjust the image scale
					imagelbl.setIcon((new ImageIcon(scale)));
					imagelbl.setText("");
					pack();
				}
			}
			private BufferedImage getImage(File file) {
				BufferedImage bi = null;		//	이미지를 읽어들일 클래스
				try {
					bi = ImageIO.read(file);		//	ImageIO를 이용해 받아온 파일 읽고 이미지로 변환 
				} catch (IOException e) {
					e.printStackTrace();
				}
				return bi;
			}
		});
		savebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Files();
				f.userSave(nametf.getText(), file);	//	젹힌 술 이름과 선언했던 파일 파라미터로 받아오기 
				// 술 이름이 적힌 내용과 파일을 받아서 txt 생성하고, 폴더를 생성하도록 함 -> 이미지 가져오기까지 하는 메서드
				JOptionPane.showMessageDialog(mainpnl, "검토 후 추가 예정입니다.\n잠시만 기다려 주세요\nᕕ( ᐛ )ᕗ");
			}
		});

		btnpnl.add(loadbtn);
		btnpnl.add(savebtn);
		add(mainpnl);
		add(btnpnl, "South");
//		setSize(300,100);
		pack();
		setBackground(Color.white);
		setLocation(650, 350);
		setVisible(true);
	}
}

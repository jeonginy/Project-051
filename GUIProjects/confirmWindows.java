import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class confirmWindows extends JFrame {
	Files f;
	HashMap<String, ImageIcon> list;
	File file;

	public confirmWindows(AdminKinds k, String iD) {
		AdminWindows a = new AdminWindows(k, iD);
		f = new Files();

		JPanel pnl = new JPanel();
		setTitle("확인창");
		pnl.setLayout(new BoxLayout(pnl, BoxLayout.Y_AXIS));

		JPanel ac = new JPanel();

		JLabel lbl = new JLabel("확인하실 내용 :");
		pnl.add(lbl);

		list = f.userImageLoad();

//		Iterator<String> name = list.keySet().iterator();		//	이름을 담을 순회 그릇 
//		while(name.hasNext()) {
//			String names = name.next();
//			list.get(name);
//		}
		// entry로 순회 후, 값 뽑기
		for (Entry<String, ImageIcon> entry : list.entrySet()) {
			String key = entry.getKey();
			ImageIcon value = entry.getValue();

			JLabel addedlbl = new JLabel(key);
			JLabel addedimglbl = new JLabel(value);

			pnl.add(addedlbl);
			pnl.add(addedimglbl);

		}

		JButton okbtn = new JButton("허용");

		ac.add(okbtn);

		okbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 술 이름이 적힌 내용과 파일을 받아서 txt 생성하고, 폴더를 생성하도록 함 -> 이미지 가져오기까지 하는 메서드
					f = new Files();
					for (Entry<String, ImageIcon> entry : list.entrySet()) {
						String key = entry.getKey();
						file = new File("./confirm/" + key + ".jpg");

						f.imageSave(key, file);
						k.addInforAlc(iD); // 기존에 잇던 사진들을 지우고 추가된 것들을 덧붙여서 업로드 시킴(HashMap key, value)
						k.pack();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
		});

		add(ac, "South");
		add(pnl);

		showGUI();

	}

	private void showGUI() {
		pack();
//		setSize(300,300);
		setLocation(350, 250);
		setBackground(Color.white);
		setVisible(true);
	}
}

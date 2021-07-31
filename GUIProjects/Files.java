import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Files {
	static final String INFOR = "information.txt"; // text file having ID, Password
	static final String ALCOHOL = "Alcohol.txt"; // 술 이름만 저장돼있는 txt
	static final String ADD_FOLDER = "addAlcohol.txt"; // 사용자가 저장했을 때 만들어질 파일
	static final String EDIT = "edit.txt";

	// using ID, Password
	void save(String name, String password, String phoneNumber) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(INFOR, true));
			pw.print(name + ",");
			pw.print(password+ ",");
			pw.println(phoneNumber);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
//  ======================================================================================================================
	// load information
	public List<String> load() {
		BufferedReader br = null;
		List<String> list = new ArrayList<>(); // a list for User and Administer's information
		try {
			br = new BufferedReader(new FileReader(INFOR));
			String line;
			while ((line = br.readLine()) != null) {
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
//  ======================================================================================================================
	public List<String> searchbye(String line) {
		BufferedReader br = null;
		List<String> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(INFOR));
			String bye;
			while((bye = br.readLine()) != null) {
				if(line.equals(bye)) {
				}else
					list.add(bye);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
//  ======================================================================================================================
	public void infsave(List<String> list) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(INFOR));
			for (int i = 0; i < list.size(); i++) {
				String[] getInf = list.get(i).split(",");
				String getId = getInf[0];
				String getPw = getInf[1];
				String getPn = getInf[2];
				pw.print(getId + ",");
				pw.print(getPw + ",");
				pw.println(getPn);
			}
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}
//  ======================================================================================================================
	public void imageSave(String name, File file) throws IOException {

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(ALCOHOL, true));
			pw.println(name);
			pw.flush();

		} catch (IOException e1) {
			e1.printStackTrace(); 
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
//  ======================================================================================================================

		String path = "./" + name;
		File folder = new File(path);
		if (!folder.exists()) { // Alcohol에 저장돼있는 이름의 폴더 생성
			folder.mkdir();
		}

//  ======================================================================================================================

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(path + "/picture.jpg");
			bos = new BufferedOutputStream(fos);

			int length = 0;
			byte[] buffer = new byte[(int) file.length()];

			while ((length = bis.read(buffer, 0, (int) file.length())) != -1) {
				bos.write(buffer, 0, (int) file.length());
			}
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (bis != null && bos != null && fis != null && fos != null) {
				bis.close();
				bos.close();
				fis.close();
				fos.close();
			}
		}
	}
//  ======================================================================================================================

	public HashMap<String, ImageIcon> imageLoad() {
		BufferedReader br = null;
		HashMap<String, ImageIcon> list = new HashMap<String, ImageIcon>();

		try {
			// 읽을 파일 가져오기
			br = new BufferedReader(new FileReader(ALCOHOL));
			String line;
//			한 줄씩 읽고 이미지랑 같이 넣기 
			while ((line = br.readLine()) != null) {
				ImageIcon image = new ImageIcon("./" + line + "/picture.jpg");
				list.put(line, image);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
 
	public void userSave(String name, File file) {
		// get ready to write what to want : declared PrintWriter
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(ADD_FOLDER, true)); // 저장하고 싶은 파일 이름
			pw.println(name); // 적혀질 술 이름 적기
			pw.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
		String path = "./confirm"; // 새로 만들어질 폴더 경로 정하기
		File folder = new File(path); // 파일 클래스로 정해진 경로에 파일 생성
		if (!folder.exists()) { // Alcohol에 저장돼있는 이름의 폴더 생성
			folder.mkdir();
		}

		FileInputStream fis = null; // 파일을 적고 뽑아내기 위해 써야되는 순서
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;

		try {
			fis = new FileInputStream(file); // 받아온 파일을 만들고
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream(path + "/" + name + ".jpg"); // 경로 + 술이름.jpg로 만들어서 뽑기
			bos = new BufferedOutputStream(fos);
			// 받아온 사진파일을 이미지로 변환시켜서 파일 안에 담기
			int length = 0;
			byte[] buffer = new byte[(int) file.length()];
			while ((length = bis.read(buffer, 0, (int) file.length())) != -1) {
				bos.write(buffer, 0, (int) file.length());
			}
			bos.flush();
		} catch (IOException f) {
			f.printStackTrace();
		} finally {
			if (bis != null && bos != null && fis != null && fos != null) {
				try {
					bis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public HashMap<String, ImageIcon> userImageLoad() {
		BufferedReader br = null;
		HashMap<String, ImageIcon> list = new HashMap<String, ImageIcon>();

		try {
			// 읽을 파일 가져오기
			br = new BufferedReader(new FileReader(ADD_FOLDER));
			String line;
//			한 줄씩 읽고 이미지랑 같이 넣기 
			while ((line = br.readLine()) != null) {
				ImageIcon image = new ImageIcon("./confirm/" + line + ".jpg");
				list.put(line, image);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	void editSave(String file, String alcname) {
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(new FileWriter("./" + alcname + "/" + EDIT));
			pw.print(file);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

	String editLoad(String alcname) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("./" + alcname + "/" + EDIT));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		return sb.toString();
	}
}













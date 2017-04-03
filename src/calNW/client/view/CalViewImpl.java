package calNW.client.view;

import java.util.*;
import java.io.*;
import java.net.*;
import calNW.server.controller.*;
import calNW.server.exception.*;
import calNW.server.vo.*;

public class CalViewImpl implements ICalView {
	private CalController cc;
	private Properties prop;
	private List list;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public CalViewImpl(CalView cv) {
		cc = new CalController(cv);
	}
	
	public void doService() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("src\\calNW\\client\\file\\input.txt"));
			Socket s = new Socket("127.0.0.1", 5419); //��Ĺ�����Ͽ� �������Ͽ� ���� ��û
			
			try {
				oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(prop); //OutputStream�� �����Ͽ� input.txt�� �����͸� Socket�� ����. //������ ������ Data
				oos.flush();

				ois = new ObjectInputStream(s.getInputStream());
				
				Object obj = ois.readObject();
				List list = (List) obj;
				if (list.get(2) instanceof ArrayList) {
					List<String[]> resultList = (List<String[]>) list.get(2);
					report(resultList);
				} else {
					String msg = (String) list.get(2);
					errReport(msg);
				}
			} finally {
				if(s != null && ois != null && oos != null) {
					ois.close();
					oos.close();
					s.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("������ ������ ã�� �� �����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void report(List<String[]> resultList) {	
		for(String[] result : resultList) {
			System.out.println(Arrays.toString(result));
		}
	}
	
	public void errReport(String msg) {
		System.out.println(msg);
	}
}

/*
if(args.length !=1) {
			System.out.println("USAGE: java TestCal INPUTFILENAME");
		} else {
			String inputFile = args[0];

for(int i=0; i<cals.length; i++) {
System.out.println("e"+(i+1)+"=" + cals[i].getResult());
}
*/
package tuan2_74_ThongTinNhanVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoredData {
	//lưu đối tượng Object vào tệp tin tại đường dẫn được lưu trong biến path.
	public boolean saveFile(Object obj, String path) throws Exception, IOException {		
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	//đọc đối tượng Object từ tệp tin tại đường dẫn được lưu trong biến path.
	public Object loadFile(String path) throws Exception, IOException
	{
		ObjectInputStream ois= new ObjectInputStream(new FileInputStream(path));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}

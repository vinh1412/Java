package tuan2_74_ThongTinNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String url = "D:\\\\HK2-NAM2\\\\LAPTRINHHSK\\\\xml\\\\nhanvien.xml";
	private ArrayList<NhanVien> dsNV;

	public NhanVien_Collection() {
		dsNV= new ArrayList<NhanVien>();
	}
	
	/**
	 * Thêm nhân viên nv vào danh sách
	 * @param nv
	 * @return
	 */
	public boolean themNhanVien(NhanVien nv) {
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	/**
	 * Xóa nhân viên theo mã nhân viên
	 * @param maNV
	 * @return
	 */
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	 /**
	  * Tìm kiếm nhân viên theo mã nhân viên
	  * @param maNV
	  * @return
	  */
	public NhanVien timkiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));		
		return null;
	}

	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}

	public ArrayList<NhanVien> getDsNV(){
		return dsNV;
	}
	
	 public NhanVien getElement(int index) {
		 if(index<0 || index>this.getSize())
			 return null;
		 return dsNV.get(index);
	 }
	public int getSize() {
		return dsNV.size();
	}
}

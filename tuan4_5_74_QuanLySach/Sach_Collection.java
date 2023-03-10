package tuan4_5_74_QuanLySach;

import java.util.ArrayList;

public class Sach_Collection {
	private ArrayList<Sach> dsSach;

	public Sach_Collection() {
		dsSach= new ArrayList<Sach>();
	}
	
	
	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}


	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	

	/**
	 * Thêm sách
	 * @param sach
	 * @return
	 */
	public boolean themSach(Sach sach) {
		if(dsSach.contains(sach))
			return false;
		dsSach.add(sach);
		return true;
	}
	/**
	 * Xóa sách theo mã
	 * @param maSach
	 * @return
	 */
	public boolean xoaSach(String maSach) {
		Sach sach= new Sach(maSach);
		if(dsSach.contains(sach)) {
			dsSach.remove(sach);
			return true;
		}
		return false;
	}
	
	public Sach timKiemTheoMaSach(String maSach) {
		Sach sach= new Sach(maSach);
		if(dsSach.contains(sach))
			return dsSach.get(dsSach.indexOf(sach));
		return null;
	}
	public int getSize() {
		return dsSach.size();
	}
	public Sach getElement(int index) {
		if(index<0 || index>this.getSize()) {
			return null;
		}
		return dsSach.get(index);
	}
}

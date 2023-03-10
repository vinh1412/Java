package tuan4_5_74_QuanLySach;

public class Sach {
	private String maSach;
	private String tuaSach;
	private int namSX;
	private int soTrang;
	private String ISBN;
	private String tacGia;
	private String nhaXuatBan;
	private double donGia;
	
	
	public Sach(String maSach) {
		this.maSach="";
	}
	public Sach() {
		this("","",0,0,"","","",0);
	}
	public Sach(String maSach, String tuaSach, int namSX, int soTrang, String iSBN, String tacGia, String nhaXuatBan,
			double donGia) {
		setMaSach(maSach);
		setTuaSach(tuaSach);
		setNamSX(namSX);
		setSoTrang(soTrang);
		setISBN(iSBN);
		setTacGia(tacGia);
		setNhaXuatBan(nhaXuatBan);
		setDonGia(donGia);
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTuaSach() {
		return tuaSach;
	}
	public void setTuaSach(String tuaSach) {
		this.tuaSach = tuaSach;
	}
	public int getNamSX() {
		return namSX;
	}
	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getNhaXuatBan() {
		return nhaXuatBan;
	}
	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tuaSach=" + tuaSach + ", namSX=" + namSX + ", soTrang=" + soTrang
				+ ", ISBN=" + ISBN + ", tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + ", donGia=" + donGia + "]";
	}
	
	
}

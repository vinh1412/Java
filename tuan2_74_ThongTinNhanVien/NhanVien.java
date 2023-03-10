package tuan2_74_ThongTinNhanVien;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private Boolean phai;
	private double luong;

	public NhanVien(String maNV) {
		this.maNV = maNV;
	}

	public NhanVien() {
	}

	public NhanVien(String maNV, String hoNV, String tenNV, int tuoi, Boolean phai, double luong) {
		setMaNV(maNV);
		setHoNV(hoNV);
		setTenNV(tenNV);
		setPhai(phai);
		setTuoi(tuoi);
		setLuong(luong);
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		if (maNV.trim().equals("")) {
			this.maNV = "Không xác định";
		} else {
			this.maNV = maNV;
		}
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		if (hoNV.trim().equals("")) {
			this.hoNV = "Không xác định!";
		} else {
			this.hoNV = hoNV;
		}
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		if (tenNV.trim().equals("")) {
			this.tenNV = "Không xác định";
		} else {
			this.tenNV = tenNV;
		}
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		if (tuoi > 0) {
			this.tuoi = tuoi;
		} else {
			this.tuoi = -1;
		}
	}

	public Boolean getPhai() {
		return phai;
	}

	public void setPhai(Boolean phai) {
		this.phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		if (luong > 0) {
			this.luong = luong;
		} else {
			this.luong = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", luong=" + luong + "]";
	}

}

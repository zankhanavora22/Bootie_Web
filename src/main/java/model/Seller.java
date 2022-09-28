package model;

public class Seller {
		private int id;
		private String name;
		private String address;
		private String email;
		private String password;
		private long mobile_no;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public long getMobile_no() {
			return mobile_no;
		}
		public void setMobile_no(long mobile_no) {
			this.mobile_no = mobile_no;
		}
		@Override
		public String toString() {
			return "Seller [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", password="
					+ password + ", mobile_no=" + mobile_no + "]";
		}
		
		
		
}

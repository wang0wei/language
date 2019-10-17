package service;

public class User {
		private int id;
		private String name;
		private String pwd;
		private String email;
		private int is_push;
		
	    public User(int id, String name, String pwd, String email, int is_push) {
			super();
			this.id = id;
			this.name = name;
			this.pwd = pwd;
			this.email = email;
			this.is_push = is_push;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public int getIs_push() {
			return is_push;
		}
		public void setIs_push(int is_push) {
			this.is_push = is_push;
		}
		
		public User() {
		
		}
		public User(int id, String name, String pwd, int is_push) {
			super();
			this.id = id;
			this.name = name;
			this.pwd = pwd;
			this.is_push = is_push;
		}
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
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
}

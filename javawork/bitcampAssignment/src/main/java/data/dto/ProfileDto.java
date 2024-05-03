package data.dto;

public class ProfileDto {
	private String pnum;
	private String name;
	private String email;
	private String username;
	private String password;
	private String introduce;
	private String profilephoto;
	
	public ProfileDto() {
		super();
	}

	public ProfileDto(String name, String email, String username, String password, String introduce,
			String profilephoto) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.introduce = introduce;
		this.profilephoto = profilephoto;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getProfilephoto() {
		return profilephoto;
	}

	public void setProfilephoto(String profilephoto) {
		this.profilephoto = profilephoto;
	}
	
	
	
}


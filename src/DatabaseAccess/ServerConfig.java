package DatabaseAccess;

public class ServerConfig {
	public ServerConfig(String sname,int sport, String uname, String pwd) {
		servername = sname;
		username = uname;
		port  = sport;
		password = pwd;
		
	}
	private String servername;
	private String username;
	private int port;
	private String password;

	public String getServerName() {
		return servername;
	}
	public String getUserName() {
		return username;
	}
	public int getPort() {
		return port;
	}
	public String getPassword() {
		return password;
	}
}
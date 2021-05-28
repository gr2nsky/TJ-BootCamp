package com.javalec.db;

public class ConnectInfo {
	
	final String ipAddress = "172.30.1.1";
	final String url_mysql = "jdbc:mysql://" + ipAddress + "/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	final String id_mysql = "root";
	final String pw_mysql = "1q2w3e4r";
	
	public String getIpAddress() {
		return ipAddress;
	}
	public String getUrl_mysql() {
		return url_mysql;
	}
	public String getId_mysql() {
		return id_mysql;
	}
	public String getPw_mysql() {
		return pw_mysql;
	}
	
}

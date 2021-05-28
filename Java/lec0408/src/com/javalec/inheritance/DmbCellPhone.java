package com.javalec.inheritance;

public class DmbCellPhone extends CellPhone{
	
	public int channel;
	
	public DmbCellPhone() {
		
	}
	
	public DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	public void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB방송 수신 시작합니다.");
	}

	public void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번으로 바꿉니다.");		
	}
	
	public void turnOffDmb() {
		System.out.println("DMB방송 수신을 멈춥니다.");
	}
	
}

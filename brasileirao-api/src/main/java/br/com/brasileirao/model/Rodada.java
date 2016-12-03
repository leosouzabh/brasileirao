package br.com.brasileirao.model;

import java.util.Date;

public class Rodada {
	
	private Integer rodada;	
	private TimeRodada timeA;
	private TimeRodada timeB;	
	private Date data;
	private String local;
	
	public Rodada(Integer rodada, String timeA, String timeB, Date data, String local) {
		this.rodada = rodada;
		this.timeA = new TimeRodada(timeA, 0);
		this.timeB = new TimeRodada(timeB, 0);
		this.data = data;
		this.local = local;
	}
	public TimeRodada getTimeA() {
		return timeA;
	}
	public void setTimeA(TimeRodada timeA) {
		this.timeA = timeA;
	}
	public TimeRodada getTimeB() {
		return timeB;
	}
	public void setTimeB(TimeRodada timeB) {
		this.timeB = timeB;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Integer getRodada() {
		return rodada;
	}
	public void setRodada(Integer rodada) {
		this.rodada = rodada;
	}
	
		
}

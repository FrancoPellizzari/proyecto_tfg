package com.edix.eventos.dto;

import java.io.Serializable;

public class LineaReservaDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	
	private int idReserva;
	private int cantidad;
	private double precioVenta;
	
	
	public int getIdProducto() {
		return idReserva;
	}
	public void setIdProducto(int idReserva) {
		this.idReserva = idReserva;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

}


package com.diegodev.dslist.projections;

//interface para eu chamar na minha consulta sql

public interface GameMinProjection {
	//preciso colocar metodos gets correspondente a minha consulta
	
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}

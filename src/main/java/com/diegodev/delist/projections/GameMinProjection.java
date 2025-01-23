package com.diegodev.delist.projections;

//para que a consulta sql personalizada funcione preciso criar uma interface contendo os metodos
//getters que contem na consulta, se não criar não funciona
public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}

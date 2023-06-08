package com.crud.javashastra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int id;
	@Column
	String movieName;
	@Column
	String movieAuthor;
	@Column
	String moviePublication;
	@Column
	String movieConsole;
	@Column
	int movieDate;
	@Column
	float moviePrice;
	@ManyToOne
	@JoinColumn(name="genre_id")
	Genre genre;
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getMovieAuthor() {
		return movieAuthor;
	}
	public void setMovieAuthor(String movieAuthor) {
		this.movieAuthor = movieAuthor;
	}
	public String getMoviePublication() {
		return moviePublication;
	}
	public void setMoviePublication(String moviePublication) {
		this.moviePublication = moviePublication;
	}
	public int getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(int movieDate) {
		this.movieDate = movieDate;
	}
	public String getMovieConsole() {
		return movieConsole;
	}
	public void setMovieConsole(String movieConsole) {
		this.movieConsole = movieConsole;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public float getMoviePrice() {
		return moviePrice;
	}
	public void setMoviePrice(float moviePrice) {
		this.moviePrice = moviePrice;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	@Override
    public String toString() {
        return movieName; // 
    }
	
	
}

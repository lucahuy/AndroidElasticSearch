package ca.ualberta.ssrg.movies.es;

import java.util.ArrayList;

import ca.ualberta.ssrg.movies.Observable;
import ca.ualberta.ssrg.movies.Observer;

public class Movies extends ArrayList<Movie> implements Observable {
	private volatile ArrayList<Observer> observers = new ArrayList<Observer>();
	private static final String RESOURCE_URL = "http://cmput301.softwareprocess.es:8080/testing/movie/";
	private static final String SEARCH_URL = "http://cmput301.softwareprocess.es:8080/testing/movie/_search";
	
	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void deleteObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.notifyUpdated(this);
			// Implement Observable to pass context to interface, just because context = Observable looks better Movies
			// Observer to callback to MainActivity through interface
			// To have Observer o, have to addObserver() in MainActivity first
			// So Observer for main class and Observable for the class will change and notify main class
		}
	}

	public String getResourceUrl() {
		return RESOURCE_URL;
	}

	public String getSearchUrl() {
		return SEARCH_URL;
	}

	/**
	 * Java wants this, we don't need it for Gson/Json
	 */
	private static final long serialVersionUID = 3199561696102797345L;

}

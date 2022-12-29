package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addmovi(Movie m){
         movieRepository.addmovie(m);
    }
    public  Movie getmovi(String name){
        Movie result = movieRepository.getMoviByName(name);
        return result;
    }
    public void addDir(Director d){
        movieRepository.addDirector(d);
    }
    public  Director getDir(String name){
        Director result = movieRepository.getDirectorByName(name);
        return result;
    }
    public void pair(String m , String d){
        movieRepository.pair(m,d);
    }

    public List<String> getMoviByDirectors(String d){
        return movieRepository.getMoviByDirector(d);
    }

    public List<String> getAllMovis(){
        List<String>list =movieRepository.getAllMovi();
        return list;
    }
    public void deletDirecByNames(String d) {
        movieRepository.deletDirecByName(d);
    }
    public void deletAllDirecs() {
        movieRepository.deletAllDirec();
    }
}

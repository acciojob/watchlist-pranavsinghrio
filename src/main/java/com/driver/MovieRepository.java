package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    ///////  hashMap.........................................
HashMap<String,Movie>hm=new HashMap<>();
    HashMap<String,Director>hd=new HashMap<>();
    HashMap<String, List<String>>hp=new HashMap<>();


    // 1) add movie...........................................
    public void addmovie(Movie movi){
        String key = movi.getName();
        hm.put(key,movi);
    }

    // 2) get movi by name ...................................
    public Movie getMoviByName(String name){
            return hm.get(name);
    }

    // 3) add Director ...........................................
    public void addDirector(Director d){
        String key = d.getName();
        hd.put(key,d);
    }

    // 4) get director by Name ...................................
    public Director getDirectorByName(String name){
        return hd.get(name);
    }

    // 5) make movie and director pair ..............................
    public void pair(String m , String d){
        if(hm.containsKey(m) && hd.containsKey(d)){
            List<String>list = new ArrayList<>();
            if(hp.containsKey(d)){
                list=hp.get(d);
                list.add(m);
                hp.put(d,list);
            }
        }
    }

    // 6) get movi by director name.................................

    public List<String> getMoviByDirector(String d){
        List<String>list = new ArrayList<>();
        if(hp.containsKey(d)){
            list=hp.get(d);
        }
        return list;
    }

    // 7) list of all movie..........................................

    public List<String> getAllMovi(){
        List<String>list = new ArrayList<>(hm.keySet());
        return list;
    }

    // 8) delet by director .........................................
    public void deletDirecByName(String d) {
        List<String>ml=new ArrayList<>();
        if(hp.containsKey(d)){
            ml=hp.get(d);
        }
        for(String m:ml){
            if(hm.containsValue(m)){
                hm.remove(m);
            }
        }
        hp.remove(d);
        hd.remove(d);
    }
    // 9) delet all director ...................................
    public void deletAllDirec() {
        hd=new HashMap<>();
        List<String>ml=new ArrayList<>();

        for(String d: hp.keySet()){
            for(String m:hp.get(d)){
                ml.add(m);
            }
        }

        for(String m:hm.keySet()){
            if(hm.containsValue(m)){
                hm.remove(m);
            }
        }
        hp=new HashMap<>();
    }
}

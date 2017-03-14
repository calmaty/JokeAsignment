/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex.jokefetching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Legendslayer
 */
public class FetcherFactory implements IFetcherFactory {

    private final List<String> availableTypes = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");

    @Override
    public List<String> getAvailableTypes() {
        return availableTypes;
    }

    @Override
    public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
        List<IJokeFetcher> returnList = new ArrayList<>();
        String[] tokens = jokesToFetch.split(",");
        for (String token : tokens) {
            switch (token) {
                case "eduprog":
                    returnList.add(new EduJoke());
                    break;
                case "chucknorris":
                    returnList.add(new ChuckNorris());
                    break;
                case "moma":
                    returnList.add(new Moma());
                    break;
                case "tambal":
                    returnList.add(new Tambal());
                    break;
                default:
                    break;
            }
        }
        return returnList;
    }
}

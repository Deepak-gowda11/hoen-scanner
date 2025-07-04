package com.skyscanner;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<Configuration> {

    private List<SearchResult> searchResults;

    public static void main(String[] args) throws Exception {
        new HoenScannerApplication().run("server");
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws IOException {
        // Load hotels.json and rental_cars.json
        ObjectMapper mapper = new ObjectMapper();

        List<SearchResult> hotelResults = mapper.readValue(
                Resources.getResource("hotels.json"),
                new TypeReference<List<SearchResult>>() {}
        );

        List<SearchResult> carResults = mapper.readValue(
                Resources.getResource("rental_cars.json"),
                new TypeReference<List<SearchResult>>() {}
        );

        searchResults = new ArrayList<>();
        searchResults.addAll(hotelResults);
        searchResults.addAll(carResults);

        environment.jersey().register(new SearchResource(searchResults));

        // We will register the search resource in the next step
    }
}

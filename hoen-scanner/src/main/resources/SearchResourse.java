package com.skyscanner;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SearchResource {

    private final List<SearchResult> searchResults;

    public SearchResource(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @POST
    public Response searchByCity(Search search) {
        String city = search.getCity().toLowerCase();

        List<SearchResult> results = searchResults.stream()
                .filter(r -> r.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        return Response.ok(results).build();
    }
}

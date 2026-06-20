package com.readstat.services;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.readstat.POJOs.Book;

import io.github.cdimascio.dotenv.Dotenv;

/*
 * Author:        Linnea Jones
 * Purpose:       Communicates with the Google Books API (GBAPI) to retrieve book information and translates it into a Java understandable form
 * Revision Date: 06/19/2026
 */

public class GoogleBooksService {

    private static final String API_key = Dotenv.load().get("GOOGLE_BOOKS_API_KEY");
    private static final String base_URL = "https://www.googleapis.com/books/v1/volumes";

    // TODO: add calls to GBAPI to add CSV unknown info from GBAPI - where logical
    // TODO: For adding books by searching by title, need to verify it's the correct book because Google will return more than one
    // TODO: When adding book, verify it's not already in the DB

    // maybe rework this plan, it'd be easier to identify if everything uses the same id system
    // can stick with CSV for keeping existing book data, but only add stuff to it based on GBAPI data

    public static HttpResponse<String> sendHttpRequest(String queries) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(base_URL + queries)).GET().build();
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch( IOException e) { System.out.println("Failed to fetch book from GBAPI."); e.printStackTrace(); }
        catch(InterruptedException e) { System.out.println("Request to fetch book was interrupted."); e.printStackTrace(); }

        return null;
    }

    public static Book parseJsonToBook(JsonNode volume) {
        // parse authors
        ArrayList<String> authors = new ArrayList<>();
        if(volume.get("authors") != null) {
            for(JsonNode author : volume.get("authors")) {
                authors.add(author.asText());
            }
        }

        // parse genres
        ArrayList<String> genres = new ArrayList<>();
        if(volume.get("categories") != null) {
            for(JsonNode genre : volume.get("categories")) {
                genres.add(genre.asText());
            }
        }

        String id = (volume.get("id") != null)                      ? volume.get("id").asText() : null;
        String title = (volume.get("title") != null)                ? volume.get("title").asText() : null;
        int pages = (volume.get("pageCount") != null)               ? volume.get("pageCount").asInt() : -1;
        String description = (volume.get("description") != null)    ? volume.get("description").asText() : null;
        String cover_url = (volume.get("thumbnail") != null)        ? volume.get("thumbnail").asText() : null;

        // create book POJO from parsed JSON
        return new Book(id, title, pages, description, cover_url, authors, genres);
    }

    // sends a request to GBAPI to get books by title
    public static ArrayList<Book> getBookByTitle(String title) {
        ArrayList<Book> books = new ArrayList<>();

        // send the request to get json about book
        String url = "?q=intitle:" + URLEncoder.encode(title, StandardCharsets.UTF_8) + "&key=" + API_key + "&maxResults=5";
        HttpResponse<String> response = sendHttpRequest(url);

        // parse and turn into Book POJO
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            for( JsonNode volume : root.get("items")) {
                books.add(parseJsonToBook(volume));
            }
        } catch(JsonMappingException e) { System.out.println("Failed to map JSON to POJO."); e.printStackTrace(); }
        catch(JsonProcessingException e) { System.out.println("Failed to process JSON book"); e.printStackTrace(); }

        return books;
    }
}
package com.readstat.POJOs;

/*
 * Author:        Linnea Jones
 * Purpose:       Stores book information in a java understandable form
 * Revision Date: 06/14/2026
 */

public record Book(int ID, String title, String author, int pages, String description) {}
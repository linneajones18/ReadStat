package com.readstat.POJOs;

/*
 * Author:        Linnea Jones
 * Purpose:       Stores author names with their count to be able to be returned as a java understandable resultset
 * Revision Date: 7/22/2025
 */

public record AuthorRecord(String author, int count) {}
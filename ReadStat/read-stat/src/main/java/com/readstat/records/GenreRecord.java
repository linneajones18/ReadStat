package com.readstat.records;

/*
 * Author:        Linnea Jones
 * Class:         CSCI 4448
 * Purpose:       Stores genre names with their count to be able to be returned as a java understandable resultset
 * Revision Date: 7/22/2025
 */

public record GenreRecord(String name, int count) {}

package br.eygon.model;

import jakarta.validation.Path;

import java.util.Iterator;

public class ErrorField {
    public String field;
    public String message;

    public ErrorField(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ErrorField(Iterator<Path.Node> path, String message) {
        this.field = fieldName(path);
        this.message = message;
    }

    public String fieldName(Iterator<Path.Node> nodes) {
        Path.Node last = null;
        while (nodes.hasNext()) last = nodes.next();
        return last.getName();
    }
}
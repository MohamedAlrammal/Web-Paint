package com.Paint.Paint.services;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.Paint.Paint.services.shapes.shape;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Savefiles implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<shape> shapetosaved = new ArrayList<>();
    public List<shape> getShapetosaved() {
        return shapetosaved;
    }

    public void setShapetosaved(List<shape> shapetosaved) {
        this.shapetosaved = shapetosaved;
    }

    public void saveToXML(String path) throws IOException {
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            throw new IOException("Directory does not exist: " + file.getParent());
        }
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)))) {
            encoder.writeObject(this);
        }
    }

    public static Savefiles loadFromXML(String path) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            return (Savefiles) decoder.readObject();
        } catch (Exception e) {
            throw new IOException("Failed to load from XML at path: " + path, e);
        }
    }

    public void savejson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File(path), this);
        } catch (IOException e) {
            throw new IOException("Failed to save to JSON at path: " + path, e);
        }
    }

    public static Savefiles savefromJson(String path) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(new File(path), Savefiles.class);
        } catch (IOException e) {
            throw new IOException("Failed to load from JSON at path: " + path, e);
        }
    }
}
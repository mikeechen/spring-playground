package com.example;

public class Pokemon {
    private String name;
    private int id;
    private int weight;
    private Types[] types;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setTypes(Types[] types) {
        this.types = types;
    }

    public Types[] getTypes() {
        return this.types;
    }

}

class Types {
    private int slot;
    private Type type;

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getSlot() {
        return this.slot;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return this.type;
    }
}

class Type {
    private String url;
    private String name;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
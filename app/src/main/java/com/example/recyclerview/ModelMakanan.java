package com.example.recyclerview;

public class ModelMakanan {
    String makananName;
    String makananDescription;
    int makananImage;

    public ModelMakanan(String characterName, String characterDescription, int characterImage) {
        this.makananName = characterName;
        this.makananDescription = characterDescription;
        this.makananImage = characterImage;
    }

    public String getMakananName() {
        return makananName;
    }

    public String getMakananDescription() {
        return makananDescription;
    }

    public int getMakananImage() {
        return makananImage;
    }
}

package cl.cesarg.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("url")
    private String url;

    @JsonProperty("sprites")
    private Sprites sprites;


    @JsonProperty("id")
    private Integer id;

    @JsonProperty("height")
    private double height;

    @JsonProperty("weight")
    private double weight;

    @JsonProperty("base_experience")
    private Integer baseExperience;


    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sprites {

        @JsonProperty("other")
        private Other other;

        // Getters y setters

        public Other getOther() {
            return other;
        }

        public void setOther(Other other) {
            this.other = other;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Other {

            @JsonProperty("dream_world")
            private DreamWorld dreamWorld;

            @JsonProperty("official-artwork")
            private OfficialArtwork officialArtwork;

            @JsonProperty("showdown")
            private ShowDown showDown;

            // Getters y setters

            public DreamWorld getDreamWorld() {
                return dreamWorld;
            }

            public void setDreamWorld(DreamWorld dreamWorld) {
                this.dreamWorld = dreamWorld;
            }

            public OfficialArtwork getOfficialArtwork() {
                return officialArtwork;
            }

            public void setOfficialArtwork(OfficialArtwork officialArtwork) {
                this.officialArtwork = officialArtwork;
            }

            public ShowDown getShowDown() {
                return showDown;
            }

            public void setShowDown(ShowDown showDown) {
                this.showDown = showDown;
            }



            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class DreamWorld {

                @JsonProperty("front_default")
                private String frontDefault;

                // Getters y setters

                public String getFrontDefault() {
                    return frontDefault;
                }

                public void setFrontDefault(String frontDefault) {
                    this.frontDefault = frontDefault;
                }
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class OfficialArtwork {

                @JsonProperty("front_default")
                private String frontDefault;

                // Getters y setters

                public String getFrontDefault() {
                    return frontDefault;
                }

                public void setFrontDefault(String frontDefault) {
                    this.frontDefault = frontDefault;
                }
            }


            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class ShowDown {

                @JsonProperty("front_default")
                private String frontDefault;

                // Getters y setters

                public String getFrontDefault() {
                    return frontDefault;
                }

                public void setFrontDefault(String frontDefault) {
                    this.frontDefault = frontDefault;
                }
            }


        }
    }

}

package it.ternali.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonIgnoreProperties
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PopularBook {

    @JsonProperty("title")
    private String title;
    @JsonProperty("subtitle")
    private String subtitle;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("image")
    private String image;
    @JsonProperty("url")
    private String url;

}

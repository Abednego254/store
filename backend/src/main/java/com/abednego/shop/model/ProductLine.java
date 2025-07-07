package com.abednego.shop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Base64;

@Entity
@Table(name = "productlines")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "productLine", nullable = false, unique = true, length = 50)
    private String productLine;

    @NotBlank
    @Size(min = 10, max = 4000)
    @Column(name = "textDescription", nullable = false, length = 4000)
    private String textDescription;

    @Lob
    @Column(name = "htmlDescription")
    private String htmlDescription;

    @Lob
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    private byte[] image;

    @Transient
    @JsonProperty("imageBase64")
    public String getImageBase64() {
        if (this.image != null) {
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(this.image);
        }
        return null;
    }
}

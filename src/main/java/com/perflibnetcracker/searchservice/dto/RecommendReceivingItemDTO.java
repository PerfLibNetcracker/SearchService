package com.perflibnetcracker.searchservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RecommendReceivingItemDTO implements Serializable {
    @JsonProperty("ItemId")
    private String itemId;
    @JsonProperty("Popularity")
    private Integer popularity;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("Score")
    private Integer score;
}

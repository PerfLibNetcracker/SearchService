package com.perflibnetcracker.searchservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class RecommendFeedbackItemDTO implements Serializable {
    @JsonProperty("ItemId")
    private String itemId;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("Feedback")
    private float feedback;
}

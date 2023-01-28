package ch.chakun.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderDto {

    private String id;
    private String status;
    private Double price;
    private Integer number;

}

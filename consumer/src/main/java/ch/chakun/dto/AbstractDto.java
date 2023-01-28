package ch.chakun.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

@JsonDeserialize(as = OrderDto.class) // should be improved
public interface AbstractDto extends Serializable {
}

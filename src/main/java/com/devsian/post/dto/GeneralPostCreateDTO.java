package com.devsian.post.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@JsonRootName("generalPostCreateDTO")
public class GeneralPostCreateDTO extends PostCreateDTO {
}

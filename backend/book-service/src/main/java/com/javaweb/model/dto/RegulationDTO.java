package com.javaweb.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RegulationDTO {
    Long id;
    String content;
    Date dateIssued;
}

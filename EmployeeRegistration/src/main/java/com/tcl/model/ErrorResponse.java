package com.tcl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder 
@NoArgsConstructor
public class ErrorResponse {
   private String statusCode;
   private String messsage;
   
}

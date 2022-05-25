package com.example.cortiliabe.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericObject {

    private Object genericObject;

    private boolean success;

    private String msg;
}

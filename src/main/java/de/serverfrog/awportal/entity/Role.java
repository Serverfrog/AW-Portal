package de.serverfrog.awportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Created
*/
@AllArgsConstructor
@Getter
public enum Role {

    NORMAL("NORMAL"),ADMIN("ADMIN");

    private String role;
}

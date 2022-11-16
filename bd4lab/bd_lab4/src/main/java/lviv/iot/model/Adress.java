package lviv.iot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Adress {
    private Integer id;
    private String adress;
    private String street;
    private String build;


}


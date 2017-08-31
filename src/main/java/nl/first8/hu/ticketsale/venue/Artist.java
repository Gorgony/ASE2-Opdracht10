package nl.first8.hu.ticketsale.venue;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by njvan on 30-Aug-17.
 */

@Entity
@Data
@NoArgsConstructor
public class Artist {

    public enum Genre{
        ROCK, POP
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Genre genre;
}

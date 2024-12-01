package com.davidrotabor.flight.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflight")
    private long idFlight;

    @Column(name = "nombreavion", nullable = false, length = 80)
    private @NonNull String nombreAvion;

    @Column(name = "numerovuelo", nullable = false, length = 80)
    private @NonNull String numeroVuelo;

    @Column(name = "destino", nullable = false, length = 80)
    private @NonNull String destino;

    @Column(name = "origen", nullable = false, length = 80)
    private @NonNull String origen;

    @Column(name = "capacidad", nullable = false, length = 80)
    private @NonNull String capacidad;

    @Column(name = "rating", nullable = false, length = 80)
    @Min(value = 1, message = "id should be more or than equal 1")
    @Max(value = 5, message = "id should be less or than equal 1")
    private @NonNull int rating;

    @Column(name = "planvuelo", nullable = false, length = 80)
    private @NonNull String planvuelo;

    private Boolean cumplido;

}

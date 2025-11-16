package dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Car {
    private String location;
    private String manufacture;
    private String model;
    private int year;
    private String fuel;
    private int seats;
    private String carClass;
    private String registrationNumber;
    private String price;
    private String about;
}

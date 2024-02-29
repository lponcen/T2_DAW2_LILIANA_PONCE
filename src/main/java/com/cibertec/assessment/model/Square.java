package com.cibertec.assessment.model;

import java.util.List;

import com.cibertec.assessment.IntConverter;
import com.cibertec.assessment.StringConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Square {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int npoints;

    @Column(columnDefinition = "json", name = "x_points")
    @Convert(converter = IntConverter.class)
    private Integer[] xpoints;

    @Column(columnDefinition = "json", name = "y_points")
    @Convert(converter = IntConverter.class)
    private Integer[] ypoints;

    @Column(columnDefinition = "json", name = "polygons")
    @Convert(converter = StringConverter.class)    
    private List<String> polygons;
    
}
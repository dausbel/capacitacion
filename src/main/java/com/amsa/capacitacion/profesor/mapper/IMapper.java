package com.amsa.capacitacion.profesor.mapper;

/**
 * @developedBy Ing. Dausbel Torreblanca Pavo
 */
public interface IMapper<O,I> {
    
    O map(I in);
}

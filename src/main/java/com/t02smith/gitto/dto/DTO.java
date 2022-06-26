package com.t02smith.gitto.dto;

/**
 * Any entity that is to be returned from a request must
 * be in the form of a DTO so all entities will need a
 * function to map them to their DTO
 *
 * @param <DTOType> The DTO equivalent of the entity
 */
public interface DTO <DTOType>{

    /**
     * Maps an entity to its DTO equivalent type
     * @param e the entity
     * @return the dto
     */
    DTOType toDTO();
}

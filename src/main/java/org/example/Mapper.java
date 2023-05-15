package org.example;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Stream;

public abstract class Mapper<E,D> {

    public abstract E mapDto(D dto);

    public abstract D mapEntity(E entity);

    public Stream<E> mapDtoCollection(Collection<D> dtoCollection){
        return dtoCollection.stream()
                .map(this::mapDto);
    }
    public Stream<D> mapEntityCollection(Collection<E> entityCollection){
        return entityCollection.stream()
                .map(this::mapEntity);
    }

    public Collection<D> mapEntityCollection(Collection<E> collection, Collector<D,?, Collection<D>> collector){
        return mapEntityCollection(collection).collect(collector);
    }

    public Collection<E> mapDtoCollection(Collection<D> collection, Collector<E,?,Collection<E>> collector){
        return mapDtoCollection(collection).collect(collector);
    }
}

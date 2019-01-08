package me.cockx.learn.springbootspc.services.map;

import me.cockx.learn.springbootspc.model.BaseEntity;

import java.util.*;

abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

    private Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T t){
        if(t!=null){
            if(t.getId()==null){
                t.setId(getNextID());
            }
            map.put(t.getId(),t);
        }else {
            throw new RuntimeException("Object cannot be Null");
        }

        return t;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T t){
        map.entrySet().removeIf(entry->entry.getValue().equals(t));
    }

    private Long getNextID(){
        long nextId;
        try{
            nextId = Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            nextId = 1L;
        }

        return nextId;
    }
}

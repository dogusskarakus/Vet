package dev.patika.Veteriner.base;

import java.util.List;

public interface BaseService<ENTITY extends BaseEntity, REQ, RES> {

    RES save(REQ request);

    RES findById(long id);

    RES update(Long id, REQ request);

    void deleteById(Long id);

    ENTITY findByIdEntity(Long id);

    List<RES> findAll();

    //metot sınıfı

}

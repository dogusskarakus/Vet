/*

package dev.patika.Veteriner.Business.concretes;

import dev.patika.Veteriner.Business.abstracts.IVaccineService;
import dev.patika.Veteriner.core.exception.NotFoundException;
import dev.patika.Veteriner.core.utiles.Msg;
import dev.patika.Veteriner.dao.VaccineRepo;
import dev.patika.Veteriner.entity.Customer;
import dev.patika.Veteriner.entity.Vaccine;
import org.springframework.stereotype.Service;

@Service
public class VaccineManager implements IVaccineService {

    private final VaccineRepo vaccineRepo;

    public VaccineManager(VaccineRepo vaccineRepo) {
        this.vaccineRepo = vaccineRepo;
    }

    @Override
    public Vaccine save(Vaccine vaccine)
    {
        return this.vaccineRepo.save(vaccine);



    }

    @Override
    public Vaccine get(int id) {
        return this.vaccineRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Vaccine update(Vaccine vaccine) {
        this.get((int) vaccine.getId());
        return this.vaccineRepo.save(vaccine);
    }

    @Override
    public boolean delete(int id) {
        Vaccine vaccine = this.get(id);
        this.vaccineRepo.delete(vaccine);
        return true;
    }
}

*/

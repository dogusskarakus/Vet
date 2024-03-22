/*

package dev.patika.Veteriner.Business.concretes;

import dev.patika.Veteriner.Business.abstracts.IDoctorService;
import dev.patika.Veteriner.core.utiles.Msg;
import dev.patika.Veteriner.dao.DoctorRepo;
import dev.patika.Veteriner.entity.Doctor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.print.Doc;
@Service
public class DoctorManager implements IDoctorService {

    private final DoctorRepo doctorRepo;

    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor get(int id) {
        return this.doctorRepo.findById(id).orElseThrow();
    }

    @Override
    public Doctor update(Doctor doctor) {
        this.get((int) doctor.getId());
        return this.doctorRepo.save(doctor);
    }

    @Override
    public boolean delete(int id) {
        Doctor doctor = this.get(id);
        this.doctorRepo.delete(doctor);
        return true;
    }
}

*/

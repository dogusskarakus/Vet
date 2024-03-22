/*

package dev.patika.Veteriner.Business.concretes;

import dev.patika.Veteriner.Business.abstracts.IAnimalService;
import dev.patika.Veteriner.core.exception.NotFoundException;
import dev.patika.Veteriner.core.utiles.Msg;
import dev.patika.Veteriner.dao.AnimalRepo;
import dev.patika.Veteriner.entity.Animal;
import org.springframework.stereotype.Service;

@Service
public class AnimalManager implements IAnimalService {

    private final AnimalRepo animalRepo;

    public AnimalManager(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public Animal save(Animal animal) {
        return this.animalRepo.save(animal);
    }

    @Override
    public Animal get(int id) {
        return this.animalRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Animal update(Animal animal) {
        this.get((int) animal.getId());
        return this.animalRepo.save(animal);
    }

    @Override
    public boolean delete(int id) {
        Animal animal = this.get(id);
        this.animalRepo.delete(animal);
        return true;
    }
}
*/


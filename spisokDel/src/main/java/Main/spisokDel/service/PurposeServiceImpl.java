package Main.spisokDel.service;

import Main.spisokDel.repository.model.Purpose;
import Main.spisokDel.repository.PurposeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PurposeServiceImpl implements PurposeService {
    @Autowired
    private PurposeRepository purposeRepository;

    @Override
    public int addPurpose(Purpose purpose) {
        Purpose purpose1 = new Purpose();
        purpose1.setName(purpose.getName());
        purpose1.setDeadLine(purpose.getDeadLine());
        purposeRepository.save(purpose1);
        return purpose1.getId();
    }

    @Override
    public void deleteAll() {
        purposeRepository.deleteAll();
    }

    @Override
    public void delete(Integer id) {
        purposeRepository.deleteById(id);
    }

    @Override
    public Purpose getById(Integer id) {
        return purposeRepository.findById(id).get();
    }

    @Override
    public Purpose editPurpose(int id, Purpose purpose) {
        Optional<Purpose> oldPurpose = purposeRepository.findById(id);
        if(!oldPurpose.isPresent()) {
            return null;
        }
        Purpose updatedPurpose = new Purpose();
        updatedPurpose.setDeadLine(purpose.getDeadLine());
        updatedPurpose.setName(purpose.getName());
        purposeRepository.deleteById(id);
        purposeRepository.save(updatedPurpose);
        return updatedPurpose;
    }

    @Override
    public List<Purpose> getAll() {
        List<Purpose> list = new ArrayList<>();
        Iterable<Purpose> purposeIterable = purposeRepository.findAll();
        for (Purpose purpose: purposeIterable)
            list.add(purpose);
        return list;
    }

    @Override
    public Purpose setActuality(Purpose purpose) {
        Optional<Purpose> optionalPurpose = purposeRepository.findById(purpose.getId());
        Purpose newPurpose = new Purpose();
        newPurpose.setId(optionalPurpose.get().getId());
        newPurpose.setIrRelevance();
        newPurpose.setName(optionalPurpose.get().getName());
        newPurpose.setDeadLine(optionalPurpose.get().getDeadLine());
        purposeRepository.save(newPurpose);
        return newPurpose;
    }
}

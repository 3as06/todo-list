package Main.spisokDel.service;

import Main.spisokDel.model.Purpose;

import java.util.List;

public interface PurposeService {
    int addPurpose(Purpose purpose);
    void deleteAll();
    void delete(Integer id);
    /*Purpose getByName(String name);*/
    Purpose getById(Integer id);
    Purpose editPurpose(int id, Purpose purpose);
    List<Purpose> getAll();
    Purpose setActuality(Purpose purpose);

}

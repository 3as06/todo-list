
package Main.spisokDel;

import Main.spisokDel.model.Purpose;
import Main.spisokDel.service.PurposeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PurposeController {

    private PurposeServiceImpl purposeServiceImpl;

    public PurposeController(PurposeServiceImpl purposeServiceImpl) {
        this.purposeServiceImpl = purposeServiceImpl;
    }

    @PostMapping("/purposes/")
    public int addPurpose(Purpose purpose) {
        return purposeServiceImpl.addPurpose(purpose);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Purpose purpose = purposeServiceImpl.getById(id);
        if(purpose == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(purpose.getDeadLine(), HttpStatus.OK);
    }

    @DeleteMapping("/purpose/")
    public void deleteAll() {
        purposeServiceImpl.deleteAll();
    }

    @PatchMapping("/purpose/")
    public void setActuality(Purpose purpose) {
        purposeServiceImpl.setActuality(purpose);
    }


    @PutMapping("/purpose/{id}/")
    private ResponseEntity set(@PathVariable int id, Purpose newPurpose) {
        Purpose editedPurpose = purposeServiceImpl.editPurpose(id, newPurpose);
        if(editedPurpose == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            return new ResponseEntity(editedPurpose, HttpStatus.OK);
        }
    }

    @DeleteMapping("/purpose/{id}/")
    private ResponseEntity delete(@PathVariable int id) {
        Purpose purpose = purposeServiceImpl.getById(id);
        if(purpose == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        purposeServiceImpl.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}


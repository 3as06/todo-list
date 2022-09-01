package Main.spisokDel.repository;

import Main.spisokDel.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose, Integer> {
    @Query("Select p FROM Purpose p where p.name = :name")
    Purpose findByName(@Param("name") String name);
}

package Main.spisokDel.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purpose {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String deadLine;
    @Column(columnDefinition = "BOOL")
    private boolean relevance = true;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isRelevance() {
        return relevance;
    }

    public void setIrRelevance() {
        this.relevance = false;
    }
}

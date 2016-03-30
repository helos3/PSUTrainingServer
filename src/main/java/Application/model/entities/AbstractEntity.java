package Application.model.entities;

import Application.utils.JSONAble;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Rushan on 23.03.2016.
 */

@MappedSuperclass
public abstract class AbstractEntity implements JSONAble {
    @Id @GeneratedValue
    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return 17 + getId();
    }
}

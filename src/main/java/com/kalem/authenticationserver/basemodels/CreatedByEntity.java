package com.kalem.authenticationserver.basemodels;


import com.kalem.basemodels.user.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class CreatedByEntity<I extends Number> extends IDEntity<I> {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATE_USER", nullable = false, updatable = false)
    @CreatedBy
    private UserEntity createdUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODIFY_USER", nullable = false)
    @LastModifiedBy
    private UserEntity modifiedUser;

    protected void clone(CreatedByEntity createdByModel) throws CloneNotSupportedException {
        createdByModel.setCreatedUser(this.getCreatedUser().cloneSafe());
        createdByModel.setModifiedUser(this.getModifiedUser().cloneSafe());
        super.clone(createdByModel);
    }

    @Override
    public String toString() {
        String _text = "";
        _text += createdUser != null ? "createdUser.ID:" + createdUser.getID() : "";
        _text += modifiedUser != null ? ", " : "";
        _text += modifiedUser != null ? "modifiedUser.ID:" + modifiedUser.getID() : "";

        return _text;
    }
}

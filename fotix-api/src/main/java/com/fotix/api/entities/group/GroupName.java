package com.fotix.api.entities.group;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by herasimau on 01/10/16.
 */

public enum GroupName {
    PHOTO_MODEL("PHOTO_MODEL"), PHOTOGRAPH("PHOTOGRAPH"),
    STYLIST("STYLIST"), PHOTO_RETOUCHER("PHOTO_RETOUCHER"),
    MAKE_UP_ARTIST("MAKE_UP_ARTIST"), PHOTO_STUDIO("PHOTO_STUDIO");

    private final String groupName;

    GroupName(String s) {
        groupName = s;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : groupName.equals(otherName);
    }

    public String toString() {
        return this.groupName;
    }
}

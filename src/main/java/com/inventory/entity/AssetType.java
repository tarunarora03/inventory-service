package com.inventory.entity;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class AssetType extends org.hibernate.type.EnumType {
	

	private static final long serialVersionUID = 1L;

	public void nullSafeSet(
            PreparedStatement st,
            Object value,
            int index,
            SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
        st.setObject(
            index,
            value != null ?
                ((Enum) value).name() :
                null,
            Types.OTHER
        );
    }
}

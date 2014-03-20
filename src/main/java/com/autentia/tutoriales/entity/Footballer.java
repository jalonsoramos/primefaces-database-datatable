package com.autentia.tutoriales.entity;

import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

@Entity
@NamedNativeQueries({
		@NamedNativeQuery(name = "Footballer.findByNumber", query = "select * from findByNumber(?) as (id int, name varchar, lastname varchar, number int);", resultClass = Footballer.class),
		@NamedNativeQuery(name = "Footballer.SumaDeEnteros", query = "select suma(?,?) as resultado", resultSetMapping = "scalar") })
@SqlResultSetMapping(name = "scalar", columns = @ColumnResult(name = "resultado"))
public class Footballer {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String lastname;

	private int number;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(name);
		hashCodeBuilder.append(lastname);
		hashCodeBuilder.append(number);

		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean isEquals = false;
		try {
			final Footballer other = (Footballer)obj;
			final EqualsBuilder eqb = new EqualsBuilder();
			eqb.append(getName(), other.getName());
			eqb.append(getLastname(), other.getLastname());
			eqb.append(getNumber(), other.getNumber());

			isEquals = eqb.isEquals();
		} catch (Exception e) {
			isEquals = false;
		}
		return isEquals;
	}

	@Override
	public String toString() {
		return name + "," + lastname;
	}

}

package org.vinh.shortenUrl.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Author : Vinh Pham.
 * Date: 7/14/21.
 * Time : 12:00 AM.
 */
@Entity
public class User extends AbstractPersistable<Long> {
	private String username;

}

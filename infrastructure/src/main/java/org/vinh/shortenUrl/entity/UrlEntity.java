package org.vinh.shortenUrl.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 10:30 PM.
 */
@Entity
@Data
public class UrlEntity extends AbstractAuditable<User, String> {
	private String originUrl;

	@Override
	public void setId(String id) {
		super.setId(id);
	}
}

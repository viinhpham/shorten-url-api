package org.vinh.shortenUrl.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Author : Vinh Pham.
 * Date: 7/12/21.
 * Time : 10:30 PM.
 */
@Entity
@Data
public class UrlEntity extends AbstractPersistable<Long> {
	private String originUrl;
	private String shortenedUrl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@PrePersist
	public void prePersist(){
		createdDate = new Date();
	}

}

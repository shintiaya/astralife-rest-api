package com.astralife.rest.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 3247696593017334807L;
	
	private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "created_time", nullable = true, insertable = true, updatable = false)
    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    private String createdBy;

    @Column(name = "created_by", nullable = true, insertable = true, updatable = false, length = 25, precision = 0)
    @CreatedBy
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date updatedTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time", nullable = true, insertable = true, updatable = true)
    @LastModifiedDate
    @CreatedDate
    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    private String updatedBy;

    @Column(name = "updated_by", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    @LastModifiedBy
    @CreatedBy
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private String authoriser;

    @Column(name = "authoriser", nullable = true, insertable = true, updatable = true, length = 25, precision = 0)
    public String getAuthoriser() {
        return authoriser;
    }
    
	public void setAuthoriser(String authoriser) {
        this.authoriser = authoriser;
    }
	
    private Date authorizeTime;

    @Column(name = "authorize_time", nullable = true, insertable = true, updatable = true)
    public Date getAuthorizeTime() {
		return authorizeTime;
	}

	public void setAuthorizeTime(Date authorizeTime) {
		this.authorizeTime = authorizeTime;
	}

    private String status;

    @Column(name = "status", nullable = true, insertable = true, updatable = true, length = 10, precision = 0)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private Integer version;

    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * Returns a multi-line String with key=value pairs.
     *
     * @return a String representation of this class.
     */
    public abstract String toString();

    /**
     * Compares object equality. When using Hibernate, the primary key should
     * not be a part of this comparison.
     *
     * @param o object to compare to
     * @return true/false based on equality tests
     */
    public abstract boolean equals(Object o);

    /**
     * When you override equals, you should override hashCode. See "Why are
     * equals() and hashCode() importation" for more information:
     * http://www.hibernate.org/109.html
     *
     * @return hashCode
     */
    public abstract int hashCode();

}

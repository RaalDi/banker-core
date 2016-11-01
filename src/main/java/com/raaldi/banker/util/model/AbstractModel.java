package com.raaldi.banker.util.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/** Base Entity Model Class. */
@MappedSuperclass
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractModel implements Serializable {

  private static final long serialVersionUID = 7505914005524063242L;

  /** The Created Date. */
  @NotNull
  @Column(name = "created_date", nullable = false, insertable = true, updatable = false)
  @CreatedDate
  private LocalDateTime createdDate;

  /** The Created User. */
  @NotNull
  @Column(name = "created_by", nullable = false, insertable = true, updatable = false)
  @CreatedBy
  private String createdBy;

  /** The Modified Date. */
  @Column(name = "modified_date", insertable = false, updatable = true)
  @LastModifiedDate
  private LocalDateTime modifiedDate;

  /** The Modified User. */
  @Column(name = "modified_by", insertable = false, updatable = true)
  @LastModifiedBy
  private String modifiedBy;

  /** The Version Number. */
  @JsonIgnore
  @Version
  @NotNull
  @Column(name = "version", nullable = false)
  private long version;

  /**
   * Sets the updated date. public void setUpdatedDate(final long updated) {
   * 
   * if (updated != null && modifiedBy == null) { throw new
   * IllegalArgumentException("modifiedBy may not be NULL when updating the
   * Entity"); }
   * 
   * this.updatedAt = updated; }
   * 
   * @PrePersist public void onPrePersist() {
   *             this.setCreated(LocalDateTime.now()); }
   * 
   * @PreUpdate public void onPreUpdate() {
   *            this.setUpdated(LocalDateTime.now()); }
   * 
   * @PreRemove public void onPreRemove() {
   * 
   *            }
   */
}

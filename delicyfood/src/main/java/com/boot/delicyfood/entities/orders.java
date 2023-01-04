package com.boot.delicyfood.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;

@Schema(name="Order Entity")
@Entity
@Table(name="orders")
@EntityListeners({AuditingEntityListener.class})
@Setter
@Getter
@ToString
public class orders implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	Long orderID;
	
    @Email
	@Column(name="email")
	String Email;
	
	 @Column(name="totalprice")
	 Long totalPrice;
	 
	 @Column(name="location")
	 String Location;
	 
	
	 @CreatedDate
     LocalDateTime date;
     
     
 
	 @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 private Collection<order_details> order_details = new ArrayList<>();


	
     
	 
	
}

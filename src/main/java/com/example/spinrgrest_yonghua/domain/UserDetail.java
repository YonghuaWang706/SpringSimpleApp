package com.example.spinrgrest_yonghua.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "user_detail")
public class UserDetail {
	//id, firstname, lastname, email, userId
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
//	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID")
	private User user;//one to one

	@Override
	public String toString() {
		return "UserDetail{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}

//package com.webrixtec.pojo;
//
//import java.util.Set;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.validation.constraints.NotNull;
//
//import com.webrixtec.model.Role;
//
//public class signupPojo {
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String userName;
//    private String phone;
//
//	@NotNull(message = "email must not be empty")
//    private String email;
//
//	@NotNull(message = "password must not be empty")
//    private String password;
//
//    @ManyToMany
//    private Set<Role> roles;
//    
//}

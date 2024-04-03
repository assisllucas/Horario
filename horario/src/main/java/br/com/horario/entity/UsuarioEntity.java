package br.com.horario.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario", schema = "horario")
public class UsuarioEntity implements Serializable,UserDetails {


private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_usuario")
private Long id_usuario;

@Column(name = "cpf")
private String cpf;

@Column(name = "email")
private String email;

@Column(name = "nome")
private String nome;

@Column(name = "senha")
private String senha;

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return false;
}




@ManyToMany

@JoinTable (name="usuario_permissao",
joinColumns={@JoinColumn(name="usuario_id_usuario", referencedColumnName = "id_usuario")}
, inverseJoinColumns={@JoinColumn (name="permissao_id_permissao", referencedColumnName = "id_permissao")})
private List<PermissaoEntity> permissoes;

}
package com.salmon.scommerce.core.domain;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Long id;
    private String role; //��ɫ��ʶ �������ж�ʹ��,��"admin"
    private String description; //��ɫ����,UI������ʾʹ��
    private Boolean available = Boolean.FALSE; //�Ƿ����,��������ý�������Ӹ��û�
    private Set<Permission> permissions;

	public Role() {
		this.permissions = new HashSet<Permission>();
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
        this.permissions = new HashSet<Permission>();
    }
    
    public Role(String role, String description, Boolean available,Set<Permission> permissions) {
        this.role = role;
        this.description = description;
        this.available = available;
        this.permissions = permissions;
    }
    
    public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}

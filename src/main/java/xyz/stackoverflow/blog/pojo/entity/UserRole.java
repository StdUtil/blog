package xyz.stackoverflow.blog.pojo.entity;

import java.io.Serializable;

/**
 * 用户-角色表实体类
 *
 * @author 凉衫薄
 */
public class UserRole implements Serializable {
    private String id;
    private String userId;
    private String roleId;

    public UserRole(){

    }

    public UserRole(String id, String userId, String roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}

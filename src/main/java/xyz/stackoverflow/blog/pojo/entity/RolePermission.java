package xyz.stackoverflow.blog.pojo.entity;

/**
 * 角色-权限表实体类
 *
 * @author 凉衫薄
 */
public class RolePermission {
    private String id;
    private String roleId;
    private String permissionId;

    public RolePermission(){

    }

    public RolePermission(String id, String roleId, String permissionId) {
        this.id = id;
        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}

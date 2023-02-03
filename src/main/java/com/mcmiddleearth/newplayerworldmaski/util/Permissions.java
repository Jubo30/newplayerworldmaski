package com.mcmiddleearth.newplayerworldmaski.util;

public enum Permissions {

    STAFF       ("npw.staff"),
    USER        ("now.user");

    private final String permissionNode;

    Permissions(String permissionNode){
        this.permissionNode = permissionNode;
    }

    public String getPermissionNode(){
        return permissionNode;
    }
}

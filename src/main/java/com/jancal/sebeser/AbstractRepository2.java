package com.jancal.sebeser;

/**
 * RepositoryImpl
 *
 * @author Jancal
 * @since 2017/3/20
 */
class AbstractRepository2 implements Repository2 {

    String username;
    String password;

    AbstractRepository2(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void doRepository() {
        System.out.println("doRepository..." + username + "," + password);
    }
}

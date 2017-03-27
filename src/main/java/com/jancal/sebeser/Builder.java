package com.jancal.sebeser;

/**
 * 负责依赖构建
 *
 * @author Jancal
 * @since 2017/3/20
 */
public final class Builder {
    private static Builder instance;
    private String username;
    private String password;
    private Executor executor;

    private Builder() {
    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }
        return instance;
    }

    /**
     * set username
     *
     * @param username the account
     * @return builder instance itself
     */
    public Builder username(String username) {
        if (username == null || username.length() == 0) {
            throw new IllegalArgumentException("username error");
        }
        this.username = username;
        return this;
    }

    public Builder password(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("password error");
        }
        this.password = password;
        return this;
    }

    public Builder build() {
        //repository
        Repository repository = new AbstractRepository(username, password);
        Repository2 repository2 = new AbstractRepository2(username, password);

        //service
        Service service = new AbstractService(repository, repository2);
        Service2 service2 = new AbstractService2(repository, repository2);

        //executor
        executor = new Executor(service, service2);
        return this;
    }

    public Builder start() {
        executor.start();
        return this;
    }
}

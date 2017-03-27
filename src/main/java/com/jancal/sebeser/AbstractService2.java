package com.jancal.sebeser;

/**
 * ServiceImpl
 *
 * @author Jancal
 * @since 2017/3/20
 */
class AbstractService2 implements Service2 {
    private Repository repository;
    private Repository2 repository2;

    AbstractService2(Repository repository, Repository2 repository2) {
        this.repository = repository;
        this.repository2 = repository2;
    }

    public void doService() {
        System.out.println("doService...");
        repository.doRepository();
    }

}

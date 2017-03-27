package com.jancal.outter;

import com.jancal.sebeser.Builder;

/**
 * 程序总入口
 *
 * @author Jancal
 */
final class Bootstrap {
    private Bootstrap() {
    }


    public static void main(String[] args) {
        Builder.getInstance().username("jancal").password("123456").build().start();
    }
}

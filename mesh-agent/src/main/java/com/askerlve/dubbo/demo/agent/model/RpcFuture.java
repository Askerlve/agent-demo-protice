package com.askerlve.dubbo.demo.agent.model;

import java.util.concurrent.*;

public class RpcFuture implements Future<Object> {

    private CountDownLatch latch = new CountDownLatch(1);

    private RpcResponse response;

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public Object get() throws InterruptedException, ExecutionException {

        latch.await();
        try {
            return response.getBytes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        boolean b = latch.await(timeout,unit);
        return response.getBytes();
    }

    public void done(RpcResponse response){
        this.response = response;
        latch.countDown();
    }
}

package com.suranku.util;


import javax.ws.rs.container.AsyncResponse;

public class AsyncThreadUtil {

    /**
     * Utility to create a thread that will propagate errors to an async response in a web service
     * layer.
     * <p>
     * Example usage:
     * <pre>
     *  AsyncThreadUtil.createThread(asyncResponse, () -> {
     *      Terminal terminal = findTerminal(id);
     *      if (terminal == null) {
     *          throw new NotFoundException("Terminal not found");
     *      }
     *
     *      TerminalResponse response = TerminalResponse.builder()
     *          .terminal(terminal)
     *          .code(OK.getStatusCode())
     *          .message(OK.getReasonPhrase())
     *          .uri(uriInfo.getPath()).build();
     *      asyncResponse.resume(response);
     *  }).start();
     * </pre>
     *
     * @param asyncResponse asyncResponse that will be used to
     * @param runnable thread runnable to execute that will return a normal response with asyncResponse.resume and
     *                 any exceptions thrown to the asyncResponse will be handled by the predefined exception
     *                 mappers
     * @return thread that can be run from a web service layer
     */
    public static Thread createThread(AsyncResponse asyncResponse, Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler((t, e) -> asyncResponse.resume(e));
        return thread;
    }
}

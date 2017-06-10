package com.suranku.users.dao;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({"code", "message", "uri", "method", "timestamp", "payload"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class StandardResponse<T> {
    @Getter
    @Setter
    private int code;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private String uri;

    @Getter
    @Setter
    private String method;

    @Getter
    private LocalDateTime timestamp = LocalDateTime.now();

    @Getter
    @Setter
    private T payload;

    protected StandardResponse(Builder<?, T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.uri = builder.uri;
        this.method = builder.method;
        this.payload = builder.payload;
    }

    @Override
    public String toString() {
        return "code=" + code + ", message=" + message + ", uri=" + uri + ", method=" + method + ", timestamp=" + timestamp + ", payload=" + payload;
    }

    public static class Builder<B extends StandardResponse.Builder<B, T>, T> {
        private int code;
        private String message;
        private String uri;
        private String method;
        private T payload;

        public B code(int code) {
            this.code = code;
            return (B) this;
        }

        public B message(String message) {
            this.message = message;
            return (B) this;
        }

        public B uri(String uri) {
            this.uri = uri;
            return (B) this;
        }

        public B method(String method) {
            this.method = method;
            return (B) this;
        }

        public B payload(T payload) {
            this.payload = payload;
            return (B) this;
        }

        public StandardResponse build() {
            return new StandardResponse<>(this);
        }
    }
}

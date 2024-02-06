package com.example.trainingcore.service.data;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

import java.util.Properties;

@Builder(
        builderMethodName = "hiddenBuilder",
        access = AccessLevel.PRIVATE
)
@Getter
public class MailData {

    private String receiver;
    private Type type;
    private Properties params;

    public enum Type {

        ACTIVATION,
        RESTORE

    }

    public static MailDataBuilder builder(
            final String receiver,
            final Type type
    ) {
        return hiddenBuilder()
                .params(new Properties())
                .receiver(receiver)
                .type(type);
    }

    public static class MailDataBuilder {

        public MailDataBuilder param(
                final String field,
                final Object value
        ) {
            this.params.put(field, value);
            return this;
        }

        public MailDataBuilder params(
                final Properties params
        ) {
            this.params = params;
            return this;
        }

        public MailDataBuilder type(
                final Type type
        ) {
            this.type = type;
            return this;
        }

        public MailData build() {
            return new MailData(
                    receiver,
                    type,
                    params
            );
        }

    }

}

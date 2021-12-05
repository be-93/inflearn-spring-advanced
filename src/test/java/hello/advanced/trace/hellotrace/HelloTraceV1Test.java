package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloTraceV1Test {

    @Test
    public void begin_end() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus hello = trace.begin("hello");
        trace.end(hello);
    }

    @Test
    public void begin_exception() {
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus status = trace.begin("hello");
        trace.exception(status, new IllegalArgumentException());
    }

}
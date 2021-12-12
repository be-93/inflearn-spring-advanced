package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    @DisplayName("전략 패턴 적용")
    public void strategyV1() {
        final ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    @Test
    @DisplayName("전략 패턴 적용 - 익명 내부 클래스")
    public void strategyV2() {
        final ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 - 비즈니스 로직 1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("익명 - 비즈니스 로직 2 실행");
            }
        });
    }

    @Test
    @DisplayName("전략 패턴 적용 - 람다")
    public void strategyV3() {
        final ContextV2 context = new ContextV2();
        context.execute(() -> method());
        context.execute(() -> log.info("익명 - 비즈니스 로직 2 실행"));
    }

    public void method() {
        log.info("메소드 전달 - 비즈니스 로직 1 실행");
    }
}

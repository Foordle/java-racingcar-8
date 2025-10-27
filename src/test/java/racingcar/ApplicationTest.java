package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트_1() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트_1() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 기능_테스트_2_공동우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }


    @Test
    void 기능_테스트_3_단독우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "jun : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }


    @Test
    void 기능_테스트_4_2회시도_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    // 첫 번째 시도 (4, 3): pobi : -, woni :
                    // 두 번째 시도 (4, 4): pobi : --, woni : -
                    assertThat(output()).contains("pobi : --", "woni : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, // 1회차
                MOVING_FORWARD, MOVING_FORWARD // 2회차
        );
    }


    @Test
    void 예외_테스트_2_이름_5자_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi123,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_3_이름_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_4_이름_전체_공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_5_이름_중복() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_6_횟수_0() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_7_횟수_음수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @Test
    void 예외_테스트_8_횟수_숫자_아님() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "a"))
                        // 숫자로 변환할 수 없는 경우 NumberFormatException을 감싸서 던지는지 확인
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}


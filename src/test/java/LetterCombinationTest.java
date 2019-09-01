import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LetterCombinationTest {

    /**
     * unit test for question 1.
     * @param input input value
     * @param expected expected output
     */
    @ParameterizedTest
    @MethodSource("testCaseForCombinations")
    void letterCombinations(int[] input, String expected) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombinations(input));
        Assertions.assertEquals(expected, letterCombination.letterCombinations(input));
    }

    /**
     * question1 test case
     * @return test case stream
     */
    private static Stream<Arguments> testCaseForCombinations() {
        return Stream.of(
                Arguments.of(new int[]{2, 3}, "ad ae af bd be bf cd ce cf"),
                Arguments.of(new int[]{9}, "w x y z"),
                Arguments.of(new int[]{0}, "")

        );
    }

    /**
     * unit test for question 2.
     * @param input input value
     * @param expected expected output
     */
    @ParameterizedTest
    @MethodSource("stage2TestCase")
    void stage2Combinations(int[] input, String expected) {
        LetterCombination letterCombination = new LetterCombination();
//        System.out.println(letterCombination.letterCombinations(input));
        Assertions.assertEquals(expected, letterCombination.letterCombinations(input));
    }

    /**
     * question2 test case, support converting the digits from 0 to 99 in letters
     * @return test case stream
     */
    private static Stream<Arguments> stage2TestCase() {
        return Stream.of(
                Arguments.of(new int[]{99}, "w x y z w x y z"),
                Arguments.of(new int[]{92}, "w x y z a b c"),
                Arguments.of(new int[]{90}, "w x y z"),
                Arguments.of(new int[]{2,34}, "ad ae af ag ah ai bd be bf bg bh bi cd ce cf cg ch ci")
        );
    }





    @ParameterizedTest
    @CsvSource({"1,2,9", "5,2,7", "5,9,14"})
    void sum(int a, int b, int c) {
        LetterCombination letterCombination = new LetterCombination();

        Assertions.assertEquals(letterCombination.sum(a, b), c);
    }
}


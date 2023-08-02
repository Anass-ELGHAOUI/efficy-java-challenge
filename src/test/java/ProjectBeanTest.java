import static org.assertj.core.api.Assertions.assertThat;

import edeal.recruitment.custom.ProjectBeanCustom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProjectBeanTest {

  @ParameterizedTest
  @MethodSource("provideDurationData")
  void getDurationToString(String flag, String expectedMessage) throws ParseException {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    ProjectBeanCustom pbc1 =
        new ProjectBeanCustom(
            "Projet Recruteemnt",
            10,
            formatter.parse("02-08-2023"),
            formatter.parse("12-11-2024"),
            "GOING");

    assertThat(pbc1.getDurationToString(flag)).isEqualTo(expectedMessage);
  }

  private static Stream<Arguments> provideDurationData() {
    return Stream.of(
        Arguments.of("YEAR", "total duration of the project is 1 YEAR(s)"),
        Arguments.of("MONTH", "total duration of the project is 15 MONTH(s)"),
        Arguments.of("DAY", "total duration of the project is 468 DAY(s)"));
  }
}

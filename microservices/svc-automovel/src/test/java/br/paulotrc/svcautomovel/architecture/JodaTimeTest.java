package br.paulotrc.svcautomovel.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.GeneralCodingRules;

@AnalyzeClasses(packages = "br.paulotrc.svcautomovel")
public class JodaTimeTest {

    @ArchTest
    static ArchRule dontUseJodaTime = GeneralCodingRules.NO_CLASSES_SHOULD_USE_JODATIME;

}

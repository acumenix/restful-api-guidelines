package de.zalando.zally.rule

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CompositeRulesValidator(
        @Autowired val swaggerRulesValidator: SwaggerRulesValidator,
        @Autowired val jsonRulesValidator: JsonRulesValidator) : RulesValidator {

    override fun validate(swaggerContent: String): List<Violation> =
            swaggerRulesValidator.validate(swaggerContent) + jsonRulesValidator.validate(swaggerContent)

}

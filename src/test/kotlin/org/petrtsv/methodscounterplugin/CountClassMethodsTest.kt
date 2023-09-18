package org.petrtsv.methodscounterplugin

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import org.jetbrains.kotlin.idea.KotlinFileType
import org.jetbrains.kotlin.idea.core.moveCaret
import org.junit.Assert


class CountClassMethodsTest : BasePlatformTestCase() {
    fun testIntentionAppearsOnlyForKtClassName() {
        myFixture.configureByText(KotlinFileType.INSTANCE, """
class Foo {
  fun foo() {}
}
""".trimIndent())
        // "class" keyword
        Assert.assertEquals(myFixture.filterAvailableIntentions(CountClassMethods.HINT).size, 0)
        myFixture.editor.moveCaret(7)
        Assert.assertNotNull(myFixture.findSingleIntention(CountClassMethods.HINT))
        // function name
        myFixture.editor.moveCaret(19)
        Assert.assertEquals(myFixture.filterAvailableIntentions(CountClassMethods.HINT).size, 0)
    }

}
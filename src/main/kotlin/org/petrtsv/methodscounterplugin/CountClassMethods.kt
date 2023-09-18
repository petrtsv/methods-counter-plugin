package org.petrtsv.methodscounterplugin

import com.intellij.codeInsight.intention.IntentionAction
import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiElement
import com.intellij.util.castSafelyTo
import org.jetbrains.kotlin.psi.KtClass

class CountClassMethods : PsiElementBaseIntentionAction(), IntentionAction {
    companion object {
        const val HINT = "Count methods in a class"
    }

    override fun getFamilyName() = HINT

    override fun getText() = getFamilyName()

    override fun isAvailable(project: Project, editor: Editor?, element: PsiElement): Boolean {
        // user is pointing to a class name
        return element.parent.castSafelyTo<KtClass>()?.let { it.nameIdentifier == element } ?: false
    }

    override fun invoke(project: Project, editor: Editor?, element: PsiElement) {
        element.parent.castSafelyTo<KtClass>()?.let { classElement ->
            // we assume than the name exists for the class as we're pointing at it
            val className = classElement.name
            val dialogTitle = "Counting methods for class \"$className\""
            val dialogMessage = "Number of methods: ${classElement.body?.functions?.size}"

            Messages.showMessageDialog(project, dialogMessage, dialogTitle, Messages.getInformationIcon())
        }
    }
}
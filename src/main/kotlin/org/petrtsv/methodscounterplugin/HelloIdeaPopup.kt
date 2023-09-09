package org.petrtsv.methodscounterplugin;

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages

class HelloIdeaPopup : AnAction() {

    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT;
    }


    override fun actionPerformed(event: AnActionEvent) {
        val currentProject = event.project;
        val dlgMsg = StringBuilder(event.presentation.text + " Selected!");
        val dialogTitle = event.presentation.description;
        // If an element is selected in the editor, add info about it.
        val navigatable = event.getData(CommonDataKeys.NAVIGATABLE);
        if (navigatable != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", navigatable));
        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dialogTitle,
                Messages.getInformationIcon());
        // TODO: insert action logic here
    }

//    fun update( e : AnActionEvent) {
//        // Set the availability based on whether a project is open
//        val project = e.project;
//        e.presentation.setEnabledAndVisible(project != null);
//    }
}

package actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages
import com.intellij.openapi.vfs.VirtualFile
import org.apache.commons.io.IOUtils
import org.apache.commons.lang.StringEscapeUtils

fun findFile(baseDir: VirtualFile, filePath: String): VirtualFile? {
    return baseDir.findFileByRelativePath(filePath)
}

fun readFileContent(file: VirtualFile): String? {
    println("file.charset: ${file.charset}")
    println("IOUtils.toString(file.inputStream, file.charset): ${IOUtils.toString(file.inputStream, file.charset)}")
    return IOUtils.toString(file.inputStream, file.charset)
}

class HelloAction : AnAction() {

    override fun actionPerformed(event: AnActionEvent) {
        val currentProject = event.project!!
        val filePath = Messages.showInputDialog("Input a text file path", "read file content", null);
        val baseDir = currentProject.baseDir!!
        val targetFile = findFile(baseDir, filePath!!)
        if (targetFile !== null) {
            if (targetFile.isDirectory) {
                Messages.showInfoMessage(filePath, "file is directory")
            } else {
                val content = readFileContent(targetFile)
                Messages.showInfoMessage(StringEscapeUtils.escapeHtml(content), "file content")
            }
        } else {
            Messages.showInfoMessage(filePath, "file not found")
        }
    }

}
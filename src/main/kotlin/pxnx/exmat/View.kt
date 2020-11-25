package pxnx.exmat

import java.awt.Dimension
import java.awt.GridLayout
import java.awt.Toolkit
import java.awt.event.ActionListener
import javax.swing.JButton
import javax.swing.JDialog
import javax.swing.JFrame

class View {
    var mvm = MainViewModel()

    fun init() {
        val btn1 = JButton(mvm.getName(1000))
        val btn2 = JButton(mvm.getName(1001))
        val btn3 = JButton("btn3")

        val frame = JFrame("Exmatrikulator").apply {
            iconImage = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("appicon.png"))
            layout = GridLayout(1, 3)
            size = Dimension(300, 500)

            add(btn1)
            add(btn2)
            add(btn3)
        }

        val std = mvm.getStudent(1000)
        btn3.text = std.name

        val al1 = ActionListener {
            JDialog(frame, "Hello, you're exmatriculated! Goodbye:)", true).apply {
                setLocationRelativeTo(frame)
                size = Dimension(300, 500)
                isVisible = true
            }
        }

        btn1.addActionListener(al1)
        btn2.addActionListener(al1)
        btn3.addActionListener(al1)

        frame.isVisible = true
    }
}
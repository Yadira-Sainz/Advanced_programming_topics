/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editorDeTexto;

/**
 *
 * @author yadira
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FontChooser extends JDialog {

    private final JList<String> fontList;
    private final DefaultListModel<String> fontListModel;
    private Font selectedFont = null;

    public FontChooser(java.awt.Frame parent) {
        super(parent, "Seleccionar tipo de letra", true);
        setLayout(new BorderLayout());

        fontListModel = new DefaultListModel<>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            fontListModel.addElement(fontName);
        }

        fontList = new JList<>(fontListModel);
        fontList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontList.setSelectedValue("Arial", true);

        fontList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedFont = new Font(fontList.getSelectedValue(), Font.PLAIN, 12);
            }
        });

        JScrollPane scrollPane = new JScrollPane(fontList);
        add(scrollPane, BorderLayout.CENTER);

        JButton okButton = new JButton("Aceptar");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(okButton, BorderLayout.SOUTH);

        setSize(300, 300);
        setLocationRelativeTo(parent);
    }

    public Font getSelectedFont() {
        return selectedFont;
    }
}

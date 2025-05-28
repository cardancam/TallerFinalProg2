package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaDocente extends JFrame {
    public JTextField txtNombre;
    public JButton btnAgregar;
    public JTable tabla;
    public DefaultTableModel modeloTabla;

    public VistaDocente() {
        setTitle("Gestión de Docentes");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
        JPanel panelTop = new JPanel(new FlowLayout());
        txtNombre = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        panelTop.add(new JLabel("Nombre:"));
        panelTop.add(txtNombre);
        panelTop.add(btnAgregar);

        
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Nombre"}, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);

        add(panelTop, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}

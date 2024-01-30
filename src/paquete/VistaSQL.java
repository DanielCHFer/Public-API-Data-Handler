package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoRutaArchivo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSQL frame = new VistaSQL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaSQL() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 609);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setMinimumSize(new Dimension(0, 0));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(10, 10, 61));
		panelTitulo.setPreferredSize(new Dimension(930, 100));
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(new BorderLayout(0, 0));
		
		JLabel labelTitulo = new JLabel("Lector de Comics");
		labelTitulo.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 23));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setForeground(new Color(255, 255, 255));
		panelTitulo.add(labelTitulo, BorderLayout.CENTER);
		
		JPanel panelSeleccionRuta = new JPanel();
		panelSeleccionRuta.setBorder(null);
		panelSeleccionRuta.setPreferredSize(new Dimension(930, 60));
		panelSeleccionRuta.setBackground(new Color(10, 10, 61));
		contentPane.add(panelSeleccionRuta);
		panelSeleccionRuta.setLayout(null);
		
		textoRutaArchivo = new JTextField();
		textoRutaArchivo.setHorizontalAlignment(SwingConstants.CENTER);
		textoRutaArchivo.setForeground(new Color(255, 255, 255));
		textoRutaArchivo.setBackground(new Color(0, 0, 20));
		textoRutaArchivo.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		textoRutaArchivo.setBounds(60, 16, 456, 26);
		panelSeleccionRuta.add(textoRutaArchivo);
		textoRutaArchivo.setColumns(10);
		
		JButton botonBuscarArchivo = new JButton("Buscar Archivo");
		botonBuscarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.showOpenDialog(fileChooser);
				String ruta = fileChooser.getSelectedFile().getAbsolutePath();                                       
				textoRutaArchivo.setText(ruta);
			}
		});
		
		botonBuscarArchivo.setMargin(new Insets(2, 10, 2, 10));
		botonBuscarArchivo.setForeground(new Color(255, 255, 255));
		botonBuscarArchivo.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonBuscarArchivo.setBackground(new Color(128, 128, 255));
		botonBuscarArchivo.setBounds(530, 16, 121, 26);
		panelSeleccionRuta.add(botonBuscarArchivo);
		
		JCheckBox checkboxBuscarSQL = new JCheckBox("Buscar SQL");
		checkboxBuscarSQL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkboxBuscarSQL.isSelected()) {
					textoRutaArchivo.setText("BASE DE DATOS");
					botonBuscarArchivo.setEnabled(false);
				} else {
					botonBuscarArchivo.setEnabled(true);
					textoRutaArchivo.setText("");
				}
			}
		});
		
		checkboxBuscarSQL.setForeground(new Color(255, 255, 255));
		checkboxBuscarSQL.setBackground(new Color(10, 10, 61));
		checkboxBuscarSQL.setFont(new Font("Ebrima", Font.BOLD, 12));
		checkboxBuscarSQL.setBounds(658, 17, 87, 23);
		panelSeleccionRuta.add(checkboxBuscarSQL);
		
		JButton botonCargarDatos = new JButton("Cargar Datos");
		botonCargarDatos.setMargin(new Insets(2, 10, 2, 10));
		botonCargarDatos.setForeground(Color.WHITE);
		botonCargarDatos.setFont(new Font("Ebrima", Font.BOLD, 13));
		botonCargarDatos.setBackground(new Color(128, 128, 255));
		botonCargarDatos.setBounds(753, 16, 121, 26);
		panelSeleccionRuta.add(botonCargarDatos);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new EmptyBorder(15, 50, 15, 50));
		panelDatos.setPreferredSize(new Dimension(930, 300));
		panelDatos.setBackground(new Color(10, 10, 61));
		contentPane.add(panelDatos);
		panelDatos.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(64, 0, 128));
		scrollPane.setForeground(new Color(20, 36, 78));
		panelDatos.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(177, 193, 235));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "T\u00EDtulo", "Descripci\u00F3n", "N\u00BA P\u00E1ginas", "N\u00BA Publicaci\u00F3n", "Serie", "Formato", "Imagen"
			}
		));
		scrollPane.setViewportView(table);
	}
}

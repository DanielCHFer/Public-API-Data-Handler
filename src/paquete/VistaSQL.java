package paquete;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VistaSQL extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoRutaArchivo;
	private JTable table;
	
	private ArrayList<Comic> listaComicsLeidos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSQL frame = new VistaSQL();
					frame.setVisible(true);
					VistaComicIndividual vistaComic = new VistaComicIndividual();
					vistaComic.setVisible(true);
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
		setResizable(false);
		
		
		
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
		textoRutaArchivo.setEditable(false);
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
				if (ruta.endsWith(".xml") || ruta.endsWith(".json")) {
					textoRutaArchivo.setText(ruta);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, escoja un archivo .xml o .json", "Tipo de archivo no válido", JOptionPane.ERROR_MESSAGE);
				}
				
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
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(3).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(45);
		table.getColumnModel().getColumn(6).setPreferredWidth(20);
		table.getColumnModel().getColumn(7).setPreferredWidth(25);
		
		JPanel panelSeleccionRuta_1 = new JPanel();
		panelSeleccionRuta_1.setLayout(null);
		panelSeleccionRuta_1.setPreferredSize(new Dimension(930, 60));
		panelSeleccionRuta_1.setBorder(null);
		panelSeleccionRuta_1.setBackground(new Color(10, 10, 61));
		contentPane.add(panelSeleccionRuta_1);
		
		JButton btnCargarDatosApi = new JButton("Cargar Datos API");
		btnCargarDatosApi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejadorComics manejador = new ManejadorComics();
				AccesoApi accesoApi = new AccesoApi();
				
				ArrayList<Comic> comicsApi = new ArrayList<>();
				try {
					comicsApi = accesoApi.obtenerComicsApi();
				} catch (Exception e1) {
		            e1.printStackTrace();
				}
				
				if (comicsApi.size()>0) {
					manejador.insertarSQL(comicsApi);
					JOptionPane.showMessageDialog(null, "Se han cargado "+comicsApi.size()+" registros en la base de datos", "Petición API exitosa", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "No se ha podido cargar ningún registro en la base de datos", "Error API", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnCargarDatosApi.setMargin(new Insets(2, 10, 2, 10));
		btnCargarDatosApi.setForeground(Color.WHITE);
		btnCargarDatosApi.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnCargarDatosApi.setBackground(new Color(128, 128, 255));
		btnCargarDatosApi.setBounds(51, 11, 133, 32);
		
		botonCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ManejadorComics manejadorComics = new ManejadorComics();
				
				DefaultTableModel modelo = (DefaultTableModel) table.getModel();
				modelo.setRowCount(0);
				
				if (textoRutaArchivo.getText().equals("BASE DE DATOS")) {
					
					listaComicsLeidos = manejadorComics.leerSQL();
					
					for (Comic comicActual: listaComicsLeidos) {
						modelo.addRow(new Object[] {comicActual.getId(),comicActual.getTitulo(),comicActual.getDescripcion(),comicActual.getNumeroDePaginas(),comicActual.getNumeroPublicacion(),comicActual.getSerie(),comicActual.getFormato(),comicActual.getImagen()});
					}
				} else if (textoRutaArchivo.getText().endsWith(".xml")) {
					
					listaComicsLeidos = manejadorComics.leerXML(textoRutaArchivo.getText());
					for (Comic comicActual: listaComicsLeidos) {
						modelo.addRow(new Object[] {comicActual.getId(),comicActual.getTitulo(),comicActual.getDescripcion(),comicActual.getNumeroDePaginas(),comicActual.getNumeroPublicacion(),comicActual.getSerie(),comicActual.getFormato(),comicActual.getImagen()});
					}
				} else if (textoRutaArchivo.getText().endsWith(".json")) {
				
				listaComicsLeidos = manejadorComics.leerJSON(textoRutaArchivo.getText());
					for (Comic comicActual: listaComicsLeidos) {
						modelo.addRow(new Object[] {comicActual.getId(),comicActual.getTitulo(),comicActual.getDescripcion(),comicActual.getNumeroDePaginas(),comicActual.getNumeroPublicacion(),comicActual.getSerie(),comicActual.getFormato(),comicActual.getImagen()});
					}
				}
				
				if (listaComicsLeidos.size() == 0) {
					JOptionPane.showMessageDialog(null, "El archivo "+textoRutaArchivo.getText()+" no contiene ningún cómic", "Cómics no encontrados", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		panelSeleccionRuta_1.add(btnCargarDatosApi);
		
		JComboBox comboBoxTipoArchivo = new JComboBox();
		comboBoxTipoArchivo.setModel(new DefaultComboBoxModel(new String[] {"JSON", "XML", "SQL"}));
		comboBoxTipoArchivo.setBounds(599, 12, 133, 32);
		panelSeleccionRuta_1.add(comboBoxTipoArchivo);
		
		JButton btnExportarArchivo = new JButton("Exportar Archivo");
		btnExportarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManejadorComics manejador = new ManejadorComics();
				String tipoArchivo = (String) comboBoxTipoArchivo.getSelectedItem();
				String rutaNuevoArchivo = "";
				
				if (!tipoArchivo.equals("SQL")) {
					JFileChooser fileChooser = new JFileChooser(".");
	                fileChooser.setDialogTitle("Seleccione la ubicación del archivo");
	                fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
	                fileChooser.setSelectedFile(new File("comicsExportados."+tipoArchivo.toLowerCase()));
	                FileNameExtensionFilter xmlFilter = new FileNameExtensionFilter("XML files (*.xml)", "xml");
	                fileChooser.setFileFilter(xmlFilter);

	                int userSelection = fileChooser.showSaveDialog(null);

	                if (userSelection == JFileChooser.APPROVE_OPTION) {
	                    File archivoGuardar = fileChooser.getSelectedFile();

	                    rutaNuevoArchivo = archivoGuardar.getAbsolutePath();
	                }
				}
				
				if (!rutaNuevoArchivo.toLowerCase().endsWith("."+tipoArchivo.toLowerCase())) {
					rutaNuevoArchivo += "."+tipoArchivo.toLowerCase();
				}
				
				switch (tipoArchivo) {
				case "XML":
					manejador.escribirXML(listaComicsLeidos, rutaNuevoArchivo);
					JOptionPane.showMessageDialog(null, "El archivo ha sido guardado como "+rutaNuevoArchivo, "Archivo creado", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "SQL":
					manejador.insertarSQL(listaComicsLeidos);
					JOptionPane.showMessageDialog(null, "Se han insertado "+listaComicsLeidos.size()+" registros en la base de datos", "Tuplas insertadas", JOptionPane.INFORMATION_MESSAGE);
					break;
				case "JSON":
					manejador.escribirJSON(listaComicsLeidos, rutaNuevoArchivo);
					JOptionPane.showMessageDialog(null, "El archivo ha sido guardado como "+rutaNuevoArchivo, "Archivo creado", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		});
		btnExportarArchivo.setMargin(new Insets(2, 10, 2, 10));
		btnExportarArchivo.setForeground(Color.WHITE);
		btnExportarArchivo.setFont(new Font("Ebrima", Font.BOLD, 13));
		btnExportarArchivo.setBackground(new Color(128, 128, 255));
		btnExportarArchivo.setBounds(742, 11, 133, 32);
		panelSeleccionRuta_1.add(btnExportarArchivo);
	}
}

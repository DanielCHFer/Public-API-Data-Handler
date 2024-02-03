package paquete;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaIndividual extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textoTitulo;
	private JTextField textoNPaginas;
	private JTextField textoNPublicacion;
	private JTextField textoSerie;
	private JTextField textoFormato;
	private JTextField textoID;
	private JLabel labelPortada;
	JTextArea textoDescripcion;
	private ArrayList<Comic> listaComics;
	private Comic comicActual;
	
	JButton botonComicSiguiente;
	JButton botonComicAnterior;
	private JButton btnBuscarID;

	
	public VistaIndividual(ArrayList<Comic> listaComics) {
		
		this.listaComics = listaComics;
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 675);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(87, 87, 87));
		panel.setPreferredSize(new Dimension(825, 610));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nº Páginas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
		lblNewLabel.setBounds(55, 138, 126, 32);
		panel.add(lblNewLabel);
		
		textoTitulo = new JTextField();
		textoTitulo.setEditable(false);
		textoTitulo.setMargin(new Insets(2, 8, 2, 2));
		textoTitulo.setBackground(new Color(0, 0, 0));
		textoTitulo.setForeground(new Color(255, 255, 255));
		textoTitulo.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
		textoTitulo.setBounds(55, 77, 365, 32);
		panel.add(textoTitulo);
		textoTitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Título");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
		lblNewLabel_1.setBounds(55, 34, 99, 32);
		panel.add(lblNewLabel_1);
		
		textoNPaginas = new JTextField();
		textoNPaginas.setEditable(false);
		textoNPaginas.setMargin(new Insets(2, 8, 2, 2));
		textoNPaginas.setForeground(Color.WHITE);
		textoNPaginas.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
		textoNPaginas.setColumns(10);
		textoNPaginas.setBackground(Color.BLACK);
		textoNPaginas.setBounds(55, 181, 156, 32);
		panel.add(textoNPaginas);
		
		textoNPublicacion = new JTextField();
		textoNPublicacion.setEditable(false);
		textoNPublicacion.setMargin(new Insets(2, 8, 2, 2));
		textoNPublicacion.setForeground(Color.WHITE);
		textoNPublicacion.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
		textoNPublicacion.setColumns(10);
		textoNPublicacion.setBackground(Color.BLACK);
		textoNPublicacion.setBounds(264, 376, 156, 32);
		panel.add(textoNPublicacion);
		
		JLabel lblNPublicacin = new JLabel("Nº Publicación");
		lblNPublicacin.setForeground(Color.WHITE);
		lblNPublicacin.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
		lblNPublicacin.setBounds(264, 333, 156, 32);
		panel.add(lblNPublicacin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Serie");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(55, 235, 99, 32);
		panel.add(lblNewLabel_1_1);
		
		textoSerie = new JTextField();
		textoSerie.setEditable(false);
		textoSerie.setMargin(new Insets(2, 8, 2, 2));
		textoSerie.setForeground(Color.WHITE);
		textoSerie.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
		textoSerie.setColumns(10);
		textoSerie.setBackground(Color.BLACK);
		textoSerie.setBounds(55, 278, 365, 32);
		panel.add(textoSerie);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Descripción");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(55, 445, 156, 32);
		panel.add(lblNewLabel_1_1_1);
		
		textoDescripcion = new JTextArea();
		textoDescripcion.setEditable(false);
        
        textoDescripcion.setMargin(new Insets(5, 10, 10, 10));
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setBackground(new Color(0, 0, 0));
        textoDescripcion.setForeground(new Color(255, 255, 255));
        textoDescripcion.setFont(new Font("VCR OSD Mono", Font.PLAIN, 15));
        textoDescripcion.setBounds(55, 443, 719, 127);
        
        JScrollPane scrollPane = new JScrollPane(textoDescripcion);
        scrollPane.setBounds(55, 488, 680, 127);

        panel.add(scrollPane);
        getContentPane().add(panel);
        
        
        
        
        labelPortada = new JLabel();
        labelPortada.setBounds(449, 34, 279, 403);
        labelPortada.setHorizontalAlignment(JLabel.CENTER);
        labelPortada.setVerticalAlignment(JLabel.CENTER);
        panel.add(labelPortada);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Formato");
        lblNewLabel_1_1_2.setForeground(Color.WHITE);
        lblNewLabel_1_1_2.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
        lblNewLabel_1_1_2.setBounds(55, 333, 99, 32);
        panel.add(lblNewLabel_1_1_2);
        
        textoFormato = new JTextField();
        textoFormato.setEditable(false);
        textoFormato.setMargin(new Insets(2, 8, 2, 2));
        textoFormato.setForeground(Color.WHITE);
        textoFormato.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
        textoFormato.setColumns(10);
        textoFormato.setBackground(Color.BLACK);
        textoFormato.setBounds(55, 376, 156, 32);
        panel.add(textoFormato);
        
        textoID = new JTextField();
        textoID.setMargin(new Insets(2, 8, 2, 2));
        textoID.setForeground(Color.WHITE);
        textoID.setFont(new Font("VCR OSD Mono", Font.BOLD, 15));
        textoID.setColumns(10);
        textoID.setBackground(new Color(0, 0, 160));
        textoID.setBounds(264, 181, 125, 32);
        panel.add(textoID);
        
        JLabel lblId = new JLabel("ID");
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("VCR OSD Mono", Font.BOLD, 18));
        lblId.setBounds(264, 138, 126, 32);
        panel.add(lblId);
        
        botonComicAnterior = new JButton("<<<<");
        botonComicAnterior.setEnabled(false);
        botonComicAnterior.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int indiceComics = listaComics.indexOf(comicActual);
        		comicActual = listaComics.get(indiceComics-1);
        		ActualizarVista();
        	}
        });
        botonComicAnterior.setForeground(new Color(255, 255, 255));
        botonComicAnterior.setBackground(new Color(0, 0, 64));
        botonComicAnterior.setFont(new Font("Arial Black", Font.BOLD, 17));
        botonComicAnterior.setBounds(449, 448, 132, 27);
        panel.add(botonComicAnterior);
        
        botonComicSiguiente = new JButton(">>>>");
        botonComicSiguiente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int indiceComics = listaComics.indexOf(comicActual);
        		comicActual = listaComics.get(indiceComics+1);
        		ActualizarVista();
        	}
        });
        botonComicSiguiente.setBackground(new Color(0, 0, 64));
        botonComicSiguiente.setForeground(new Color(255, 255, 255));
        botonComicSiguiente.setFont(new Font("Arial Black", Font.BOLD, 17));
        botonComicSiguiente.setBounds(591, 448, 132, 27);
        panel.add(botonComicSiguiente);
        
        
        
        ImageIcon icon = new ImageIcon("img/lupa.png");
        Image image = icon.getImage().getScaledInstance(33, 32, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        
        btnBuscarID = new JButton(scaledIcon);
        btnBuscarID.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		comicActual = listaComics.get(buscarPosicion(textoID.getText()));
        		ActualizarVista();
        	}
        });
        btnBuscarID.setBounds(387, 181, 33, 32);
        panel.add(btnBuscarID);
        
        //cargarImagenes();
        
        comicActual = this.listaComics.get(0);
        ActualizarVista();
	}
	
	private void ActualizarVista() {
		
		textoTitulo.setText(comicActual.getTitulo());;
		textoNPaginas.setText(comicActual.getNumeroDePaginas());;
		textoNPublicacion.setText(comicActual.getNumeroPublicacion());;
		textoSerie.setText(comicActual.getSerie());;
		textoFormato.setText(comicActual.getFormato());;
		textoID.setText(comicActual.getId());;
		textoDescripcion.setText(comicActual.getDescripcion());
		
		URL url = null;
		try {
			url = new URL(comicActual.getImagen());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        ImageIcon icon = new ImageIcon(url);
        Image image = icon.getImage().getScaledInstance(279, 403, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
		
		labelPortada.setIcon(scaledIcon);;
		
		if (listaComics.indexOf(comicActual) + 1 == listaComics.size()) {
			botonComicSiguiente.setEnabled(false);
		} else {
			botonComicSiguiente.setEnabled(true);
		}
		
		if (listaComics.indexOf(comicActual) == 0) {
			botonComicAnterior.setEnabled(false);
		} else {
			botonComicAnterior.setEnabled(true);
		}
	}
	
	private void cargarImagenes() {
		for (Comic comicActual: listaComics) {
			URL url = null;
			try {
				url = new URL(comicActual.getImagen());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        ImageIcon icon = new ImageIcon(url);
	        Image image = icon.getImage().getScaledInstance(279, 403, Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(image);
			
			labelPortada.setIcon(scaledIcon);;
		}
	}
	
	private int buscarPosicion(String id) {
		int posicion = listaComics.indexOf(comicActual);
		for (Comic comic: listaComics) {
			if (comic.getId().equals(id)) {
				posicion = listaComics.indexOf(comic);
			}
		}
		return posicion;
	}
}

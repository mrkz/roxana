package com.vcities.ui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Interfaz
extends JFrame
implements ActionListener, ItemListener
{
	private static final long serialVersionUID = 1L;
	
	private JButton botonNuevaSimulacion;
	private JButton botonCargarSimulacion;
	
	private JMenuBar barraMenu;
	private JMenu menu;
	private JMenuItem guardarEstadoCiudad;
	private JMenuItem cargarEstadoCiudad;
	private JMenuItem nuevoEstadoCiudad;

	private VirtualCities vcities;
	
	public Interfaz()
	{
		crearUI();
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setResizable( true );
		setTitle( "Testing" );
		setSize(200, 100);
		setVisible( true );
		requestFocus();
	}
	
	private void crearUI()
	{
		barraMenu = new JMenuBar();
		menu = new JMenu("Ciudad");
		guardarEstadoCiudad = new JMenuItem("Guardar");
		cargarEstadoCiudad = new JMenuItem("Cargar");
		nuevoEstadoCiudad = new JMenuItem("Nuevo");
		
		nuevoEstadoCiudad.addActionListener(this);
		guardarEstadoCiudad.addActionListener(this);
		cargarEstadoCiudad.addActionListener(this);
		
		menu.add(nuevoEstadoCiudad);
		menu.add(guardarEstadoCiudad);
		menu.add(cargarEstadoCiudad);
		barraMenu.add(menu);
		setJMenuBar(barraMenu);
		
		botonCargarSimulacion = new JButton("Cargar");
		botonNuevaSimulacion = new JButton("Nuevo");
		
		botonCargarSimulacion.addActionListener(this);
		botonNuevaSimulacion.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(botonNuevaSimulacion);
		add(botonCargarSimulacion);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String accion = e.getActionCommand();
		System.out.println(accion);
		switch(accion)
		{
			case "Nuevo":
				vcities = new VirtualCities();
				
				break;
				
			case "Guardar":
				if(vcities != null)
				{
					//TODO: Guardado en modo ontologia
				}
				break;
			
			case "Cargar":
				//TODO: Cargar una ontologia
				break;
		}
		
		if(vcities != null)
		{
			remove(botonCargarSimulacion);
			remove(botonNuevaSimulacion);
			setLayout(new GridLayout());
			add(vcities);
			pack();
			
			vcities.iniciar();
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		
	}
	
}

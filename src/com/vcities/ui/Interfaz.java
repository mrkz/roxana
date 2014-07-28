package com.vcities.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Interfaz
extends JFrame
implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JButton botonNuevaSimulacion;
	private JButton botonCargarSimulacion;
	
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
		remove(botonCargarSimulacion);
		remove(botonNuevaSimulacion);
		
		String accion = e.getActionCommand();
		
		switch(accion)
		{
			case "Nuevo":
				vcities = new VirtualCities();
				break;
			
			case "Cargar":
				break;
		}
		
		add(vcities);
		pack();
		
		vcities.iniciar();
	}
	
}

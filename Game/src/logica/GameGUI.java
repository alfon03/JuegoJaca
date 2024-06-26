package logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import procedimientos.*;

public class GameGUI extends Game implements ActionListener {

	private JButton[][] botones; // Matriz de botones
	private JFrame ventana; // Ventana que se utilizará para el gráfico. Esta ventana
	// se divide en el panel superior y el panel del juego
	private JPanel panelSuperior; // Panel superior para mostrar la información
	private JLabel informacion; // Etiqueta que se muestra en el panel superior para mostrar la información
	private JPanel panelJuego; // Panel para mostrar los botones

	public GameGUI(PlayerType[] jugadores) throws GameException {
		super(jugadores);

		// Crea el JFrame que es la ventana. Le pongo el nombre y el botón de cerrar
		ventana = new JFrame("Jaca Juego");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Crea el panel superior donde pondremos información del juego
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.BLUE);
		panelSuperior.setPreferredSize(new Dimension(200, 350));
		informacion = new JLabel("");
		informacion.setForeground(Color.WHITE);
		panelSuperior.add(informacion);

		ventana.add(panelSuperior, BorderLayout.NORTH);

		// Crea el panel del juego
		panelJuego = new JPanel();
		Dimension d = new Dimension(50, 50);

		// Crea una matriz para guardar los botones que se añaden
		botones = new JButton[Constans.TAMANNO][Constans.TAMANNO];
		// Crea un GridLayout para organizar los botones en forma de matriz
		panelJuego.setLayout(new GridLayout(Constans.TAMANNO, Constans.TAMANNO));
		// Crea los botones y los añade al panelJuego
		for (int j = 0; j < Constans.TAMANNO; j++) {
			for (int i = 0; i < Constans.TAMANNO; i++) {
				JButton button1 = new JButton();
				button1.setPreferredSize(d);
				// Le pone el icono correspondiente al botón
				this.asignarIcono(button1, i, j);
				// Le asigna el tamaño
				button1.setMaximumSize(new Dimension(50, 50));
				// Le añade un Listener para que cuando se haga clic lance el listener
				button1.addActionListener((ActionListener) this);
				// Lo añade al panelJuego
				panelJuego.add(button1);
				// Lo guarda en la matriz de botones para luego buscarlo cuando
				// el listener nos avise que se ha hecho clic sobre un botón.
				botones[i][j] = button1;
			}
		}

		ventana.add(panelJuego, BorderLayout.SOUTH);

		// Lanza el dado del jugador que le toca jugar
		super.setDado();
		// Muestra la información
		setInformacion();

		ventana.pack();
		ventana.setVisible(true);

		// Muestra ventana con el jugador que le toca jugar y el número que le ha salido
		// en el dado.

		JOptionPane.showMessageDialog(ventana, "Le toca al jugador " + super.getNombrePlayerQueJuega()
				+ ". El dado saca " + super.getValorDado() + " movimientos");
	}

	// Devuelve el icono correspondiente según el elemento
	private void asignarIcono(JButton button, int x, int y) {
		ImageIcon imageIcon;
		
		// Si no hay nada se pone el elemento por defecto
		if (super.obtenerElementoTablero(new Coordinate(x, y)) == null) {
			imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/nada.png");
		} else {
			switch (super.obtenerElementoTablero(new Coordinate(x, y)).getTipo().getSimbolo()) {
			case 'D':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/rupia1.gif");
				break;
			case 'P':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Potion.gif");
				break;
			case 'R':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Rock.png");
				break;
			case 'Y':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/diamante.gif");
				break;
			case 'E':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Elfo_legolas.gif");
				break;
			case 'G':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Guerrero.gif");
				break;
			case 'M':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Mago.gif");
				break;
			case 'O':
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/Ganon_ogro.gif");
				break;
			default:
				imageIcon = new ImageIcon(System.getProperty("user.dir") + "/img/nada.png");
				break;
			}
		}

		button.setIcon(imageIcon);
	}

	/**
	 * Muestra información
	 */
	public void setInformacion() {
		this.informacion.setText("<html>" + super.imprimeValoresPlayeres().replaceAll("\n", "<br>") + "<br>"
				+ super.imprimeNombrePlayeres().replaceAll("\n", "<br><br>") + "</html>");
	}

	/**
	 * Controla el juego
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Cojo el botón que han pulsado
		JButton bx = (JButton) e.getSource();
		// Busco dónde está el botón en el cuadrante de botones
		for (int i = 0; i < Constans.TAMANNO; i++) {
			for (int j = 0; j < Constans.TAMANNO; j++) {
				if (botones[i][j] == bx) { // Encuentro la Coordinate i y j donde se ha pulsado
					// Saco las Coordinates donde se encuentra el jugador
					Coordinate coord = super.obtenerCoordinatePlayerJuega();
					// Si las x son iguales, miro a ver si las y tienen una diferencia de 1
					String resul = "";
					if (i == coord.getX()) {
						if (j - coord.getY() == 1) {
							try {
								resul = super.movePlayer('S');
							} catch (GameException | PlayerException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();

							}
						} else if (j - coord.getY() == -1) {
							try {
								resul = super.movePlayer('N');
							} catch (GameException | PlayerException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						} else {
							resul = "Movimiento no permitido";
						}
					} else if (j == coord.getY()) { // Si la y es igual, miro a ver si hay una diferencia de 1 en la x
						if (i - coord.getX() == 1) {
							try {
								resul = super.movePlayer('E');
							} catch (GameException | PlayerException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						} else if (i - coord.getX() == -1) {
							try {
								resul = super.movePlayer('O');
							} catch (GameException | PlayerException e1) {
								e1.printStackTrace();
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						} else {
							resul = "Movimiento no permitido";
						}
					} else {
						resul = "Movimiento no permitido";
					}
					if (resul.length() != 0) {
						JOptionPane.showMessageDialog(ventana, resul, "Info", JOptionPane.ERROR_MESSAGE);
					}
					setInformacion();
					super.decrementaDado();
				}
			}
		}

		if (super.isTerminado()) {
			JOptionPane.showMessageDialog(ventana, "Juego terminado. El ganador es: " + super.getNombrePlayerQueJuega());
			System.exit(0);
		}

		actualizarIconos();
		if (super.getValorDado() <= 0) {
			super.proximoPlayer();
			super.setDado();
			setInformacion();
			JOptionPane.showMessageDialog(ventana, "Le toca al jugador " + super.getNombrePlayerQueJuega()
					+ ". El dado saca " + super.getValorDado() + " movimientos");
		}
	}

	/**
	 * Actualizar iconos, necesario cuando se cambia de casillas algún jugador.
	 */
	private void actualizarIconos() {
		for (int i = 0; i < Constans.TAMANNO; i++) {
			for (int j = 0; j < Constans.TAMANNO; j++) {
				asignarIcono(botones[i][j], i, j);
			}
		}
	}
}

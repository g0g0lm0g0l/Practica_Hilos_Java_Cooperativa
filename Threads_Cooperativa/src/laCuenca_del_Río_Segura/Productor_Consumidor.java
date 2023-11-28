package laCuenca_del_Río_Segura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Productor_Consumidor {
	private static final int THREAD_SLEEP_MIN = 1000; // 1 second
	private static final int THREAD_SLEEP_MAX = 2000; // 2 second
	private static final int NUM_AGRICIULTORES = 3;
	private static final int NUM_CLIENTES = 3;
	private static final int CAPACIDAD_ALMACEN = 200;

	public static void main(String[] args) {

		List<Integer> almacen = new ArrayList<Integer>();
		Random random = new Random();

		argicultores(almacen, random);
		clientes(almacen, random);
		

	}

	private static void clientes(List<Integer> almacen, Random random) {
		for (int j = 0; j < NUM_CLIENTES; j++) {
			Thread cliente = new Thread(() -> {
				while (true) {
				synchronized (almacen) {
						try {
							int cajasComprar = random.nextInt(5) + 5;
							if (almacen.size() > cajasComprar) {
								for (int l = 0; l < cajasComprar; l++) {
									almacen.remove(almacen.size() - 1);
								}
								System.out.println("Cliente ha comprado\t"
										+ cajasComprar + "\ten el almacen hay: " + almacen.size() + " cajas ");
								System.out.println(
										"Cliente " + Thread.currentThread().getId() + " el cliente la lleva a casa ");
								Thread.sleep(random.nextLong(THREAD_SLEEP_MIN, THREAD_SLEEP_MAX));
								almacen.notifyAll();
							} else {
								System.out.println(
										"Cliente " + Thread.currentThread().getId() + " no puede comprar las cajas");
								almacen.wait();
							}
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							System.err.println("Agricultor " + Thread.currentThread().getId()
									+ " interrumpido durante la espera.");
							e.printStackTrace();
						}
					}
				}

			});
			cliente.start();

		}
	}

	private static void argicultores(List<Integer> almacen, Random random) {
		for (int i = 0; i < NUM_AGRICIULTORES; i++) {
			Thread agricultor = new Thread(() -> {
					while (true) {
						synchronized (almacen) {
						try {
							int cajasEntregar = random.nextInt(10) + 10;
							if ((almacen.size() + cajasEntregar) < CAPACIDAD_ALMACEN) {
								for (int k = 0; k < cajasEntregar; k++) {
									almacen.add(k);
								}
								System.out.println("Agricultor ha entregado \t"
										+ cajasEntregar + "\ten el almacen hay: " + almacen.size() + " cajas");
								System.out.println("Agricultor vuelve a su huerta para recoger el siguiente envío");
								almacen.notifyAll();
								Thread.sleep(random.nextLong(THREAD_SLEEP_MIN, THREAD_SLEEP_MAX));
							} else {
								System.out.println("Agricultor " + Thread.currentThread().getId()
										+ " espera hasta que haya suficiente especio.");
								almacen.wait();
							}
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							System.err.println("Agricultor " + Thread.currentThread().getId()
									+ " interrumpido durante la espera.");
							e.printStackTrace();
						}
					}
				}

			});
			agricultor.start();
		}
	}

}

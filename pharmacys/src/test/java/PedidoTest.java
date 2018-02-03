/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.taller.pharmacys.Cliente;
import com.taller.pharmacys.Producto;
import com.taller.pharmacys.DetallePedido;
import com.taller.pharmacys.Pago; 
import com.taller.pharmacys.Pedido;
import com.taller.pharmacys.TarjetaCredito;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Stephany
 */
public class PedidoTest {
    
    private static ArrayList<Producto> catalogo;
    private static ArrayList<DetallePedido> carrito;
    
    public static void initCatalogo() {
        
       
        catalogo = new ArrayList<Producto>();
        carrito = new ArrayList<DetallePedido>();
        
        Producto producto1 = new Producto("Dicloflenaco","Medicina",4,1,10.5);
        Producto producto2 = new Producto("Buscapina","Medicina",20,5,5.6);
        Producto producto3 = new Producto("Analgan","Medicina",10,2,2.50);
        Producto producto4 = new Producto("Redoxon","Medicina",30,5,7.80);
        
        catalogo.add(producto1);
        catalogo.add(producto2);
        catalogo.add(producto3);
        catalogo.add(producto4);
    }
    
    
    public Producto obtenerProductoCatalogo(ArrayList<Producto> productos, String clave){
        Producto encontrado = null;
        
        for (Producto producto : productos) {
             if(producto.getNombre().equals(clave))
                 encontrado = producto;
            }
        return encontrado;
    
    }
    
    @Before
    public void beforeEachTest() {
        initCatalogo();
    }

    @After
    public void afterEachTest() {
      
    }
    
    @Test
    public void testIntegracionProductoCatalogo() {
        System.out.println("----Test 1----"); 
        System.out.println("\n(INICIAL) El catálogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString());
        Producto producto5 = new Producto("Ciprofloxacina","Medicina",50,15,11.42);
        String resultado = producto5.crear_producto();
        catalogo.add(producto5);
        System.out.println("\n(FIN) El catálogo de la farmacia es: " + catalogo.size());
        System.out.println(catalogo.toString()); 
        
        assertEquals("Se creo el producto exitosamente!", resultado); //experado,obtenido
        
    }
    
    @Test  
    public void testIntegracionCatalogoCarrito() {
        System.out.println("----Test 2----");        
        Producto p = obtenerProductoCatalogo(catalogo,"Redoxon"); //simulo que lo agrego al carrito
        DetallePedido detalle1 = new DetallePedido(p,5); //Simulo que selecciono 5
        carrito.add(detalle1);
        //visualizar el pedido con los productos seleccionados.
        System.out.println("*******Carrito*****");
        System.out.println(carrito.toString());
        assertEquals(1, carrito.size()); //experado,obtenido 
    }
    
    @Test  
    public void testIntegracionValidarHorario() throws ParseException {
        Double total = 0.0;
        System.out.println("----Test 3----");       
        //Ingresa el cliente que va realizar la transaccion
        Cliente cliente=new Cliente("Juan", 1);
        System.out.println(cliente.getInformacionCliente());
        //Selecciona los productos del catalogo y los arregla al carrito
        Producto p1 = obtenerProductoCatalogo(catalogo,"Analgan");
        Producto p2 = obtenerProductoCatalogo(catalogo,"Buscapina");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
        //Da click en el carrito para pagar
        //Se obtiene la hora de la venta
        SimpleDateFormat sdfejemplo = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String stringfecha = "02-02-2018 8:00:00";
        Date fecha = sdfejemplo.parse(stringfecha);
        //Se crea el pedido
        Pedido pedido = new Pedido(carrito,fecha,cliente);
        
        //Se crea el pago
        Pago metodoPago = new Pago();
        metodoPago.crearPago(true);
        
        //visualizar el pedido con los productos seleccionados.
        System.out.println(carrito.toString());
        Double recargo = pedido.getRecargo(cliente, carrito.size());
        Double subtotal = pedido.getSubTotalPedido();
        total = subtotal + recargo;
        System.out.println("Valor del recargo = " + recargo);
        System.out.println("Subtotal=" + subtotal );
        System.out.println("Total=" + total);
        
        System.out.println("#####");
        assertEquals("Horario disponible", pedido.validarHora());//experado,obtenido
        System.out.println("#####");
        
//        TarjetaCredito tarjeta = new TarjetaCredito(2,"510510510510511","012");
//        metodoPago.asociarTarjeta(tarjeta);
//        System.out.println(tarjeta.validarTarjeta());
        
    
    }
    
    @Test  
    public void testIntegracionValidarPedido() throws ParseException {
        Double total = 0.0;
        System.out.println("----Test 4----");       
        //Ingresa el cliente que va realizar la transaccion
        Cliente cliente=new Cliente("Juan", 1);
        System.out.println(cliente.getInformacionCliente());
        //Selecciona los productos del catalogo y los arregla al carrito
        Producto p1 = obtenerProductoCatalogo(catalogo,"Analgan");
        Producto p2 = obtenerProductoCatalogo(catalogo,"Buscapina");
        DetallePedido detalle1 = new DetallePedido(p1,1);
        DetallePedido detalle2 = new DetallePedido(p2,1);
        carrito.add(detalle1);
        carrito.add(detalle2);
        //Da click en el carrito para pagar
        //Se obtiene la hora de la venta
        SimpleDateFormat sdfejemplo = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String stringfecha = "02-02-2018 8:00:00";
        Date fecha = sdfejemplo.parse(stringfecha);
        //Se crea el pedido
        Pedido pedido = new Pedido(carrito,fecha,cliente);
        
        System.out.println("Pedido Valido:" + pedido.confirmarPedido(pedido));//
        
        //Se crea el pago
        Pago metodoPago = new Pago();
        metodoPago.crearPago(true);
        
        //visualizar el pedido con los productos seleccionados.
        System.out.println(carrito.toString());
        Double recargo = pedido.getRecargo(cliente, carrito.size());
        Double subtotal = pedido.getSubTotalPedido();
        total = subtotal + recargo;
        System.out.println("Valor del recargo = " + recargo);
        System.out.println("Subtotal=" + subtotal );
        System.out.println("Total=" + total);
        
        System.out.println("#####");
        assertEquals("Horario disponible", pedido.validarHora());//experado,obtenido
        System.out.println("#####");
        
        TarjetaCredito tarjeta = new TarjetaCredito(2,"5105105105105100","012");
        metodoPago.asociarTarjeta(tarjeta);
        System.out.println("Tarjete Valida: "+tarjeta.validarTarjeta());
        
    
    }
    

    
}
    
 


import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        String response = "";
        ArrayList<Producto> listaCompra = new ArrayList<>();
        while (!response.equals("0") || response.equals("salir")) {
            System.out.println("Bienvenido a tu carrito de la compra. Selecciona una acción:"+ "\n" +
            "1.Añadir" + "\n" + "2.Modificar" + "\n" + "3.Borrar" + "\n" + "4.Buscar" + "\n" + "5.Detalles" + "\n" + "6.Mover" + "\n" + "7.Precio final" + "\n" + "0.Salir");
            response = teclado.nextLine().toLowerCase();
            switch (response) {
                case "1":
                case "añadir":
                        System.out.println("Introduce el nombre del producto.");
                        String producto = teclado.nextLine();
                        System.out.println("Introduce el precio.");
                        double precio = Double.valueOf(teclado.nextLine());
                        System.out.println("Introduce el peso");
                        double peso = Double.valueOf(teclado.nextLine());
                        System.out.println("Introduce la tienda donde comprarlo.");
                        String tienda = teclado.nextLine();
                        listaCompra.add(new Producto(producto, precio, peso, tienda));
                        System.out.println("Se ha añadido " + producto + " a la lista.");
                    break;
                case "2":
                case "modificar":
                    System.out.println("Introduce el número del producto que quieres modificar:");
                    imprimirLista(listaCompra);   
                    int index = Integer.parseInt(teclado.nextLine());
                    if (comprobacionCorrecta(listaCompra, index)){
                        System.out.println("¿Qué parte del producto quieres modificar? Nombre/Precio/Kg/Tienda");
                         String aModificar = teclado.nextLine().toLowerCase();
                         switch (aModificar) {
                            case "nombre":
                                 System.out.println("Introduce el nuevo nombre para el producto.");
                                 listaCompra.get(index-1).setNombre(teclado.nextLine());
                                break;
                            case "precio":
                                System.out.println("Introduce el nuevo precio para el producto.");
                                listaCompra.get(index-1).setPrecio(Double.parseDouble(teclado.nextLine()));        
                                break;
                            case "kg":
                            case "kilos":
                            case "kilogramos":
                                System.out.println("Introduce los kg para el producto.");
                                listaCompra.get(index-1).setKg(Double.parseDouble(teclado.nextLine()));
                                break;
                            case "tienda":
                                System.out.println("Introduce la nueva tienda para el producto.");
                                listaCompra.get(index-1).setTienda(teclado.nextLine());
                                break;
                            default:
                            System.out.println("Respuesta inválida.");
                                break; 
                    
                            }
                    }
                    break;
                case "3":
                case "borrar":                
                    System.out.println("Introduce el número del producto que quieres borrar");
                    imprimirLista(listaCompra);  
                    int nBorrar = Integer.parseInt(teclado.nextLine());
                    if (comprobacionCorrecta(listaCompra, nBorrar)){
                        listaCompra.remove(nBorrar-1);
                    }
                    break;
                case "4":
                case "buscar":
                    System.out.println("Escribe el producto que quieres buscar el la lista.");
                    String productoBuscar = teclado.nextLine();
                    Producto encontrado = null;
                    int searchIndex = 0;
                    for (int i = 0; i<listaCompra.size(); i++){
                        if (listaCompra.get(i).getNombre().equalsIgnoreCase(productoBuscar)){
                            encontrado = listaCompra.get(i);
                            searchIndex = i + 1;
                        };
                    }
                    if (encontrado == null){
                        System.out.println("No se ha encontrado " + productoBuscar + " en tu lista de la compra.");
                    } else{
                        System.out.println("Se ha encontrado el producto " + encontrado.getNombre() + " en tu lista de la compra, en la posición " + searchIndex);
                    }
                    break;
                case "5":
                case "detalles":
                    System.out.println("Introduce el nº de producto sobre el que quieres más detalles.");
                    int detallesProducto = Integer.parseInt(teclado.nextLine());
                    if (comprobacionCorrecta(listaCompra, detallesProducto)){
                        System.out.println(listaCompra.get(detallesProducto-1).toString());
                    }
                    break;
                case "6":
                case "mover":
                    System.out.println("Qué producto quieres mover?");
                    int moverIndex = Integer.parseInt(teclado.nextLine());
                    if (comprobacionCorrecta(listaCompra, moverIndex)){
                        System.out.println("A qué posición lo quieres mover?");
                        int moverIndex2 = Integer.parseInt(teclado.nextLine());
                        if (comprobacionCorrecta(listaCompra, moverIndex2)){
                            Producto elementoAMover = listaCompra.get(moverIndex-1);
                            listaCompra.remove(moverIndex-1);
                            listaCompra.add(moverIndex2-1, elementoAMover);
                        }
                    }
                    break;
                case "7":
                case "precio final":
                    System.out.println("¿De qué producto quieres ver el precio final?");
                    int precioFinalIndex = Integer.parseInt(teclado.nextLine());
                    if (comprobacionCorrecta(listaCompra, precioFinalIndex)){
                        System.out.println(listaCompra.get(precioFinalIndex-1).PrecioFinal());
                    }
                    break;
                case "0":
                case "salir":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                System.out.println("Lo siento, no he entendido tu respuesta.");
                    break;  
            }
            imprimirLista(listaCompra);
        }
        teclado.close();
    }
    public static void imprimirLista(ArrayList<Producto> lista){
        System.out.println("//////////////////");
        for (int i = 0; i<lista.size(); i++){
            System.out.println(i+1 + ". " + lista.get(i).getNombre());
        }
        System.out.println("//////////////////");
    }
    public static boolean comprobacionCorrecta(ArrayList<Producto> lista, int userIndex){
        if (userIndex > lista.size()){
            System.out.println("No existe ese elemento en la lista.");
            return false;
        } else if(userIndex>0){
            return true;
        } else {
            System.out.println("Número no reconocido.");
            return false;
        }
    }
}

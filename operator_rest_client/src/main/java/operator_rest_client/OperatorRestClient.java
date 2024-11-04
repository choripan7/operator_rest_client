package operator_rest_client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OperatorRestClient {
    private static final String API_URL_ASIGNAR_TURNO = "http://localhost:8080/api/turnos/asignar";
    private static final String API_URL_CAMBIAR_PUESTO = "http://localhost:8080/api/turnos/cambiarPuesto";
    private static final String API_URL_ATENDER = "http://localhost:8080/api/turnos/atender";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menú:");
            System.out.println("1 - Asignar turno");
            System.out.println("2 - Cambiar puesto de atención");
            System.out.println("3 - Atender");
            System.out.println("4 - Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    asignarTurno(scanner);
                    break;
                case 2:
                    cambiarPuesto(scanner);
                    break;
                case 3:
                    atenderTurno(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida, intenta nuevamente.");
            }
        }
    }

    private static void asignarTurno(Scanner scanner) {
        System.out.print("Ingresa CUIL: ");
        String cuil = scanner.nextLine();
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa apellido: ");
        String apellido = scanner.nextLine();

        Turno nuevoTurno = new Turno();
        nuevoTurno.setCuil(cuil);
        nuevoTurno.setNombre(nombre);
        nuevoTurno.setApellido(apellido);

        enviarPost(API_URL_ASIGNAR_TURNO, nuevoTurno);
    }

    private static void cambiarPuesto(Scanner scanner) {
        System.out.print("Ingresa número de turno: ");
        int numeroTurno = scanner.nextInt();
        System.out.print("Ingresa nuevo puesto de atención: ");
        int puestoAtencion = scanner.nextInt();

        Turno cambioPuesto = new Turno();
        cambioPuesto.setNumeroTurno(numeroTurno);
        cambioPuesto.setPuestoAtencionAsignado(puestoAtencion);

        enviarPost(API_URL_CAMBIAR_PUESTO, cambioPuesto);
    }

    private static void atenderTurno(Scanner scanner) {
        System.out.print("Ingresa número de turno: ");
        int numeroTurno = scanner.nextInt();
        System.out.print("Estado pendiente (1 o 0): ");
        int pendiente = scanner.nextInt();
        System.out.print("Estado llamado (1 o 0): ");
        int llamado = scanner.nextInt();

        Turno atenderTurno = new Turno();
        atenderTurno.setNumeroTurno(numeroTurno);
        atenderTurno.setPendiente(pendiente);
        atenderTurno.setLlamado(llamado);

        enviarPost(API_URL_ATENDER, atenderTurno);
    }

    private static void enviarPost(String url, Turno turno) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(turno);
            post.setEntity(new StringEntity(json));
            post.setHeader("Content-Type", "application/json");

            try (CloseableHttpResponse response = httpClient.execute(post);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                System.out.println("Respuesta de la API: " + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
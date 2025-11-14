package App;

import Dao.GenericDao;
import Daoimplement.MascotaDao;
import Daoimplement.MicrochipDao;
import Service.MascotaServiceImpl;
import Service.MicrochipServiceImpl;
import entities.Mascota;
import entities.Microchip;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppMenu {

    private final MascotaServiceImpl mascotaService;
    private final MicrochipServiceImpl microchipService;
    private final Scanner sc = new Scanner(System.in);

    public AppMenu() {
        GenericDao<Mascota> mascotaDao = new MascotaDao();
        GenericDao<Microchip> microchipDao = new MicrochipDao();

        this.mascotaService = new MascotaServiceImpl(mascotaDao);
        this.microchipService = new MicrochipServiceImpl(microchipDao);
    }

    public void run() {
        String op;
        do {
            mostrarMenu();
            op = sc.nextLine().trim().toUpperCase();

            try {
                switch (op) {
                    // CRUD Mascota
                    case "1" -> crearMascota();
                    case "2" -> listarMascotas();
                    case "3" -> verMascotaPorId();
                    case "4" -> actualizarMascota();
                    case "5" -> eliminarMascota();

                    // Transacción A + B (Tx)
                    case "6" -> crearMascotaConChipTx();

                    // CRUD completo de Microchip
                    case "7" -> crearMicrochipTxParaMascota();
                    case "8" -> listarMicrochips();
                    case "9" -> verMicrochipPorId();
                    case "10" -> actualizarMicrochip();
                    case "11" -> eliminarMicrochip();

                    // Búsqueda por campo relevante
                    case "12" -> buscarMicrochipPorCodigo();

                    case "X" -> System.out.println("Saliendo de la aplicación...");
                    default -> System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (!op.equals("X"));
    }

    private void mostrarMenu() {
        System.out.println("\n=:=:=:= MENÚ MASCOTAS & MICROCHIPS =:=:=:=");
        System.out.println(" MASCOTAS (A)");
        System.out.println(" 1) Crear mascota");
        System.out.println(" 2) Listar mascotas");
        System.out.println(" 3) Ver mascota por ID");
        System.out.println(" 4) Actualizar mascota");
        System.out.println(" 5) Eliminar mascota (lógico)");
        System.out.println(" 6) Crear mascota + microchip (Tx)");
        System.out.println();
        System.out.println(" MICROCHIPS (B)");
        System.out.println(" 7) Crear microchip para mascota existente (Tx)");
        System.out.println(" 8) Listar microchips");
        System.out.println(" 9) Ver microchip por ID");
        System.out.println("10) Actualizar microchip");
        System.out.println("11) Eliminar microchip (lógico)");
        System.out.println();
        System.out.println(" BÚSQUEDAS");
        System.out.println("12) Buscar microchip por CÓDIGO");
        System.out.println("-----------------------------------------------");
        System.out.println(" X) Salir");
        System.out.print("Opción: ");
    }

    //Crud de Mascota

    private void crearMascota() throws Exception {
        Mascota m = new Mascota();

        System.out.print("Nombre: ");
        m.setNombre(sc.nextLine().trim());

        System.out.print("Especie (PERRO/GATO/AVE/OTRO): ");
        m.setEspecie(sc.nextLine().trim().toUpperCase());

        System.out.print("Raza: ");
        m.setRaza(sc.nextLine().trim());

        System.out.print("Dueño: ");
        m.setDuenio(sc.nextLine().trim());

        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        m.setFechaNacimiento(LocalDate.parse(sc.nextLine().trim()));

        m.setEliminado(false);

        mascotaService.save(m);
        System.out.println("✅ Mascota creada con ID " + m.getId());
    }

    private void listarMascotas() throws Exception {
        List<Mascota> lista = mascotaService.findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay mascotas registradas.");
            return;
        }
        for (Mascota m : lista) {
            System.out.println(m.getId() + " - " + m.getNombre()
                    + " (" + m.getEspecie() + "), dueño: " + m.getDuenio());
        }
    }

    private void verMascotaPorId() throws Exception {
        System.out.print("ID de mascota: ");
        long id = Long.parseLong(sc.nextLine().trim());
        Mascota m = mascotaService.findById(id);
        if (m == null) {
            System.out.println("No se encontró mascota con ID " + id);
        } else {
            System.out.println("ID: " + m.getId());
            System.out.println("Nombre: " + m.getNombre());
            System.out.println("Especie: " + m.getEspecie());
            System.out.println("Raza: " + m.getRaza());
            System.out.println("Dueño: " + m.getDuenio());
            System.out.println("Fecha nacimiento: " + m.getFechaNacimiento());
        }
    }

    private void actualizarMascota() throws Exception {
        System.out.print("ID de mascota a actualizar: ");
        long id = Long.parseLong(sc.nextLine().trim());
        Mascota m = mascotaService.findById(id);
        if (m == null) {
            System.out.println("No existe mascota con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre (" + m.getNombre() + "): ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isBlank()) m.setNombre(nombre);

        System.out.print("Nueva especie (" + m.getEspecie() + "): ");
        String especie = sc.nextLine().trim();
        if (!especie.isBlank()) m.setEspecie(especie.toUpperCase());

        System.out.print("Nueva raza (" + m.getRaza() + "): ");
        String raza = sc.nextLine().trim();
        if (!raza.isBlank()) m.setRaza(raza);

        System.out.print("Nuevo dueño (" + m.getDuenio() + "): ");
        String duenio = sc.nextLine().trim();
        if (!duenio.isBlank()) m.setDuenio(duenio);

        mascotaService.update(m);
        System.out.println("✅ Mascota actualizada.");
    }

    private void eliminarMascota() throws Exception {
        System.out.print("ID de mascota a eliminar (lógico): ");
        long id = Long.parseLong(sc.nextLine().trim());
        mascotaService.delete(id);
        System.out.println("✅ Mascota marcada como eliminada.");
    }

    // Transaction Mascota + Microchip

    private void crearMascotaConChipTx() throws Exception {
        Mascota m = new Mascota();

        System.out.print("Nombre: ");
        m.setNombre(sc.nextLine().trim());

        System.out.print("Especie (PERRO/GATO/AVE/OTRO): ");
        m.setEspecie(sc.nextLine().trim().toUpperCase());

        System.out.print("Raza: ");
        m.setRaza(sc.nextLine().trim());

        System.out.print("Dueño: ");
        m.setDuenio(sc.nextLine().trim());

        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        m.setFechaNacimiento(LocalDate.parse(sc.nextLine().trim()));

        m.setEliminado(false);

        Microchip c = new Microchip();
        System.out.print("Código de microchip: ");
        c.setCodigo(sc.nextLine().trim().toUpperCase());
        c.setFechaImplantacion(LocalDate.now());
        System.out.print("Veterinaria: ");
        c.setVeterinaria(sc.nextLine().trim());
        System.out.print("Observaciones: ");
        c.setObservaciones(sc.nextLine().trim());
        c.setEliminado(false);

        m.setMicrochip(c);

        mascotaService.saveTx(m);

        System.out.println("✅ Mascota y microchip creados en una sola transacción.");
        System.out.println("Mascota ID = " + m.getId());
        System.out.println("Microchip ID = " + c.getId());
    }

    // Crud de Microchip

    // Se crea chip para una mascota ya existente, usando transacción 
    private void crearMicrochipTxParaMascota() throws Exception {
        System.out.print("ID de mascota: ");
        long idMascota = Long.parseLong(sc.nextLine().trim());

        Microchip c = new Microchip();
        System.out.print("Código de microchip: ");
        c.setCodigo(sc.nextLine().trim().toUpperCase());
        c.setFechaImplantacion(LocalDate.now());
        System.out.print("Veterinaria: ");
        c.setVeterinaria(sc.nextLine().trim());
        System.out.print("Observaciones: ");
        c.setObservaciones(sc.nextLine().trim());
        c.setEliminado(false);
        c.setIdMascota(idMascota);

        microchipService.saveTx(c);
        System.out.println("✅ Microchip creado con ID " + c.getId());
    }

    private void listarMicrochips() throws Exception {
        List<Microchip> lista = microchipService.findAll();
        if (lista.isEmpty()) {
            System.out.println("No hay microchips registrados.");
            return;
        }
        for (Microchip c : lista) {
            System.out.println(c.getId() + " - " + c.getCodigo()
                    + " (Mascota ID: " + c.getIdMascota() + ")");
        }
    }

    private void verMicrochipPorId() throws Exception {
        System.out.print("ID de microchip: ");
        long id = Long.parseLong(sc.nextLine().trim());
        Microchip c = microchipService.findById(id);
        if (c == null) {
            System.out.println("No se encontró microchip con ID " + id);
        } else {
            System.out.println("ID: " + c.getId());
            System.out.println("Código: " + c.getCodigo());
            System.out.println("Fecha implantación: " + c.getFechaImplantacion());
            System.out.println("Veterinaria: " + c.getVeterinaria());
            System.out.println("Observaciones: " + c.getObservaciones());
            System.out.println("Id_mascota: " + c.getIdMascota());
        }
    }

    private void actualizarMicrochip() throws Exception {
        System.out.print("ID de microchip a actualizar: ");
        long id = Long.parseLong(sc.nextLine().trim());
        Microchip c = microchipService.findById(id);
        if (c == null) {
            System.out.println("No existe microchip con ese ID.");
            return;
        }

        System.out.print("Nuevo código (" + c.getCodigo() + "): ");
        String codigo = sc.nextLine().trim();
        if (!codigo.isBlank()) c.setCodigo(codigo.toUpperCase());

        System.out.print("Nueva veterinaria (" + c.getVeterinaria() + "): ");
        String vet = sc.nextLine().trim();
        if (!vet.isBlank()) c.setVeterinaria(vet);

        System.out.print("Nuevas observaciones (" + c.getObservaciones() + "): ");
        String obs = sc.nextLine().trim();
        if (!obs.isBlank()) c.setObservaciones(obs);

        microchipService.update(c);
        System.out.println("✅ Microchip actualizado.");
    }

    private void eliminarMicrochip() throws Exception {
        System.out.print("ID de microchip a eliminar (lógico): ");
        long id = Long.parseLong(sc.nextLine().trim());
        microchipService.delete(id);
        System.out.println("✅ Microchip marcado como eliminado.");
    }

    // Búsqueda por Código

    private void buscarMicrochipPorCodigo() throws Exception {
        System.out.print("Código de microchip: ");
        String codigo = sc.nextLine().trim().toUpperCase();

        Microchip c = microchipService.findByCodigo(codigo);
        if (c == null) {
            System.out.println("No se encontró microchip con código " + codigo);
        } else {
            System.out.println("ID: " + c.getId());
            System.out.println("Código: " + c.getCodigo());
            System.out.println("Mascota ID: " + c.getIdMascota());
        }
    }
}



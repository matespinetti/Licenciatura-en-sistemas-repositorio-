package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sistema {
    private List<Long> numeros;

    private List<Cliente> clientes;

    public Sistema() {
        this.numeros = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void agregarNumero(Long num){
        numeros.add(num);
    }

    public ClientePersonaFisica agregarPersonaFisica(String nombre, String direccion, int DNI){
        if (numeros.size() > 0){
            Long num = numeros.get(0);
            numeros.remove(0);
            ClientePersonaFisica c = new ClientePersonaFisica(nombre, direccion, num, DNI)
            clientes.add(c);
            return c;
        }

        return null;

    }

    public ClientePersonaJuridica agregarPersonaJuridica(String nombre, String direccion, int CUIT, String tipo){
        if (numeros.size() > 0){
            Long num = numeros.get(0);
            numeros.remove(0);
            ClientePersonaJuridica c = new ClientePersonaJuridica(nombre, direccion, num, CUIT, tipo);
            clientes.add(c);
            return c;
        }

        return null;

    }

    private Cliente buscarCliente(Long numero){
        return this.clientes.stream().filter(c -> c.getNumeroTelefono().equals(numero)).findFirst().orElse(null);
    }

    public LlamadaLocal registrarLlamadaLocal(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoRecibe){
        Cliente cliente = buscarCliente(telefonoLlama);
        if (cliente != null){
            LlamadaLocal l = new LlamadaLocal(comienzo, duracion, telefonoLlama, telefonoRecibe);
            cliente.agregarLlamada(l);
            return l;
        }

        return null;
    }

    public LlamaInterurbana registrarLlamadaInterurbana(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoRecibe, int distancia){
        Cliente cliente = buscarCliente(telefonoLlama);
        if (cliente != null){
            LlamaInterurbana l = new LlamaInterurbana(comienzo, duracion, telefonoLlama, telefonoRecibe, duracion);
            cliente.agregarLlamada(l);
            return l;
        }

        return null;
    }

    public LlamadaInternacional registrarLlamadaInternacional(LocalDateTime comienzo, int duracion, Long telefonoLlama, Long telefonoRecibe, String paisOrigen, String paisDestino){
        Cliente cliente = buscarCliente(telefonoLlama);
        if (cliente != null){
            LlamadaInternacional l = new LlamadaInternacional(comienzo, duracion, telefonoLlama, telefonoRecibe, paisOrigen, paisDestino);
            cliente.agregarLlamada(l);
            return l;
        }

        return null;
    }


    public Factura facturarLlamadasCliente(Cliente c, LocalDate fechaDesde, LocalDate fechaHasta){
        if (clientes.contains(c)) {
            return c.facturarLlamadas(fechaDesde, fechaHasta);
        }
        return null;
    }





}

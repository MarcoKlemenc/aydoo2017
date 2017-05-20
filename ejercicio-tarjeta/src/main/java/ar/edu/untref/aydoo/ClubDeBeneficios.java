package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class ClubDeBeneficios {

    private static final int CARACTERES_A_REMOVER = 3;

    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
    private List<Establecimiento> establecimientos
            = new ArrayList<Establecimiento>();

    public void agregar(final Cliente cliente) {

        clientes.add(cliente);
    }

    public void agregar(final Tarjeta tarjeta) {

        tarjetas.add(tarjeta);
    }

    public void agregar(final Establecimiento establecimiento) {

        establecimientos.add(establecimiento);
    }

    public Establecimiento buscarEstablecimientoConMasBeneficios() {

        int maximo = 0;
        Establecimiento establecimiento = null;
        for (Establecimiento e : establecimientos) {
            int cantidad = e.calcularTotalBeneficios();
            if (cantidad > maximo) {
                maximo = cantidad;
                establecimiento = e;
            }
        }
        return establecimiento;
    }

    public Sucursal buscarSucursalConMasBeneficios() {

        int maximo = 0;
        Sucursal sucursal = null;
        for (Establecimiento e : establecimientos) {
            for (Sucursal s : e.getSucursales()) {
                int cantidad = s.getCantidadBeneficiosOtorgados();
                if (cantidad > maximo) {
                    maximo = cantidad;
                    sucursal = s;
                }
            }
        }
        return sucursal;
    }

    private String mostrarBeneficioEnTexto(final Compra compra) {

        String establecimiento = compra.getSucursal().getEstablecimiento()
                .getNombre() + " | ";
        String productosComprados;
        if (compra.getProductosKeySet().isEmpty()) {
            productosComprados = " - ";
        } else {
            productosComprados = "";
            for (SortedMap.Entry<Producto, Integer> e : compra.getProductos()
                    .entrySet()) {
                productosComprados += e.getKey().getNombre() + " x "
                        + e.getValue() + " - ";
            }
            productosComprados = productosComprados.substring(0,
                    productosComprados.length() - CARACTERES_A_REMOVER);
        }

        String montoBruto = " | " + String.valueOf(compra.calcularMontoBruto())
                + " | ";
        String beneficio = String.valueOf(compra.calcularMontoBruto()
                - compra.calcularMontoNeto());
        return establecimiento + productosComprados + montoBruto + beneficio;
    }

    public Map<Cliente, List<String>> buscarBeneficiosObtenidos() {

        Map<Cliente, List<String>> beneficiosPorCliente
                = new HashMap<Cliente, List<String>>();
        for (Cliente c : clientes) {
            List<String> beneficiosDeCliente = new ArrayList<String>();
            for (Compra o : c.getTarjeta().getCompras()) {
                beneficiosDeCliente.add(mostrarBeneficioEnTexto(o));
            }
            if (!beneficiosDeCliente.isEmpty()) {
                beneficiosPorCliente.put(c, beneficiosDeCliente);
            }
        }
        return beneficiosPorCliente;
    }
}

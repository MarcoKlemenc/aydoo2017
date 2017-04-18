package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
    private List<Establecimiento> establecimientos
            = new ArrayList<Establecimiento>();

    public void agregar(Cliente cliente) {

        clientes.add(cliente);
    }

    public void agregar(Tarjeta tarjeta) {

        tarjetas.add(tarjeta);
    }

    public void agregar(Establecimiento establecimiento) {

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

    public List<String> buscarBeneficiosObtenidos(Cliente cliente) {

        List<String> beneficiosObtenidos = new ArrayList<String>();
        for (Compra c : cliente.getTarjeta().getCompras()) {
            beneficiosObtenidos.add(c.toString());
        }
        return beneficiosObtenidos;
    }
}

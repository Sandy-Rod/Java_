package ArquitecturaMulticapa.Servicio;

import ArquitecturaMulticapa.Dominio.Snack;

import java.util.List;

public interface IServicioSnacks {

    void addSnack(Snack snack);
    void showSnacks();
    List<Snack> getSnacks();


}

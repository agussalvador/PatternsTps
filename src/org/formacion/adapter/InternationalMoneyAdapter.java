package org.formacion.adapter;

public class InternationalMoneyAdapter implements InternationalMoneyOrganization{
    private final BancoNostrumIml bancoNostrumIml;

    public InternationalMoneyAdapter(){
        bancoNostrumIml = new BancoNostrumIml();
    }
    @Override
    public void transfer(int cantidad, String cliente) {
        bancoNostrumIml.movimiento(cliente,cantidad);
    }

    @Override
    public int state(String cliente) {
        Integer estado = bancoNostrumIml.estado(cliente);
        if (estado==null)
            return 0;
        else
            return estado;
    }
}

package com.example.juegovida.App.Tab;

public class ElementoLS <TipoDelDato> {
    private TipoDelDato data;

    public TipoDelDato getData() {
        return data;
    }

    public ElementoLS(Object data) {
        this.data = (TipoDelDato) data;
    }


}

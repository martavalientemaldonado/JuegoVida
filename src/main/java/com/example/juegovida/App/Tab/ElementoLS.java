package com.example.juegovida.App.Tab;

public class ElementoLS <TipoDelDato> {
    public TipoDelDato data;

    public TipoDelDato getData() {
        return data;
    }

    public ElementoLS(TipoDelDato data) {
        this.data = (TipoDelDato) data;
    }


}

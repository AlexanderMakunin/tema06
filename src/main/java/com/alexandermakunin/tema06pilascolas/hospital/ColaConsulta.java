package com.alexandermakunin.tema06pilascolas.hospital;

public class ColaConsulta {
    private Medico medic = new Medico();
    private Cola<Paciente> pacienteCola = new Cola<>(5);

    public ColaConsulta(Medico medic, Cola<Paciente> pacienteCola) {
        this.medic = medic;
        this.pacienteCola = pacienteCola;
    }

    public Medico getMedic() {
        return medic;
    }

    public void setMedic(Medico medic) {
        this.medic = medic;
    }

    public Cola<Paciente> getPacienteCola() {
        return pacienteCola;
    }

    public void setPacienteCola(Cola<Paciente> pacienteCola) {
        this.pacienteCola = pacienteCola;
    }

    @Override
    public String toString() {
        return "ColaConsulta{" +
                "medic=" + medic +
                ", pacienteCola=" + pacienteCola +
                '}';
    }
}

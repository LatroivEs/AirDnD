/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.session;

import com.mycompany.models.dog.Client;
import com.mycompany.models.dog.ReservaAirDnD;
import com.mycompany.models.dog.UserAirDnD;


/**
 *
 * @author AJM Session Singeltone
 */
public class AirDnDSession {
    
    private static AirDnDSession uniqueid;
    private UserAirDnD user;
    private Client clienteActivo;
    private ReservaAirDnD reservaActiva;
            
    private AirDnDSession() {}

    public synchronized static AirDnDSession getAirDnDInstance(String nombre) {
        if (uniqueid == null){
            uniqueid = new AirDnDSession();
        }
        
        return uniqueid;
    }

    public static AirDnDSession getUniqueid() {
        return uniqueid;
    }

    public static void setUniqueid(AirDnDSession uniqueid) {
        AirDnDSession.uniqueid = uniqueid;
    }

    public UserAirDnD getUser() {
        return user;
    }

    public void setUser(UserAirDnD user) {
        this.user = user;
    }

    public Client getClienteActivo() {
        return clienteActivo;
    }

    public void setClienteActivo(Client clienteActivo) {
        this.clienteActivo = clienteActivo;
    }

    public ReservaAirDnD getReservaActiva() {
        return reservaActiva;
    }

    public void setReservaActiva(ReservaAirDnD reservaActiva) {
        this.reservaActiva = reservaActiva;
    }
    
}

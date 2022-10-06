package com.api.rest.taskapp.mapper;


/* ----- UN MAPPER NOS SIRVE PARA MAPEAR UN OBJETO Y CONVERTIRLO EN OTRO ---- */

//En este caso, hemos creado el objeto task y un objeto taskDTO reduciendo los atributos.
//Para insertar un nuevo registro en la base de datos, es necesario pasarle todos los
// atributos de la clase task. Como el usuario solo va a registrar los atriubtos de la clase DTO,
// necesitamos usar el mapper para crear el objeto completo

//Parametros(Objeto de entrada I , objeto de salida O)
public interface IMapper <I, O>{

    public O mapperObject(I in);
}
function validaCompromisso(compromiso){
    var errosCompromisso = [];

    if(compromiso.titulo.length < 5 ){
        errosCompromisso.push("O titulo deve conter mais de 5 caracteres.");
    }

    if(compromiso.data.length === 0){
        errosCompromisso.push("A data de nascimento é obrigatória.");
    }

    if(compromiso.horaInicio.length === 0){
        errosCompromisso.push("O horario é obrigatório.");
    }

    if(compromiso.horaFim.length === 0){
        errosCompromisso.push("O horario final é obrigatório.");
    }

    
    return errosCompromisso; 
}
function ValidarContato(contato){
    var errosContato = [];

    if(contato.nome.length < 5 ){
        errosContato.push("O nome deve ter mais de 5 caracteres.");
    }

    if(contato.telefone.length === 0){
        errosContato.push("O telefone é obrigatório.");
    }

    if(contato.email.length < 7){
        errosContato.push("O e-mail e obrigatório.");
    }

    if(contato.endereco.length < 8){
        errosContato.push("O endereço é obrigatório.");
    }
 
    return errosContato; 
    
}
var btn = document.querySelector("#bt-Criar");

btn.addEventListener("click", function(){
   
    
    var formulario = document.querySelector("#usuario");
    var usuario = {
        nome: formulario.querySelector("#txt-nome").value,
        nascimento: formulario.querySelector("#txt-nascimento").value,
        sexo: formulario.querySelector("#txt-sexo").value,
        email: formulario.querySelector("#txt-email").value,
        senha: formulario.querySelector("#senha").value,
        confSenha: formulario.querySelector("#conf-senha").value
    };

    var erros = validaUsuario(usuario);
    var ul = document.querySelector("#erros");

    if(erros.length > 0){
        var ul = ""; 
        event.preventDefault();
        for(let i=0; i < erros.length; i++){
           var li = document.createElement("li");
        };
        li.textContent = erros[i];
        ul.appendChild(li);
    };

});
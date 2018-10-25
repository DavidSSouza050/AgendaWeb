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
    var ul = document.querySelector("#mensagens-erro");
    ul.textContent = "";
    
     if(erros.length > 0){ 
         event.preventDefault();
         ul.classList.add("pt-2");
         ul.classList.add("pb-2");
         for(let i=0; i < erros.length; i++){
             var li = document.createElement("li");
             li.style.color = "red";
             li.textContent = erros[i];	
             ul.appendChild(li);
          };
        
     };

});
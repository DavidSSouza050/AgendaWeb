var btn = document.querySelector("#bt-CriarContato");

btn.addEventListener("click", function(){
    
    var formulario = document.querySelector("#contato");
    var contato = {
        nome: formulario.querySelector("#txt-nome").value,
        telefone: formulario.querySelector("#txt-telefone").value,
        email: formulario.querySelector("#txt-email").value,
        endereco: formulario.querySelector("#txt-endereco").value,
    };

    var errosContato = ValidarContato(contato);
    var ul = document.querySelector("#mensagens-erroContato");
    ul.textConten = "";
    
     if(errosContato.length > 0){ 
         event.preventDefault();
         ul.classList.add("pt-2");
         ul.classList.add("pb-2");
         for(let i=0; i < errosContato.length; i++){
             var li = document.createElement("li");
             li.style.color = "red";
             li.textContent = errosContato[i];	
             ul.appendChild(li);
          };
        
     };

});
var btn = document.querySelector("#bt-CriarCompromisso");

btn.addEventListener("click", function(){
    
    var formulario = document.querySelector("#compromisso");
    var compromisso = {
        titulo: formulario.querySelector("#txt-titulo").value,
        data: formulario.querySelector("#txt-data").value,
        horaInicio: formulario.querySelector("#txt-horaInicio").value,
        horaFim: formulario.querySelector("#txt-horaFim").value
    };

    var errosCompromisso = validaCompromisso(compromisso);
    var ul = document.querySelector("#mensagens-errosCompromisso");
    ul.textConten = "";
    
     if(errosCompromisso.length > 0){ 
         event.preventDefault();
         ul.classList.add("pt-2");
         ul.classList.add("pb-2");
         for(let i=0; i < errosCompromisso.length; i++){
             var li = document.createElement("li");
             li.style.color = "red";
             li.textContent = errosCompromisso[i];	
             ul.appendChild(li);
          };
        
     };

});
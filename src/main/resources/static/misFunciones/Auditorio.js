function autoInicioAuditorios(){
    console.log("se esta ejecutando")
    $.ajax({
        url:"http://localhost:8080/api/Audience/all",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarRespuesta2(respuesta);
            let $select = $("#select-category");
            $.each(respuesta, function (id, name) {
                $select.append('<option value='+name.id+'>'+name.name+'</option>');
                console.log("select "+name.id);
            }); 
        }
    })
}
function listarRespuesta2(respuesta){

    let myTable="<table>";
    for(i=0;i<respuesta.length;i++){
        myTable+="<tr>";
        myTable+="<td>"+respuesta[i].name+"</td>";
        myTable+="<td>"+respuesta[i].owner+"</td>";
        myTable+="<td>"+respuesta[i].capacity+"</td>";
        myTable+="<td>"+respuesta[i].description+"</td>";
        myTable+="<td>"+respuesta[i].category.name+"</td>";
        myTable+="<td> <button onclick=' actualizarInformacionAuditorios("+respuesta[i].id+")'>Actualizar</button>";
        myTable+="<td> <button onclick='borrarAuditorio("+respuesta[i].id+")'>Borrar</button>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultado2").html(myTable);
}

function guardarInformacionAuditorios(){
    let var2 = {
        name:$("#Aname").val(),
        owner:$("#Aowner").val(),
        capacity:$("#Acapacity").val(),
        description:$("#Adescription").val(),
        category: {id:+$("#select-tipo").val()},
        };
       
        console.log(var2);
        $.ajax({
        type:'POST',
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        data: JSON.stringify(var2),
        url:"http://localhost:8080/api/Audience/save",    
        
        success:function(response) {
                console.log(response);
            console.log("Se guardó correctamente");
            alert("Se guardó correctamente");
            window.location.reload()
    
        },
        
        error: function(jqXHR, textStatus, errorThrown) {
              window.location.reload()
            alert("No se guardó correctamente");
    
    
        }
        });

}

function actualizarInformacionAuditorios(idElemento){
    let myData={
        id:idElemento,
        name:$("#Aname").val(),
        owner:$("#Aowner").val(),
        capacity:$("#Acapacity").val(),
        description:$("#Adescription").val(),
        category: {id:+$("#select-tipo").val()},


    };
    console.log(myData);
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Audience/update",
        type:"PUT",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            $("#id").val("");
            $("#Aname").val("");
            $("#Aowner").val("");
            $("#Acapacity").val("");
            $("#Adescription").val("");
            $("#select-tipo").val("");
            autoInicioAuditorios();
            alert("se ha Actualizado correctamente Auditorios")
        }
    });

}

function borrarAuditorio(idElemento){
    let myData={
        id:idElemento
    };
    let dataToSend=JSON.stringify(myData);
    $.ajax({
        url:"http://localhost:8080/api/Audience/"+idElemento,
        type:"DELETE",
        data:dataToSend,
        contentType:"application/JSON",
        datatype:"JSON",
        success:function(respuesta){
            $("#resultado").empty();
            autoInicioAuditorios();
            alert("Se ha Eliminado.")
        }
    });

}
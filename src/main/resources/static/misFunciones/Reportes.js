function traerReportesStatus(){
    $.ajax({
        url:"http://localhost:8080/api/Reservation/report-status",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarRespuesta6(respuesta);
        }
    });
    
}
function listarRespuesta6(respuesta){
    let myTable="<table>";
    myTable+="<tr>";
    myTable+="<th>completadas</th>";
    myTable+="<td>"+respuesta.completed+"</td>";
    myTable+="<th>canceladas</th>";
    myTable+="<td>"+respuesta.cancelled+"</td>";
    myTable+="</tr>";
    myTable+="</table>";
    $("#resultadoStatus").html(myTable);
}
function traerReportesDate(){

var fechaInicio = document.getElementById("RpstartDate").value;
var fechaCierre = document.getElementById("RpdevolutionDate").value;
console.log(fechaInicio);
console.log(fechaCierre);

    $.ajax({
        url:"http://localhost:8080/api/Reservation/report-dates/"+fechaInicio+"/"+fechaCierre,
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarRespuestaDate(respuesta);
        }
    });
}
function listarRespuestaDate(respuesta){
    let myTable="<table>";
    myTable+="<tr>";

    for(i=0;i<respuesta.length;i++){
        myTable+="<th>total</th>";
        myTable+="<td>"+respuesta[i].devolutionDate+"</td>";
        myTable+="<td>"+respuesta[i].startDate+"</td>";
        myTable+="<td>"+respuesta[i].status+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultadoDate").html(myTable);
}
function traerReportesClientes(){
    $.ajax({
        url:"http://localhost:8080/api/Reservation/report-clients/",
        type:"GET",
        datatype:"JSON",
        success:function(respuesta){
            console.log(respuesta);
            listarRespuestaClientes(respuesta);
        }
    });
}
function listarRespuestaClientes(respuesta){
    let myTable="<table>";
    myTable+="<tr>";

    for(i=0;i<respuesta.length;i++){
        myTable+="<th>total</th>";
        myTable+="<td>"+respuesta[i].total+"</td>";
        myTable+="<td>"+respuesta[i].client.name+"</td>";
        myTable+="<td>"+respuesta[i].client.email+"</td>";
        myTable+="<td>"+respuesta[i].client.age+"</td>";
        myTable+="</tr>";
    }
    myTable+="</table>";
    $("#resultadoClientes").html(myTable);
}
/**
 * Created by Echo01 on 5/3/2017.
 */
function  move_elements() {
    var table = document.getElementById('employeeT'),
        inputHash = {
            '0':'idField','1':'nameField','2':'jobField','3':'subjectidField','4':'salaryField'
        };
    for ( var i in inputHash )
        inputHash[ i ] = document.getElementById( inputHash[ i ] );

    table.addEventListener( 'click', function( evt ) {
        var target = evt.target;
        document.getElementById('updateBtn').removeAttribute('disabled');
        document.getElementById('del').removeAttribute('disabled');
        if ( target.nodeName != 'TD' )
            return;

        var columns = target.parentNode.getElementsByTagName( 'td' );

        for ( var i = columns.length; i-- ; )
            inputHash[ i ].value = columns[ i ].innerHTML;

        for(var i in inputHash){
            inputHash[i].removeAttribute('disabled');
        }
    });
}
function cleanup() {
    window.addEventListener("beforeunload",function (event) {
        var inHash= {'0':'idField','1':'nameField','2':'jobField','3':'subjectidField','4':'salaryField'};
        for(var i in inHash)inHash[i]=document.getElementById(inHash[i]);
        for(var i in inHash){
            inHash[i].value="";
            inHash[i].disabled=true;
        }
        document.getElementById('updateBtn').disabled = true;
        document.getElementById('del').disabled = true;
    });
}

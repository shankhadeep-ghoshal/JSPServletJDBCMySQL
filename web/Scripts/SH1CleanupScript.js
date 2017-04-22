/**
 * Created by Echo01 on 4/21/2017.
 */
function move_elements() {
    var table = document.getElementById('SH1Table'), inputHash = {
        '0':'idField','1':'fn','2':'ln','3':'phy','4':'chem','5':'maths','6':'pid','7':'cid','8':'mid','9':'tid'
    };
    for(var i in inputHash)inputHash[i] = document.getElementById(inputHash[i]);
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
    var inHash = {
        '0':'idField','1':'fn','2':'ln','3':'phy','4':'chem','5':'maths','6':'pid','7':'cid','8':'mid','9':'tid'
    };
    for(var i in inHash)inHash[i] = document.getElementById(inHash[i]);
    window.addEventListener("beforeunload",function (event) {
        for(var i in inHash){
            inHash[i].value="";
            inHash[i].disabled=true;
        }
        document.getElementById('updateBtn').disabled = true;
        document.getElementById('del').disabled = true;
    });
}


var a = 0;
var b = 1;
var c = 0;
function d() {
    a = a + b;
    postMessage(a);
    setTimeout("d()",c);
}

d();
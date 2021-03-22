function b() {
}

function c() {
    var f = document.getElementById("a").value;
    var g = f.length;
    var h = f.search("");
    if (g === 0) {
    alert("test");
    } else if (h) {
        alert("test 2");
        
    } else {
        window.location = "https://www.google.com/search?q=" + f;
    }
}
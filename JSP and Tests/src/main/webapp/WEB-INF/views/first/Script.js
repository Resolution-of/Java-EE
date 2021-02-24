


function getStorageLength() {
    return Object.keys(sessionStorage).length;
}
function submitForm() {
    if(myFunction() === true)
    {
        let tmp = {};

        tmp.auto = document.getElementsByName("auto")[0].value;
        tmp.name = document.getElementsByName("name")[0].value;
        tmp.number = document.getElementsByName("number")[0].value;
        tmp.date = document.getElementsByName("date")[0].value;
        // let al = '';
        // al += JSON.stringify(tmp);
        // alert(al);

        sessionStorage.setItem(getStorageLength(), JSON.stringify(tmp));
        //window.open("/first/");
    }
}



function outputResult() {
    for (let i = 0; i < sessionStorage.length; i++) {
        let data = JSON.parse(sessionStorage.getItem(sessionStorage.key(i)));
    }

    document.write("<tr><td >№</td>");
    document.write("<td>Car brand</td>");
    document.write("<td>FIO</td>");
    document.write("<td>Car number</td>");
    document.write("<td>Time</td>");


    for (let i = 0; i < sessionStorage.length; i++) {

        let data = JSON.parse(sessionStorage.getItem(sessionStorage.key(i)));

        document.write('<tr><td>' + (i + 1) + "</td>");
        document.write("<td>" + data.auto + "</td>");
        document.write("<td>" + data.name + "</td>");
        document.write("<td>" + data.number + "</td>");
        document.write("<td>" + data.date + "</td>");
    }
}
function redirect(equipmentId) {
    console.log(equipmentId);
    newHref = "http://localhost:8081/data/" + equipmentId
    console.log(newHref);
    window.location.href = newHref;
}
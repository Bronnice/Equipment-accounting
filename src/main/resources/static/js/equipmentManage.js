function createNewEquipment() {
    var equipmentAdAddressId = document.getElementById("createButton").getAttribute("data-equipmentId");
    console.log(equipmentAdAddressId);
    if (equipmentAdAddressId) {
        document.getElementById("equipmentAdAddressId").value = equipmentAdAddressId;
        showCreateModal();
    } else {
        console.error("Не удалось получить значение 'equipmentAdAddressId'.");
    }
}

// Функция для отображения модального окна создания нового элемента
function showCreateModal() {
    document.getElementById("createModal").style.display = "block";
}

// Закрываем модальное окно при клике вне его области
window.onclick = function(event) {
    var modal = document.getElementById('createModal');
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

// Обработка отправки формы создания нового элемента оборудования
document.getElementById("createForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Предотвращаем стандартное действие формы (отправку запроса)

    var form = event.target; // Получаем форму

    // Отправляем POST-запрос на сервер с помощью fetch API
    fetch(form.action, {
        method: "POST",
        body: new FormData(form) // Используем FormData для передачи данных формы
    })
    .then(function(response) {
        if (response.ok) {
            // Если запрос выполнен успешно, перезагружаем страницу для обновления списка оборудования
            window.location.reload();
        } else {
            // Если возникла ошибка, выводим сообщение об ошибке
            console.error("Ошибка при создании элемента оборудования:", response.statusText);
        }
    })
    .catch(function(error) {
        console.error("Ошибка при выполнении запроса:", error);
    });
});

function redirect(equipmentId) {
    console.log(equipmentId);
    newHref = "http://localhost:8081/fullData/" + equipmentId
    console.log(newHref);
    window.location.href = newHref;
}
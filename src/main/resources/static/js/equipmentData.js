document.addEventListener("DOMContentLoaded", function() {
    // Находим кнопку сохранения по классу
    var saveButton = document.querySelector(".submit-btn");

    // Назначаем обработчик события на клик по кнопке
    saveButton.addEventListener("click", function(event) {
        event.preventDefault(); // Предотвращаем стандартное поведение кнопки

        // Получаем значения из полей ввода
        var floor = document.getElementById("floor").value;
        var room = document.getElementById("room").value;
        var processorModel = document.getElementById("processorModel").value;
        var coreCount = document.getElementById("coreCount").value;
        var baseFrequency = document.getElementById("baseFrequency").value;
        var ramType = document.getElementById("ramType").value;
        var ramSize = document.getElementById("ramSize").value;
        var hddSize = document.getElementById("hddSize").value;

        // Формируем объект с данными
        var data = {
            floor: floor,
            room: room,
            systemBlock: {
                processorModel: processorModel,
                coresCount: coreCount,
                clockFrequency: baseFrequency,
                ramType: ramType,
                ramCapacity: ramSize,
                hddCapacity: hddSize
            }
        };

        // Отправляем данные на сервер методом POST
        fetch('/saveData', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Обработка успешного ответа от сервера
            alert('Данные успешно сохранены!');
        })
        .catch(error => {
            // Обработка ошибок
            console.error('There was an error!', error);
            alert('Произошла ошибка при сохранении данных');
        });
    });
});
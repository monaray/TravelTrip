#TravelTrip

Целью проекта является автоматизация работы туристической фирмы с помощью реализации в виде мобильного приложения.
TravelTrip поможет легко и быстро управлять работой туристической фирмы.

Пользователь имеет возможность:
1. Добавить нового туроператора в базу данных с полями: название туроператора, электронная почта, номер телефона, адрес сайта.
2. Создавать туры с полями: название тура, туроператор, страна, город, дата начала тура, дата конца тура, количество людей, количество звезд отеля, цена.
3. Удалять элементы таблиц туроператоры и туры из выпадающего списка по названию и очистить таблицы полностью.
4. Просмотр таблиц туроператоры и туры.
5. Быстрое создание заказ с переадресацию на почтовый клиент с переносом информации с мобильного приложения в почту.

В качестве базы данных используется база данных SQLite для разработчиков мобильных приложений.
Для того, чтобы выполнять переадресацию на почтовый клиент с последующим переносом данных необходимо определить основной метод реализации этой цели, а именно класс Intent.


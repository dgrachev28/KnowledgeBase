$(document).ready(function() {
    var $menu = $('.menu');

    //Создание контекстного меню при нажатии на правую кнопку мыши

    $menu.on('contextmenu', '.menu__title', function (event) {
        $('.context-menu').remove();
        var contextMenu = $('<div></div>');
        contextMenu.addClass('context-menu');
        contextMenu.append('<div class="context-menu__title">Select the action</div>');
        contextMenu.append('<div class="context-menu__item context-menu__rename">Rename</div>');
        contextMenu.append('<div class="context-menu__item context-menu__remove">Remove</div>');
        contextMenu.append('<div class="context-menu__item context-menu__folder">Add folder</div>');
        contextMenu.append('<div class="context-menu__item context-menu__article">Add article</div>');
        contextMenu.css({
            'top': event.clientY - $(this).offset().top,
            'left': event.clientX - $(this).offset().left
        });
        $(this).before(contextMenu);
        return false;
    });

    //Наведение на пункт контекстного меню

    $menu.on('mouseenter', '.context-menu__item', function () {
        $(this).addClass('_hover');
    });

    //Уход курсора с пункта контекстного меню

    $menu.on('mouseleave', '.context-menu__item', function () {
        $(this).removeClass('_hover');
    });

    //Удаление папки/статьи

    $menu.on('click', '.context-menu__remove', function () {
        $(this).closest('.menu__folder').remove();
    });

    //Открытие формы для ввода имени папки/статьи

    $menu.on('click', '.context-menu__rename', function () {
        var $menuFolder = $(this).closest('.menu__folder');
        $menuFolder.children('.menu__title').hide();
        $menuFolder.prepend('<input type="text" class="context-menu__input"/>');
        $('.context-menu__input').trigger('focus');
    });

    //Уход курсора с формы, отправление нового имени на сервер

    $menu.on('blur', '.context-menu__input', function () {
        var $title = $(this).closest('.menu__folder').children('.menu__title');
        var titleValue = $(this).val();
        if (titleValue != "") {
            $title.html(titleValue);
        }
        $(this).remove();
        $title.show();

        $.ajax({
            method: "POST",
            url: "ajax/renameFolder.html",
            data: {catalogId: $title.data("id"), title: titleValue}
        });
    });


    //Потеря фокуса (для контекстного меню) при нажатии на Enter

    $(document).keypress(function (event) {
        if (event.keyCode == 13) {
            $('.context-menu__input').trigger('blur');
        }
    });

    //Потеря фокуса (для контекстного меню) при нажатии на область вне контекстного меню

    $(document).click(function() {
        if (!($(event.target).hasClass('context-menu'))) {
            $('.context-menu').remove();
        }
    });
});

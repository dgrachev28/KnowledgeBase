$(document).ready(function() {
    var $menu = $('.menu');

    //Наведение на пункт меню

    $menu.on('mouseenter', '.menu__title', function() {
        $(this).addClass('_hover');
        $(this).siblings('.menu__icon').addClass('_hover');
    });

    //Уход курсора с пункта меню

    $menu.on('mouseleave', '.menu__title', function() {
        $(this).removeClass('_hover');
        $(this).siblings('.menu__icon').removeClass('_hover');
    });

    //Раскрытие меню при нажатии

    $menu.on('click', '.menu__title', function() {
        $(this).parent('.menu__folder').toggleClass('_opened');
    });

    //Открытие статьи

    $menu.on('click', '.menu__article .menu__title', function() {
        var $title = $(this).closest('.menu__folder').children('.menu__title');
        //var openedFolderIdArray = $('.menu__folder_opened>.menu__title').map(function () {
        //    return $(this).data("id");
        //});
        //console.log(openedFolderIdArray);

        $.ajax({
            method: "POST",
            url: "ajax/article.html",
            data: { catalogId: $title.data("id") },
            success: function(url) {

                window.location.href = "/article.html";
            }
        });
    });
});
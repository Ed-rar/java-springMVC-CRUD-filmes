$(document).ready(function () {
    const inputTitle = $('#titulo');
    const inputGenre = $('#genero');
    const inputYear = $('#anoLancamento');
    const form = $('.form');
    let submitFlag = false;

    // Verifica se o campo foi clicado para depois apresentar a validação
    inputTitle.click(function () {
        $(this).data('clicked', true);
    });
    inputGenre.click(function () {
        $(this).data('clicked', true);
    });
    inputYear.click(function () {
        $(this).data('clicked', true);
    });

    form.on('submit', function (e) {
        e.preventDefault();

        // Verifica se o formulário já foi enviado
        if (submitFlag) {
            return;
        }

        // Valida os campos de título, gênero e ano de lançamento
        const isValidTitle = validate(inputTitle);
        const isValidGenre = validate(inputGenre);
        const isValidYear = validate(inputYear);

        // Verifica se algum campo está inválido
        if (!isValidTitle || !isValidGenre || !isValidYear) {
            console.log('Campos inválidos');
            return;
        }

        // Submete o formulário via AJAX se os campos forem válidos
        submitFlag = true;

        $.post({
            url: form.attr('action'),
            data: form.serialize(),
            success: function () {
                console.log('Formulário enviado com sucesso');
                $('.success-message').removeClass('d-none');
            },
            error: function () {
                console.log('Erro ao enviar o formulário');
            }
        });
    });
});

// Restante do código para validação dos campos e exibição das mensagens
function validate(elem) {
    if (elem.val() === '') {
        console.log('O campo ' + elem.attr('name') + ' é obrigatório.');

        // Verifica se o campo foi clicado antes de exibir a mensagem de validação
        if (elem.data('clicked')) {
            elem.parent().find('.text-muted').show();
            elem.addClass('invalid');
        }
        return false;
    } else {
        elem.parent().find('.text-muted').hide();
        elem.removeClass('invalid');
    }
    return true;
}

$('body').on('blur', '#titulo', function () {
    validate($(this));
});

$('body').on('blur', '#genero', function () {
    validate($(this));
});

$('body').on('blur', '#anoLancamento', function () {
    validate($(this));
});

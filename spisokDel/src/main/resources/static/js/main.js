$(function(){

    const appendPurpose = function(data){
        var purposeCode = '<a href="#" class="purpose-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#purpose-list')
            .append('<div>' + purposeCode + '</div>');
    };

    //Show adding book form
    $('#show-add-purpose-form').click(function(){
        $('#purpose-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#purpose-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting book
    $(document).on('click', '.purpose-link', function(){
        var link = $(this);
        var purposeId = link.data('id');
        $.ajax({
            method: "GET",
            url: '' + purposeId,
            success: function(response)
            {
                var code = '<span>Дедлайн:' + response + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Задача не найдена!');
                }
            }
        });
        return false;
    });

    //Adding book
    $('#save-purpose').click(function()
    {
        var data = $('#purpose-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/purposes/',
            data: data,
            success: function(response)
            {
                console.log("success")
                $('#purpose-form').css('display', 'none');
                var purpose = {};
                purpose.id = response;
                var dataArray = $('#purpose-form form').serializeArray();
                for(i in dataArray) {
                    purpose[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendPurpose(purpose);
            }
        });
        return false;
    });
});
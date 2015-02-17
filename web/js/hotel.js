$(document).ready(function () {
    var id = $('#id').val();
    $('#' + id).addClass('selected');
});

$('body').on('click', 'li.hotel', function () {
    $('.hotel').removeClass('selected');
    $(this).addClass('selected');
    var ID = $(this).attr("id");
    $('#hotelForm').attr("action", '${contextPath} + "/hotel"%>');
    $('#hotelForm').submit();

});

$("#clear").click(function () {
    $('#hotelForm').find("input, textarea").val("");

});
$("#update").click(function () {
    var id = $('#id').val();
    var name = $('#name').val();
    var address = $('#street').val();
    var city = $('#city').val();
    var state = $('#state').val();
    var zip = $('#zip').val();
    var note = $('#notes').val();
    $('#hotelForm').attr("action", "?id=" + id + "&name=" + name + "&address=" + address + "&city=" + city + "&state=" + state + "&zip=" + zip + "&note=" + note + "&op=update");
    $('#hotelForm').submit();
});
$('#create').click(function () {
    var id = $('#id').val();
    var name = $('#name').val();
    var address = $('#street').val();
    var city = $('#city').val();
    var state = $('#state').val();
    var zip = $('#zip').val();
    var note = $('#notes').val();

    if (name.length < 2 || address.lenght < 2 || city.length < 1 || address < 2 || zip < 1 || note < 1) {

    } else {
        $('#hotelForm').attr("action", "?id=" + id + "&name=" + name + "&address=" + address + "&city=" + city + "&state=" + state + "&zip=" + zip + "&note=" + note + "&op=create");
        $('#hotelForm').submit();
    }
});
$('#delete').click(function () {
    var id = $('#id').val();
    var r = confirm("This will delete this record forever! Is this okay? If not, press cancel.");
    if (r) {
        $('#hotelForm').attr("action", "?id=" + id + "&op=delete");
        $('#hotelForm').submit();
    } else {

    }
});


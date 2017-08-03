/**
 * Created by User on 7/28/2017.
 */
$('#saveProduct').click(function () {

        var names = [];
        var name= $('#productName').val();
        var price= $('#productPrice').val();
        var quantity= $('#productQuantity').val();
        var licence= $('#productLicence').val();

    // $('#productName').val('');

        $.ajax({

            url: '/productSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'GET',
            success: function (res) {
                for (var i in res) {
                    names.push(res[i].name);
                }
                alert(names);
                alert(name);
                for (var j in names) {
                    if (name == names[j]) {
                        alert("product already exists");
                        return false;
                    }
                }

                if (name == "") {
                    alert("Empty field");
                    return false;
                }
            },




            error: function (err) {
                console.log(err)
            }
        });
});
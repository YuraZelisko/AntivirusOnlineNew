/**
 * Created by User on 7/26/2017.
 */
function searchInTable() {
    var names = [];
    $.ajax({
        url: '/productSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                names.push(res[i].name);
            }
            var tr = $("table tbody tr");
            var input, filter;
            input = document.getElementById("searchIn");
            filter = input.value;
            tr.each(function (i) {
                if (names[i].match(new RegExp(filter, 'gi'))) {
                    tr[i].style.display = "";
                }
                else {
                    tr[i].style.display = "none";
                }
            });
        },
        error: function (err) {
            console.log(err)
        }
    })
}


function searchPrices() {
    var prices = [];
    $.ajax({
        url: '/productSearch?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            for (var i in res) {
                prices.push(res[i].price);
            }
            var tr = $("table tbody tr");
            var range_min, range_max;
            range_min = document.getElementById("price-min").value;
            range_max = document.getElementById("price-max").value;
            tr.each(function (i) {
                if (prices[i] >= range_min && prices[i] <= range_max) {
                    tr[i].style.display = "";
                }
                else {
                    tr[i].style.display = "none";
                }
            });
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function changeLabel() {
    $("#amount").val("$" + document.getElementById("price-min").value + " - $" + document.getElementById("price-max").value);
}
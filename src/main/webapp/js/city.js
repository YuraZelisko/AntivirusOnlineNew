/**
 * Created by User on 6/21/2017.
 */

$('#saveCity').click(function () {

    var city = {
        name: $('#cityName').val()
    };

    $('#cityName').val('');

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        data: JSON.stringify(city),
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })
});


loadCities();

function deleteCity(idCity) {

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'DELETE',
        data: JSON.stringify(idCity),
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })

}

function loadCities() {
    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            parseResultFromDb(res);
        },
        error: function (err) {
            console.log(err)
        }
    })

};


function updateCity(idCity) {

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'GET',
        success: function (res) {
            var citiesFromDb = '';
            for (var i in res) {

                if(res[i].id == idCity){
                    citiesFromDb += '<tr><td><input type="text" class="form-control" value="'+res[i].name+'" id="newCityName"></td><td><button class="btn btn-default save" onclick="saveCityUpdates(' + res[i].id + ')">save updates</button></td></tr>';
                }else{
                    citiesFromDb += '<tr><td id=' + res[i].id + "city" + '>' + res[i].name + '</td><td></td></tr>';
                }

            }
            document.getElementById('result').innerHTML = citiesFromDb;
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function saveCityUpdates(idCity) {

    var newName = $('#newCityName').val();

    $.ajax({

        url: '/city?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        method: 'PUT',
        data: newName+'_'+idCity,
        success: function (res) {

            parseResultFromDb(res);
            console.log(res)

        },
        error: function (err) {
            console.log(err)
        }
    })

}

function parseResultFromDb(res) {
    var citiesFromDb = '';

    for (var i in res) {
        citiesFromDb += '<tr><td id=' + res[i].id + "city" + '>' + res[i].name + '</td><td><button class="btn btn-default updateCity '+res[i].id+'" onclick="updateCity(' + res[i].id + ')">update</button></td><td><button class="btn btn-default" id="deleteCity" onclick="deleteCity(' + res[i].id + ')">delete</button></td></tr>';
    }

    document.getElementById('result').innerHTML = citiesFromDb;

}